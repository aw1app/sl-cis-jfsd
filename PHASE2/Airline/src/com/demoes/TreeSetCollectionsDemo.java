package com.demoes;

import java.util.Date;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

import com.airline.staff.Pilot;

public class TreeSetCollectionsDemo {
	static Scanner scanner =  new Scanner(System.in);
	
	public static void main(String[] args) {	
		
		
		System.out.println("\n\n PILOT SORTED SET  DEMO : ");
		Set<Pilot> setOfPilots =  new TreeSet<Pilot>();
		
		Pilot p0 = createPilot();
		setOfPilots.add(p0);
		
		Pilot p1 = createPilot();
		setOfPilots.add(p1);
		
		Pilot p2 = createPilot();
		Pilot p3 = createPilot();
		
		setOfPilots.add(p2);
		setOfPilots.add(p3);
		setOfPilots.add(p0); // duplicate, so ignored
		
		System.out.println("Size of setOfPilots is " + setOfPilots.size()); // 4
		
		//Iteration - Try
		System.out.println(" Iteration demo using simplified for loop. Because we are using Treeset, it"
				+ "will display in Sorted manner based on experience");
		for(Pilot p : setOfPilots) {
			//System.out.println( p.displayPilotInfo());
			System.out.println( p.getName() + "\t" + p.getExperience() + "\t" + p.getLicense() );
		}	
		
		
		
	}
	
	
	public static Pilot createPilot() {
		System.out.println("Enter Pilot's name:");
		String name = scanner.next();
		
		System.out.println("Enter Pilot's exp in years:");
		float exp = scanner.nextFloat();
		
		System.out.println("Enter Pilot's license number:");
		long license = scanner.nextLong();
		
		System.out.println("Enter Pilot's dob in yyyy-mm-dd format:");
		String dateStr =  scanner.next();
//		String[] dateParts = date.split("-");
		Date dob = new Date();
		
		Pilot p = new Pilot(name,exp,license, dob );
		
		return p;		
	}
	
	

}
