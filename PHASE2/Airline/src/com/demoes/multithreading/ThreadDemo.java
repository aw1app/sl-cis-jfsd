package com.demoes.multithreading;

public class ThreadDemo {

	public static void main(String[] args) {
		
		mainDemoUsingExtendingThreadClass();

		System.out.println(Thread.currentThread().getName());

		NumberProducingThreadUsingRunnable np1 = new NumberProducingThreadUsingRunnable();
		Thread t1 = new Thread(np1);
		t1.setName("NP1");

		t1.start();
		
		
		NumberProducingThreadUsingRunnable np2 = new NumberProducingThreadUsingRunnable();
		Thread t2 = new Thread(np2);
		t2.setName("NP2");

		t2.start();		
		

		for (int i = 0; i < 50; i++) {

			System.out.println(Thread.currentThread().getName() + " i = " + i);

		}

	}
	
	
	
	
	public static void mainDemoUsingExtendingThreadClass() {

		System.out.println(Thread.currentThread().getName());

		NumberProducingThread np1 = new NumberProducingThread();
		np1.setName("NP1");

		np1.start();
		
		
		NumberProducingThread np2 = new NumberProducingThread();
		np2.setName("NP2");

		np2.start();
		
		

		for (int i = 0; i < 50; i++) {

			System.out.println(Thread.currentThread().getName() + " i = " + i);

		}

	}

}
