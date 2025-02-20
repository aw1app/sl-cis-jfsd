package com.airline.logistics;

public class AirPlane {

	
	public String name;
	public String source;
	public String destination;
	
	public int fare;

	public AirPlane(String name, String source, String destination, int fare) {
		super();
		this.name = name;
		this.source = source;
		this.destination = destination;
		this.fare = fare;
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
	
}
