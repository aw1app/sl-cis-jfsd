package com.demoes.multithreading;

public class ThreadDemo {

	public static void main(String[] args) {

		System.out.println(Thread.currentThread().getName());

		NumberProducingThread np1 = new NumberProducingThread();
		np1.setName("NP1");

		np1.start();
		
		

		for (int i = 0; i < 50; i++) {

			System.out.println(Thread.currentThread().getName() + " i = " + i);

		}

	}

}
