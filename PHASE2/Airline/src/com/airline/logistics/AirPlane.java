package com.airline.logistics;

import com.airline.staff.Pilot;
import com.demoes.PilotNotFoundException;

public class AirPlane {

	
	public String name;
	public String source;
	public String destination;
	
	public int fare;
	
	Engine engine;

	public AirPlane(String name, String source, String destination, int fare) {
		super();
		this.name = name;
		this.source = source;
		this.destination = destination;
		this.fare = fare;
		
		this.engine = new Engine();
	}
	
	public void takeOff(Pilot pilot) throws PilotNotFoundException{
		if(pilot==null) {
			throw new PilotNotFoundException("Pilot was null");
		}
		else
		this.engine.start();
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSource() {
		return source;
	}

	public void setSource(String source) {
		this.source = source;
	}

	public String getDestination() {
		return destination;
	}

	public void setDestination(String destination) {
		this.destination = destination;
	}

	public int getFare() {
		return fare;
	}

	public void setFare(int fare) {
		this.fare = fare;
	}
	
	
	// Inner class
	// private class Engine {
	public static class Engine {
		
		// data
		
		
		// methods
		void start(){
			
		}
		

	}
	
}
