package com.demoes;

import java.util.Date;
import java.util.Scanner;

import com.airline.staff.Pilot;

public class PilotUtils {
	static Scanner scanner =  new Scanner(System.in);
	
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
