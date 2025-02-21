package com.demoes;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Scanner;

import com.airline.staff.Pilot;

public class MapDemo {

	static Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) {
		
		Map<Long, Pilot> phoneToPilotMap = new HashMap<Long, Pilot>();
		
		Pilot p0 = PilotUtils.createPilot();		
		
		Pilot p1 = PilotUtils.createPilot();		
		
		Pilot p2 = PilotUtils.createPilot();
		Pilot p3 = PilotUtils.createPilot();
		
		phoneToPilotMap.put(9854544345L, p0);
		phoneToPilotMap.put(9677778345L, p1);
		phoneToPilotMap.put(9006456453L, p2);
		phoneToPilotMap.put(9543434445L, p3);
		
		
		//Iteration
		// Use phoneToPilotMap.size() for index based iteration
		System.out.println("Iteration uising simplified for loop");
		for( Entry<Long, Pilot> entry : phoneToPilotMap.entrySet()) {
			long phoneNo = entry.getKey();
			Pilot p = entry.getValue();
			
			System.out.println(phoneNo + " phone number is with Pilot " + p.getName());			
		};
		
		System.out.println("Iteration uising simplified foreaCH Method");
		phoneToPilotMap.forEach(  
				( phoneNo, pilot)   -> 
		System.out.println(phoneNo + " phone number is with Pilot " + pilot.getName()) 
		);
		
		//Application of Maps
		System.out.println(" ------ ");
		System.out.println("Enter a phone number");
		long phoneNumberToSearch = scanner.nextLong();
		Pilot p =  phoneToPilotMap.get(phoneNumberToSearch);
		
		if(p !=  null) {
			System.out.println(" Pilot found with the given phone number");
			System.out.println(p.displayPilotInfo());
		}else {
			System.out.println(" Pilot with the given phone number not found in the map");
		}

	}

}
