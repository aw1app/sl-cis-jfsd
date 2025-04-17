package com.sl.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sl.entity.UserProfile;
import com.sl.repositry.UserProfileRepositry;

@RestController
@RequestMapping("/userprofile")
public class UserProfileController {

	@Autowired
	UserProfileRepositry userProfileRepositry;
	
	@GetMapping("/details/{id}")
	public UserProfile getUserProfile(@PathVariable("id") String id ) {
		Optional<UserProfile> optionalUserprofile = userProfileRepositry.findById(id);
		
		return optionalUserprofile.orElse(null);		
	}
	
	@GetMapping("/list")
	public List<UserProfile> getAllUserProfiles(){
		return userProfileRepositry.findAll();
	}
	
	@PostMapping("add-user-profile")
	public UserProfile addUserProfile(@RequestBody UserProfile userProfile){
		return userProfileRepositry.save(userProfile);
	}

}
