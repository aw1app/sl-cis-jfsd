package com.sl;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Timeout;

class CalculatorTest {

	@Test
	void testAdd1() {
		System.out.println("INSIDE test case testAdd1");
		Calculator calc = new Calculator();

		int a = 3;
		int b = 2;

		int expectedResult = 5;

		int actualresult = calc.add(a, b);

		// assertion
		assertEquals(expectedResult, actualresult);
	}

	@Test
	@Disabled
	void testAdd2() {
		System.out.println("INSIDE test case testAdd2");
		Calculator calc = new Calculator();

		int a = -3;
		int b = -2;

		int expectedResult = -5;

		int actualresult = calc.add(a, b);

		// assertion
		assertEquals(expectedResult, actualresult);
	}

	@Test
	void testDivide1() {
		System.out.println("INSIDE test case testDivide1");
		Calculator calc = new Calculator();
		int a = 10;
		int b = 2;

		int expectedResult = 5;

		int actualresult = calc.divide(a, b);

		// assertion
		assertEquals(expectedResult, actualresult);
	}

	
	// If the test case takes more time than mentioned in the timeout, it will be marked as failed.
	// In the below testPrintMessage(), if it completes execution within 2 secs, it will be marked as passed.
	@Test
	@Timeout(2)
	public void testPrintMessage() {
		try {
		Thread.sleep(1500); // Will pass
		}catch (Exception e) {
			
		}
		System.out.println("Inside testPrintMessage()");
	}
	
	@Test
	@Timeout(2)
	public void testPrintMessage2() {
		try {
		Thread.sleep(2500); // Will fail
		}catch (Exception e) {
			
		}
		System.out.println("Inside testPrintMessage2()");
	}

}
