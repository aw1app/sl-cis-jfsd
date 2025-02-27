package com.demoes;

import com.airline.logistics.AirPlane;
import com.airline.staff.Pilot;

public class CustomExceptionDemo {

	public static void main(String[] args) {
		
		AirPlane airPlane1 = new AirPlane("AirIndia","DLH", "BLR", 15000 );
		
		Pilot p1 = new Pilot();
		
		try {
			airPlane1.takeOff(p1);
		} catch (PilotNotFoundException e) {
			// some other action
		}

	}

}
