package com.demoes;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

import com.airline.staff.Pilot;

import com.airline.staff.Pilot;

public class CollectionsDemo {
	static Scanner scanner =  new Scanner(System.in);
	
	public static void main(String[] args) {
		
		//ArrayList demo
		
		List<Integer> arrayList1 = new ArrayList<Integer>();
		
		arrayList1.add(100); // 100 is auto boxed as an Integer automatically
		arrayList1.add(56);
		
		System.out.println("Size of arrayList1 is " + arrayList1.size());
		
		arrayList1.add(77);
		arrayList1.add(23);
		
		
		System.out.println("Size of arrayList1 is " + arrayList1.size());
		
		arrayList1.remove(3);
		System.out.println("Size of arrayList1 after removing element at index 3 is " + arrayList1.size());
		
		
		// Iteration demo
		System.out.println(" Iteration demo 1");
		for(int i=0;i<arrayList1.size();i++) {
			System.out.println(arrayList1.get(i));
		}
		
		System.out.println(" Iteration demo 2");
		for(int elem : arrayList1) {
			System.out.print(elem + "\t");
		}
		
		System.out.println("\n Iteration demo 3");
		arrayList1.forEach( elem ->  System.out.print(elem + "\t") );
		
		
		//sorting
		arrayList1.sort(  (a,b) -> a-b      );
		
		System.out.println("\n Sorted list is : ");
		arrayList1.forEach( elem ->  System.out.print(elem + "\t") );
		
		
		//searching
		System.out.println("\n Searching list for 100 : ");
		boolean is100Present = arrayList1.contains(100);
		System.out.print(is100Present);
		
		
		System.out.println("\n\n PILOT LIST DEMO : ");
		List<Pilot> listOfPilots = new ArrayList<Pilot>();
		
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
