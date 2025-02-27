package com.demoes.multithreading;

public class Plate {

	
	
	synchronized public void addItem(String item, String tName) {

		for (int i = 0; i < 10; i++) {

			System.out.println(tName + " added a " + item + " to the plate.");

			try {
				Thread.sleep(100);// sleep for 100 ms
			} catch (InterruptedException e) {

			}

		}

	}

}
