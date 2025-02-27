package com.demoes.multithreading;

public class RotiDosaThreadDemo {

	public static void main(String[] args) {
		Plate plate1 = new Plate();
		
		Runnable rotiChef1 = new RotiChef(plate1);
		Runnable rotiChef2 = new RotiChef(plate1);
		
		Runnable dosaChef1 = new DosaChef(plate1);
		
		Thread rotiChef1Thread = new Thread(rotiChef1);	
		rotiChef1Thread.setName("<ROTI CHEF 1>");
		
		Thread dosaChef1Thread = new Thread(dosaChef1);
		dosaChef1Thread.setName("<DOSA CHEF>");
		
		Thread rotiChef2Thread = new Thread(rotiChef2);	
		rotiChef2Thread.setName("<ROTI CHEF 2>");
		
		rotiChef1Thread.start();
		dosaChef1Thread.start();
		rotiChef2Thread.start();

	}

}
