package com.sl;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class ProductTest {

	@Test
	void test() {
		Product product = new Product();
		
		product.setName("iPhone 16");
		
		assertEquals("iPhone 16",product.getName() );
	}

}
