package com.demoes;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Scanner;

import com.airline.staff.Pilot;

public class PriorityQueueDemo {

	static Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) {

		Comparator<Pilot> expComparator = Comparator.comparingDouble(p -> p.getExperience());
		
		PriorityQueue<Pilot> priorityQueue = new PriorityQueue<Pilot>( expComparator ); // FIFO

		Pilot p0 = PilotUtils.createPilot();
		Pilot p1 = PilotUtils.createPilot();
		Pilot p2 = PilotUtils.createPilot();
		Pilot p3 = PilotUtils.createPilot();

		priorityQueue.add(p0);
		priorityQueue.add(p1);
		priorityQueue.add(p2);
		priorityQueue.add(p3);

		// Iteration
		priorityQueue.forEach(

				p -> {
					System.out.println(p.displayPilotInfo());
				}

		);
		
		System.out.println("Polling the PQ");
		while (priorityQueue.size() > 0 ) {
		Pilot p = priorityQueue.poll();
		System.out.println(p.displayPilotInfo());		
		}

	}

	public static void main0(String[] args) {

		PriorityQueue<Integer> priorityQueue = new PriorityQueue<Integer>(); // FIFO

		priorityQueue.add(1);
		priorityQueue.add(11);
		priorityQueue.add(7);
		priorityQueue.add(4);

		// Iteration
		priorityQueue.forEach(

				p -> {
					System.out.println(p);
				}

		);

	}

}
