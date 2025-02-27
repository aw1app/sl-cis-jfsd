package com.demoes.multithreading;

public class DosaChef implements Runnable{

	Plate plate;

	public DosaChef(Plate plate) {
		super();
		this.plate = plate;
	}

	public void run() {
		plate.addItem("Dosa", Thread.currentThread().getName());

	}

}
