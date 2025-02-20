package com.airline.artifacts;

public class VIPTicket implements TicketInterface{

	@Override
	public void buy() {
		System.out.println("Bought a VIP Ticket");
		
	}

	@Override
	public void use() {
		
		System.out.println("Used  a VIP Ticket");
	}

}
