package com.demoes;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class ExceptionDemo2 {

	public static void main(String[] args) {

		// int result = 10/0;
		FileReader fr = null;

		try {
			fr = new FileReader("C:\\Users\\home\\sl-cis-jfsd\\PHASE2\\Airline\\src\\phone_nos.txt");

			int c = fr.read();

			System.out.println((char) c);

		} catch (FileNotFoundException e) {

			System.out.println(" File did not exist.");
		} catch (IOException e) {

			System.out.println(" File not readable.");
		} finally {
			System.out.println(" INSIDE finally block.");
			try {
				if (fr != null) {
					fr.close();
					System.out.println(" File closed successfully.");
				}
			} catch (IOException e) {
				System.out.println(" File closing had errors.");
			}
		}

	}

}

//NOTES when you have several catch blocks,
// subclass exceptions should caught before the superclass exception
// Check out which exception is subclass of other from here: 
// https://docs.oracle.com/javase/8/docs/api/java/lang/Exception.html

// NOTE finally block is optional
// Use the finally block to do some cleanup stuff like closing file, closing DB connections,etc
