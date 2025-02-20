package com.airline.staff;

import java.util.Date;

import com.airline.logistics.AirPlane;

public class Pilot {

	// data
	public String name;
	float experience;
	
	protected String license;

	private Date dob;

	// methods
	boolean takeOff(AirPlane plane) {
		boolean success = true;

		return success;
	}

	boolean land(AirPlane plane) {

		boolean success = true;

		return success;

	}
	
	
	public void announce(String message){
		System.out.println(message);
	}
	
	private void updateExperience(float exp ){
		
	}
}
