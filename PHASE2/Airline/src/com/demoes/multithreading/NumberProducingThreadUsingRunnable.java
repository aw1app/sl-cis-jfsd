package com.demoes.multithreading;

public class NumberProducingThreadUsingRunnable implements Runnable{
	
	
	@Override
	public void run() {
		
		for(int i=0;i<100;i++) {
			
			System.out.println(Thread.currentThread().getName() + " i = " + i);
			
			try {
				Thread.sleep(10);
				System.out.println(Thread.currentThread().getName() + " going to sleep for 10 ms " );
			} catch (InterruptedException e) {
				
			} // sleep for 10 ms
			
		}
		
	}

}
