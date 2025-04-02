package com.sl;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class CalculatorTest {

	@Test
	void testAdd1() {
		Calculator calc = new Calculator();
		
		int a = 3;
		int b = 2;
		
		int expectedResult = 5;
		
		
		int actualresult = calc.add(a, b); 
		
		// assertion
		assertEquals(actualresult,expectedResult);
		
	}
	
	@Test
	void testAdd2() {
		Calculator calc = new Calculator();
		
		int a = -3;
		int b = -2;
		
		int expectedResult = -5;
		
		
		int actualresult = calc.add(a, b); 
		
		// assertion
		assertEquals(actualresult,expectedResult);
		
	}
	
}
