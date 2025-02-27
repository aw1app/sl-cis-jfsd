package com.demoes.multithreading;

public class ThreadDemo {

	public static void main(String[] args) {
		
		//mainDemoUsingExtendingThreadClass();

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
			
			//checking here in main thread if t1 is still executing?...
//			System.out.println("t1.isAlive() = "+  t1.isAlive());
//			System.out.println("t2.isAlive() = "+  t2.isAlive());
			
			try {
				Thread.sleep(10);
				System.out.println(Thread.currentThread().getName() + " going to sleep for 10 ms " );
			} catch (InterruptedException e) {				
			} // sleep for 10 ms

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
