package com.demoes;

import java.util.Date;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

import com.airline.staff.Pilot;

public class SetCollectionsDemo {
	static Scanner scanner =  new Scanner(System.in);
	
	public static void main(String[] args) {
		
		//ArrayList demo
		
		// NOTE: Order in which we add may not be preserved in case of Hashset. 
		// TreeSet - elements will be added in sorted manner.
		
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
		
		
		
		
		System.out.println("\n\n PILOT LIST DEMO : ");
		Set<Pilot> setOfPilots =  new HashSet<Pilot>();//new LinkedList<Pilot>(); or new Vector<Pilot>();
		
		Pilot p0 = createPilot();
		setOfPilots.add(p0);
		
		Pilot p1 = createPilot();
		setOfPilots.add(p1);
		
		Pilot p2 = createPilot();
		Pilot p3 = createPilot();
		
		setOfPilots.add(p2);
		setOfPilots.add(p3);
		setOfPilots.add(p0); // duplicate, so ignored
		
		System.out.println("Size of setOfPilots is " + setOfPilots.size()); // 4
		
		//Iteration - Try
		System.out.println(" Iteration demo using simplified for loop");
		for(Pilot p : setOfPilots) {
			//System.out.println( p.displayPilotInfo());
			System.out.println( p.getName() + "\t" + p.getExperience() + "\t" + p.getLicense() );
		}
		
		
		
		
		// Searching ...
		// setOfPilots.contains(p0); // true
		
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
