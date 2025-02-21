package com.demoes;

import java.util.Scanner;
import java.util.Stack;

import com.airline.staff.Pilot;

public class StackDemo {

	static Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) {

		Stack<Pilot> pilotStack = new Stack<>();

		Pilot p0 = PilotUtils.createPilot();
		Pilot p1 = PilotUtils.createPilot();
		Pilot p2 = PilotUtils.createPilot();
		Pilot p3 = PilotUtils.createPilot();

		pilotStack.push(p0);
		pilotStack.push(p1);
		pilotStack.push(p2);
		pilotStack.push(p3);

		System.out.println("Stack after pushes: " + pilotStack);

		// Iteration
		pilotStack.forEach(

				p -> {
					System.out.println(p.displayPilotInfo());
				}

		);
		
		//OR
		for( Pilot p : pilotStack) {
			System.out.println(p.displayPilotInfo());
		}
		
		
		// Peeking at the top element
        System.out.println("Top element (peek): " + pilotStack.peek().displayPilotInfo());
        
     // Popping elements (LIFO order)
        while (!pilotStack.isEmpty()) {
            System.out.println("Popped: " + pilotStack.pop().displayPilotInfo());
        }

        System.out.println("Stack after pops: " + pilotStack);

	}

}
