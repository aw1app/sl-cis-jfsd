package com.airline.staff;

import java.util.Date;

import com.airline.logistics.AirPlane;

public class Pilot implements Comparable<Pilot>{

	// data
	public String name="PILOT000";
	float experience;

	protected long license;

	private Date dob;

	// Default constructor
	public Pilot() {

	}

	// Overloaded constructor
	public Pilot(String name) {
		this.name = name;
	}

	// Overloaded constructor
	public Pilot(String name, float experience) {
		this(name);
		this.experience = experience;
	}
	
	// Overloaded constructor
		public Pilot(String name, float experience, long license) {
			this(name,experience);
			this.license = license;
		}

	// Overloaded constructor
	public Pilot(String name, float experience, long license, Date dob) {
		this(name,experience);
		this.license = license;
		this.dob = dob;
	}

	// methods
	public boolean takeOff(AirPlane plane) {
		boolean success = true;

		return success;
	}

	public boolean land(AirPlane plane) {

		boolean success = true;

		return success;

	}

	public void announce(String message) {
		System.out.println(message);
	}

	private void updateExperience(float exp) {

	}
	
	public String getName() {
		return this.name.toLowerCase();
	}
	
	
	
	public float getExperience() {
		return experience;
	}

	public void setExperience(float experience) {
		this.experience = experience;
	}

	public long getLicense() {
		return license;
	}

	public void setLicense(long license) {
		this.license = license;
	}

	public Date getDob() {
		return dob;
	}

	public void setDob(Date dob) {
		this.dob = dob;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String displayPilotInfo() {
		return this.name + ", " + this.experience;
	}

	@Override
	public int compareTo(Pilot o) {
		
		return (int) (this.getExperience() - o.getExperience());
	}

	
}
