package org.jfree.data.test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.jfree.data.DataUtilities;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class EqualTest {
	double[][] double2dArray;
	double[][] empty2dArray;

	@Before
	public void setUp() {
		// Initialize values 
		double2dArray = new double[][] { { 1.0, -2.5 }, { 4.2, 5.0 } };
		empty2dArray = new double[][] { {}, {} };
	}

	@Test
	public void testDouble2DArray() {
		// Exercise
		double[][] duplicate = new double[][] { { 1.0, -2.5 }, { 4.2, 5.0 } };

		// Verify
		 assertTrue(DataUtilities.equal(double2dArray, duplicate));
	}
	
	@Test
	public void testInequalValuesDouble2DArray() {
		// Exercise
		double[][] duplicate = new double[][] { { 1.0, -3.5 }, { 4.2, 5.0 } };

		// Verify
		 assertFalse(DataUtilities.equal(double2dArray, duplicate));
	}
	
	@Test
	public void testSecondNull2DArray() {
		// Exercise
		double[][] array = null;

		// Verify
		 assertFalse(DataUtilities.equal(double2dArray, array));
	}
	
	
	@Test
	public void testInequalLengthDouble2DArray() {
		// Exercise
		double[][] array = new double[][] { { 1.0, -2.5 }, { 4.2, 5.0 }, {8.8, 6.0} };

		// Verify
		 assertFalse(DataUtilities.equal(double2dArray, array));
	}

	@After
	public void tearDown() {

		// Destroy 2D array objects
		double2dArray = null;
		empty2dArray = null;
	}

}
