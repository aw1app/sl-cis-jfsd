package com.sl;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class CalculatorDemoSetupFunctionsTest {
	static Calculator calc;
	
	static int a;
	static int b;

	@BeforeAll
	static void setupCalculator() {
		System.out.println("INSIDE @BeforeEach setupCalculator() method");
		calc = new Calculator();
	}

	@AfterAll
	static void clearCalculator() {
		System.out.println("INSIDE @BeforeEach setupCalculator() method");
		calc = null;
	}

	@BeforeEach
	void setupCalculatorParams() {
		System.out.println("INSIDE @BeforeEach setupCalculatorParams() method");
	}

	@AfterEach
	void clearCalculatorParams() {
		System.out.println("INSIDE @AfterEach clearCalculatorParams() method");	
		a=0;
		b=0;
	}

	@Test
	void testAdd1() {
		System.out.println("INSIDE test case testAdd1");
		a = 3;
		b = 2;

		int expectedResult = 5;

		int actualresult = calc.add(a, b);

		// assertion
		assertEquals(expectedResult, actualresult);
	}

	@Test
	void testAdd2() {
		System.out.println("INSIDE test case testAdd2");
		a = -3;
		b = -2;

		int expectedResult = -5;

		int actualresult = calc.add(a, b);

		// assertion
		assertEquals(expectedResult, actualresult);
	}
	
	

}
