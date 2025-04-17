package com.sl.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.client.RestTemplate;

import com.sl.entity.UserProfile;

@Controller
@RequestMapping("/user-profile")
public class UserProfileController {

	@Autowired
	RestTemplate restTemplate;

	String userprofileMicroserviceBaseURL = "http://user-profile-microservice/userprofile";

	@GetMapping("/details/{id}")
	public String getDetails(@PathVariable("id") String id, Model model) {

		ResponseEntity<UserProfile> response = restTemplate
				.getForEntity(userprofileMicroserviceBaseURL + "/details/" + id, UserProfile.class);
		
		UserProfile userProfile = response.getBody()	;
		
		model.addAttribute(userProfile);
		
		return "user-profile" ; // resolves webapp/WEB-INF/view/user-profile.jsp

	}

}
