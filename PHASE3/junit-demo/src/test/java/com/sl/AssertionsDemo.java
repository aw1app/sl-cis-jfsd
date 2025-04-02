package com.sl;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class AssertionsDemo {

	@Test
	void test() {

		String str = null;
		String str2 = "some value";

		String[] a1 = { "A", "B" };
		String[] a2 = { "A", "B" };

		int a = 4;
		int b = 0;

		assertTrue(a > b);

		assertFalse(5 < 1);

		assertNull(str);
		assertNotNull(str2);

		assertSame(str, str);
		assertNotSame(str, str2);

		assertArrayEquals(a1, a2);

		assertThrows(RuntimeException.class, () -> {
			throw new RuntimeException();
		});

	}

	@Test
	void testDivide() {

		Calculator calc = new Calculator();

		int a = 1;
		int b = 0;
		
		assertThrows(
				ArithmeticException.class,
				() -> {
					calc.divide(a, b);
				}
				);
		
	}

}
