package com.sl;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class IgnoreTest {

	@Test
	void testAddition() {
		int sum = 2 + 3;
		assertEquals(5, sum, "2 + 3 should equal 5");
	}

	@Test
	void testSubtraction() {
		int result = 10 - 5;
		assertEquals(5, result, "10 - 5 should equal 5");
	}

	@Test
	void testMultiplication() {
		int result = 4 * 3;
		assertEquals(12, result, "4 * 3 should equal 12");
	}

}
