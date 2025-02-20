package com.airline.staff;

import java.util.Date;

public class TrainerPilot extends Pilot{
	// Inherited variable/feilds
	
	// New properties/feilds
	float noOfTrainerExperience;
	
	
	public TrainerPilot(String name, float experience, long license) {
		super(name, experience, license);
		
	}
	
	
	public TrainerPilot(String name, float experience, long license, float noOfTrainerExperience) {
		super(name, experience, license);
		this.noOfTrainerExperience = noOfTrainerExperience;
		
	}


	public float getNoOfTrainerExperience() {
		return noOfTrainerExperience;
	}


	// Overridden
//	@Override
//	public String displayPilotInfo() {
//		return "NAME " + this.name + ", EXP " + this.experience + ", TRAINER EXP " + this.noOfTrainerExperience;
//	}
//	
	
	
}
