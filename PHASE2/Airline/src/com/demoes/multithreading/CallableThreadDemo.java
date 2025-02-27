package com.demoes.multithreading;

import java.util.Random;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

public class CallableThreadDemo {

	public static void main(String[] args) {
		// Create an ExecutorService with a fixed thread pool
		ExecutorService executor = Executors.newFixedThreadPool(2);

		Future<Integer> future1 = null;
		Future<Integer> future2 = null;

		Random random = new Random();

		Callable<Integer> complexCal1 = new ComplexCalculation("Task 1", random);
		Callable<Integer> complexCal2 = new ComplexCalculation("Task 2", random);

		future1 = executor.submit(complexCal1);
		future2 = executor.submit(complexCal2);

		// Get results from futures with timeout

		int result1;
		try {
			result1 = future1.get(5, TimeUnit.SECONDS); // time out of 5 ms
			
			System.out.println("Result from Task 1: " + result1);

			int result2 = future2.get(10, TimeUnit.SECONDS);// time out of 10 ms
			System.out.println("Result from Task 2: " + result2);			
			
		} catch (InterruptedException | ExecutionException | TimeoutException e) {
			System.out.println(e);
		}
		

	}

}
