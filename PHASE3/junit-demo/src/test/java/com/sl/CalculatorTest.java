package com.sl;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

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
	
}
