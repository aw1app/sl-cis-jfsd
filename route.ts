// app/api/profile/update/route.ts
import { NextRequest, NextResponse } from 'next/server';
import prisma from '@/lib/prisma';
import { createRouteHandlerClient } from '@supabase/auth-helpers-nextjs';
import { cookies } from 'next/headers';
import { Prisma, UserRole } from '@prisma/client';


type UserData = {
  id: string;
  name: string | null;
  email: string;
  bio: string | null;
  githubUrl: string | null;
  twitterUrl: string | null;
  linkedinUrl: string | null;
  avatarUrl: string | null;
  totalScore: number;
  isProfilePublic: boolean;
  showEmail: boolean;
  showBio: boolean;
  showSocialLinks: boolean;
  showSolvedChallenges: boolean;
  emailNotifications: boolean;
};

export async function PUT(req: NextRequest) {
  const supabase = createRouteHandlerClient({ cookies });
  const { data: { session } } = await supabase.auth.getSession();

  if (!session?.user?.email) {
    return NextResponse.json({ error: 'Not authenticated' }, { status: 401 });
  }

  try {
    const {
      name, bio, githubUrl, twitterUrl, linkedinUrl,
      isProfilePublic, showEmail, showBio, showSocialLinks, showSolvedChallenges,
      emailNotifications, avatarUrl
    } = await req.json();

    // Server-side validation
    if (!name || typeof name !== 'string' || name.trim().length === 0) {
      return NextResponse.json({ error: 'Name is required' }, { status: 400 });
    }

    if (name.length > 50) {
      return NextResponse.json({ error: 'Name should not exceed 50 characters' }, { status: 400 });
    }

    if (bio && bio.length > 500) {
      return NextResponse.json({ error: 'Bio should not exceed 500 characters' }, { status: 400 });
    }

    // Get existing data from both sources
    const oldUserData = await prisma.user.findUnique({
      where: { email: session.user.email },
    }) as UserData | null;

    if (!oldUserData) {
      return NextResponse.json({ error: 'User not found' }, { status: 404 });
    }

    // Update Prisma database
    const updatedUser = await prisma.user.update({
      where: { email: session.user.email },
      data: {
        name: name.trim(),
        bio: bio || null,
        githubUrl: githubUrl || null,
        twitterUrl: twitterUrl || null,
        linkedinUrl: linkedinUrl || null,
        isProfilePublic,
        showEmail,
        showBio,
        showSocialLinks,
        showSolvedChallenges,
        emailNotifications,        
        image: avatarUrl || null // Map avatarUrl to image field in User table
      },
      select: {
        id: true,
        name: true,
        email: true,
        bio: true,
        githubUrl: true,
        twitterUrl: true,
        linkedinUrl: true,
        totalScore: true,
        isProfilePublic: true,
        showEmail: true,
        showBio: true,
        showSocialLinks: true,
        showSolvedChallenges: true,
        emailNotifications: true
      }
    }) as unknown as UserData;

    // Update Supabase profile
    const { error: supabaseError } = await supabase
      .from('profiles')
      .update({
        full_name: name.trim(),
        bio,
        github_url: githubUrl,
        twitter_url: twitterUrl,
        linkedin_url: linkedinUrl,
        avatar_url: avatarUrl,
        is_profile_public: isProfilePublic,
        show_email: showEmail,
        show_bio: showBio,
        show_social_links: showSocialLinks,
        show_solved_challenges: showSolvedChallenges,
        email_notifications: emailNotifications
      })
      .eq('id', session.user.id);

    if (supabaseError) {
      console.error('Supabase profile update error:', supabaseError);
    }

    // Calculate solved challenges
    const solvedChallenges = await prisma.submission.groupBy({
      by: ['challengeId'],
      where: {
        userId: updatedUser.id,
        score: { gt: 0 }
      },
      _count: true
    });

    // Calculate old solved challenges
    const oldSolvedChallenges = await prisma.submission.groupBy({
      by: ['challengeId'],
      where: {
        userId: oldUserData.id,
        score: { gt: 0 }
      },
      _count: true
    });

    const totalChallenges = await prisma.challenge.count();

    // Send email notifications for profile updates
    if (updatedUser.emailNotifications) {
      const changedFields = (Object.keys(updatedUser) as Array<keyof UserData>).filter(key =>
        updatedUser[key] !== oldUserData[key] &&
        key !== 'emailNotifications'
      );
      
      if (changedFields.length > 0) {
        await fetch('/api/send-email', {
          method: 'POST',
          headers: { 'Content-Type': 'application/json' },
          body: JSON.stringify({
            to: updatedUser.email,
            subject: 'Profile Updated',
            text: `Your profile has been updated. Changed fields: ${changedFields.join(', ')}`,
            html: `<p>Your profile has been updated.</p><p>Changed fields: ${changedFields.join(', ')}</p>`
          }),
        });
      }
    }

    // Check for achievement milestones
    if (updatedUser.emailNotifications && solvedChallenges.length > 0) {
      const milestones = [10, 25, 50, 100];
      const achievedMilestone = milestones.find(m =>
        solvedChallenges.length >= m && oldSolvedChallenges.length < m
      );

      if (achievedMilestone) {
        await fetch('/api/send-email', {
          method: 'POST',
          headers: { 'Content-Type': 'application/json' },
          body: JSON.stringify({
            to: updatedUser.email,
            subject: 'Achievement Unlocked!',
            text: `Congratulations! You've solved ${achievedMilestone} challenges!`,
            html: `<h1>Achievement Unlocked!</h1><p>Congratulations! You've solved ${achievedMilestone} challenges!</p>`
          }),
        });
      }
    }

    return NextResponse.json({
      ...updatedUser,
      solvedChallenges: solvedChallenges.length,
      totalChallenges
    });
  } catch (error) {
    console.error('Error updating profile:', error);
    return NextResponse.json({ error: 'An error occurred while updating profile' }, { status: 500 });
  }
}