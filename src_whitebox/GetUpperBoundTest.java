package org.jfree.data.test;

import static org.junit.Assert.*;

import org.junit.Test;
import org.jfree.data.Range; 
import org.junit.*;


public class GetUpperBoundTest {


    @BeforeClass public static void setUpBeforeClass() throws Exception {
    }

    @Before
    public void setUp() throws Exception {
    	
    }
    
   @Test
   public void upperBoundShouldBeNegative() {
	   Range rangeTestCase = new Range(-6, -2);
       assertEquals("The upper bound of -6 and -2",
       -2, rangeTestCase.getUpperBound(), .000000001d);
   }
   @Test
   public void upperBoundShouldBeZero() {
	   Range rangeTestCase = new Range(-5, 0);
       assertEquals("The upper bound of -5 and 0",
       0, rangeTestCase.getUpperBound(), .000000001d);
   }
    @Test
    public void upperBoundShouldBePositiveNumber() {
    	Range exampleRange = new Range(-1, 1);
        assertEquals("The upper bound of -1 and 1",
        1, exampleRange.getUpperBound(), .000000001d);
    }
    
    @Test
    public void upperBoundShouldBeFloatValue() {
    	Range rangeTestCase = new Range(3.5, 4.7);
        assertEquals("The upper bound of 3.5 and 4.7",
        4.7, rangeTestCase.getUpperBound(), .000000001d);
    }
    
    @Test
    public void upperBoundForRangeWithSameNumber() {
    	Range rangeTestCase = new Range(3, 3);
        assertEquals("The upper bound of 3 and 3",
        3, rangeTestCase.getUpperBound(), .000000001d);
    }
    
    @Test 
    public void upperBoundShouldBeNAN() {
    	Range rangeTestCase = new Range(2, Double.NaN);
    	assertEquals("The lower bound of 2 and NAN",
    	        Double.NaN, rangeTestCase.getUpperBound(), .000000001d);
    }
    
    // commented out to increase coverage 
   @Test (expected = IllegalArgumentException.class)
    public void upperBoundForInvalidRange() {
	   Range rangeTestCase = new Range(5, 2);
	   rangeTestCase.getUpperBound();
  }

    @After
    public void tearDown() throws Exception {
    }

    @AfterClass
    public static void tearDownAfterClass() throws Exception {
    }

}
