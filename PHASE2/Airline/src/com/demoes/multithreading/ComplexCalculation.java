package com.demoes.multithreading;

import java.util.Random;
import java.util.concurrent.Callable;

public class ComplexCalculation implements Callable<Integer>{
	
	 private String taskName;
	 private Random random;	 
	 
	
	public ComplexCalculation(String taskName, Random random) {
		super();
		this.taskName = taskName;
		this.random = random;
	}


	@Override
	public Integer call() throws Exception {
		
		 System.out.println(taskName + " starting calculation... in thread : " +Thread.currentThread().getName());
	     
	     // Simulate complex work
	     int calculationTime = random.nextInt(3000) + 1000; // 1-4 seconds
	     Thread.sleep(calculationTime);
	     
	     // Simulate result calculation
	     int result = random.nextInt(100) + 1;
	     
	     System.out.println(taskName + " completed after " + calculationTime + "ms");
	     return result;		
	
	}

}
