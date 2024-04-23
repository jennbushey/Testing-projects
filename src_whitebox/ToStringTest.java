package org.jfree.data.test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.jfree.data.Range;
import org.junit.Before;
import org.junit.Test;

public class ToStringTest {

	Range range;

	@Before
	public void setUp() {
		// Initialize values
		range = new Range(-10, 10);
	}

	@Test
	public void testEqualString() {
		// Exercise
		String string = "Range[-10.0,10.0]";

		// Verify
		assertTrue(string.equals(range.toString()));
	}

	@Test
	public void testInequalString() {
		// Exercise
		String string = "Inequal String";

		// Verify
		assertFalse(string.equals(range.toString()));
	}

}
