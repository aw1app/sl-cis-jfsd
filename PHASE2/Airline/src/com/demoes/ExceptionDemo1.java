package com.demoes;

import java.util.Scanner;

public class ExceptionDemo1 {

	static Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) {

		System.out.println("Enter total no of mangoes");
		int x = scanner.nextInt();

		System.out.println("Enter the number of consumers. Do not enter 0");
		int y = scanner.nextInt();

		if (y != 0) {
			float shareOfEachConsumer = x / y;

			System.out.println("Every consumer will get " + shareOfEachConsumer + " mangoes");
		} else {
			System.out.println("Looks like you entered 0. So mango share is 0. Pls don't enter 0 next time");
		}

		System.out.println("Thank you. Visit again");
	}

}
