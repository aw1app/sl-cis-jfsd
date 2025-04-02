package com.sl;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.condition.EnabledOnJre;
import org.junit.jupiter.api.condition.EnabledOnOs;
import org.junit.jupiter.api.condition.JRE;
import org.junit.jupiter.api.condition.OS;

class ConditionalTestsDemo {

	@Test
	@EnabledOnOs({ OS.WINDOWS })
//	@EnabledOnJre({JRE.JAVA_17})
	public void testAddOnWindows() {

		System.out.println("INSIDE testAddOnWindows");

		Calculator cal = new Calculator();

		int x = 2;
		int y = 5;

		assertEquals(7, cal.add(x, y));
	}
	
	@Test
	@EnabledOnOs({ OS.MAC })
	public void testAddOnMacOS() {

		System.out.println("INSIDE testAddOnMacOS");

		Calculator cal = new Calculator();

		int x = 12;
		int y = 15;

		assertEquals(27, cal.add(x, y));
	}

}
