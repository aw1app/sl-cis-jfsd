package com.demoes;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class ExceptionDemo2 {

	public static void main(String[] args) {

		// int result = 10/0;

		try {
			FileReader fr = new FileReader("C:\\Users\\home\\sl-cis-jfsd\\PHASE2\\Airline\\src\\phone_nos.txt");

			int c = fr.read();

		} catch (FileNotFoundException e) {

			System.out.println(" File did not exist.");
		} catch (IOException e) {

			System.out.println(" File not readable.");
		}

	}

}
