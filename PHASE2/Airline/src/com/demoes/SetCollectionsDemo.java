package com.demoes;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

import com.airline.staff.Pilot;

public class SetCollectionsDemo {
	static Scanner scanner =  new Scanner(System.in);
	
	public static void main(String[] args) {
		
		//ArrayList demo
		
		Set<Integer> arraySet1 = new TreeSet<Integer>(); //new HashSet<Integer>();
		
		arraySet1.add(100); // 100 is auto boxed as an Integer automatically
		arraySet1.add(56);
		
		System.out.println("Size of arraySet1 is " + arraySet1.size()); // 4
		
		arraySet1.add(77);
		arraySet1.add(23);
		
		arraySet1.add(77); // ignored
		
		
		System.out.println("Size of arraySet1 is " + arraySet1.size()); // 4 
		
		arraySet1.remove(3);
		System.out.println("Size of arraySet1 after removing element 3 is " + arraySet1.size()); // 4
		
		
		// Iteration demo			
		System.out.println(" Iteration demo 1");
		for(int elem : arraySet1) {
			System.out.print(elem + "\t");
		}
		
		System.out.println("\n Iteration demo 2");
		arraySet1.forEach( elem ->  System.out.print(elem + "\t") );
		
		
			
		//searching
		System.out.println("\n Searching list for 100 : ");
		boolean is100Present = arraySet1.contains(100);
		System.out.print(is100Present);
		
		System.exit(0);
		
		
		System.out.println("\n\n PILOT LIST DEMO : ");
		List<Pilot> listOfPilots =  new ArrayList<Pilot>();//new LinkedList<Pilot>(); or new Vector<Pilot>();
		
		Pilot p0 = createPilot();
		listOfPilots.add(p0);
		
		Pilot p1 = createPilot();
		listOfPilots.add(p1);
		
		Pilot p3 = createPilot();
		Pilot p4 = createPilot();
		
		listOfPilots.add(p3);
		listOfPilots.add(p4);
		
		System.out.println("Size of listOfPilots is " + listOfPilots.size()); // 4
		
		//Iteration - Try
		System.out.println(" Iteration demo using simplified for loop");
		for(Pilot p : listOfPilots) {
			//System.out.println( p.displayPilotInfo());
			System.out.println( p.getName() + "\t" + p.getExperience() + "\t" + p.getLicense() );
		}
		
		// Sorting
		// Challenge: Iterate and display the Pilots sorted according to thier experience
		listOfPilots.sort(  (pilot1,pilot2) ->  
			(int) (pilot1.getExperience() -  pilot2.getExperience()) );
		
		System.out.println(" Pilots sorted as per experience level");
		for(Pilot p : listOfPilots) {
			//System.out.println( p.displayPilotInfo());
			System.out.println( p.getName() + "\t" + p.getExperience() + "\t" + p.getLicense() );
		}
		
		// Searching ...
		
	}
	
	
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
