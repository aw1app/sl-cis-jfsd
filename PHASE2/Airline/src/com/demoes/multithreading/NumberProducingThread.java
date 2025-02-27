package com.demoes.multithreading;

public class NumberProducingThread extends Thread{
	
	@Override
	public void run() {
		
		for(int i=0;i<100;i++) {
			
			System.out.println(Thread.currentThread().getName() + " i = " + i);
			
		}
		
	}

}
