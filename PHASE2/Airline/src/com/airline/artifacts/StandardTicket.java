package com.airline.artifacts;


public class StandardTicket implements TicketInterface{

	@Override
	public void buy() {
		
		System.out.println("Bought a standard Ticket");
	}

	@Override
	public void use() {
		
		System.out.println("Uased a standard Ticket");
	}

}
