import java.util.Date;
import java.util.Scanner;

import org.xml.sax.HandlerBase;

import com.airline.artifacts.StandardTicket;
import com.airline.artifacts.TicketInterface;
import com.airline.logistics.AirPlane;
import com.airline.staff.HelpDesk;
import com.airline.staff.Pilot;
import com.airline.staff.TemporaryHelpDesk;
import com.airline.staff.TrainerPilot;
import com.demoes.Engine;

public class AirlineMain {
	static Scanner scanner =  new Scanner(System.in);
	

	public static void main(String[] args) {
		AirPlane a0 = createAirPlane(scanner);
		
		// AirPlane.Engine e1 = a0.new Engine();
		
		// HelpDesk hd1 = new HelpDesk(); // Invalid
		HelpDesk hd1 = new TemporaryHelpDesk(); // Valid
		hd1.provideSuggestion();
		
		// hd1.x=1001; // invalid because we cannot re-assign because x is decl as final
		
		TicketInterface ticket1 = new StandardTicket();
		ticket1.buy();
		ticket1.use();
		
//		Pilot p1 = new Pilot();
//		
//		p1.name = "Rakesh";
//		p1.experience = 10.5f;  // invalid assignment due to access level
		
		
		
//		System.out.println(" ** Creating first Pilot **");
//		System.out.println("Enter Pilot's name:");
//		String name = scanner.next();
//		
//		System.out.println("Enter Pilot's exp in years:");
//		float exp = scanner.nextFloat();
//		
		//Pilot p1 = new Pilot("Rakesh",10.5f );
		
//		Pilot p1 = new Pilot(name,exp);		
//
//		System.out.println("Display Pilot p1's details:");
//		System.out.println(p1.displayPilotInfo());	
		
		
		//Create the second Pilot
//		System.out.println(" ** Creating another Pilot **");
//		Pilot p2 =createPilot(scanner);
//		
//		System.out.println("Display Pilot p2's details:");
//		System.out.println(p2.displayPilotInfo());	
//		
//		
//		AirPlane a1 = createAirPlane(scanner);
//		
//		
//		boolean isSuccess = p2.takeOff(a1);
//		
//		System.out.println(" Plane Take off is " + isSuccess);
		
		
		// Inheritance in action
		TrainerPilot tp1 = new TrainerPilot("Sudhkar", 10.0f, 4785678578578L);
		System.out.println(tp1.name); //? "PILOT000" ??  or "Sudhkar"?
		
		System.out.println(tp1.displayPilotInfo());
		
		
		TrainerPilot tp2 = new TrainerPilot();
		System.out.println(tp2.name); //? "PILOT000" ??  or "TRAINER-PILOT000"
		
		
		Pilot tp3 = new TrainerPilot();
		System.out.println("TP3 name is  tp3.name" + tp3.name); //? "PILOT000" ??  or "TRAINER-PILOT000"
		System.out.println("TP3 name is from  tp3.getName() " + tp3.getName()); //"pilot000" ??  or "TRAINER-PILOT000"
		
		//System.out.println(tp3.displayPilotInfo()); // name&exp? or name&exp&traineExp?
		
		
		
		
		scanner.close();
	}
	
	public static Pilot createPilot(Scanner scanner) {
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
	
	
	public static AirPlane createAirPlane(Scanner scanner) {
		System.out.println("Enter Airplane name:");
		String name = scanner.next();
		
		System.out.println("Enter Airplane source:");
		String source = scanner.next();
		
		System.out.println("Enter Airplane destination:");
		String dest = scanner.next();
		
		System.out.println("Enter Airplane fare:");
		int fare =  scanner.nextInt();
		
		AirPlane a = new AirPlane(name,source,dest, fare );
		
		return a;		
	}

}

//CHALLENGE: Modify the above program to create a pilot with all the feilds values
