package org.jfree.data.test;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;
import org.jfree.data.Range;

public class ScaleTest {

	Range range;
	
	@Before
	public void setUp() {
		// Initialize values
		range = new Range(-10, 10);
	}
	
	@Test
	public void PositiveScaleTest() {
		// Exercise
		Range scaledRange = new Range (-50, 50);
		
		// Verify
		assertEquals(Range.scale(range, 5), scaledRange);
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void NegativeScaleTest() {
		// Exercise
		Range.scale(range, -5);
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void NullScaleTest() {
		// Exercise
		Range.scale(null, 5);
	}

}
