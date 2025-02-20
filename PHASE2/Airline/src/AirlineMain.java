import java.util.Scanner;

import com.airline.staff.Pilot;

public class AirlineMain {

	public static void main(String[] args) {
		
//		Pilot p1 = new Pilot();
//		
//		p1.name = "Rakesh";
//		p1.experience = 10.5f;  // invalid assignment due to access level
		
		
		Scanner scanner =  new Scanner(System.in);
		
		System.out.println("Enter Pilot's name:");
		String name = scanner.nextLine();
		
		System.out.println("Enter Pilot's exp in years:");
		float exp = scanner.nextFloat();
		
		//Pilot p1 = new Pilot("Rakesh",10.5f );
		
		Pilot p1 = new Pilot(name,exp);
		

		System.out.println("Display Pilot's details:");
		System.out.println(p1.displayPilotInfo());
		
		scanner.close();
	}

}
