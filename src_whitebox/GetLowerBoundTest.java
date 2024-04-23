package org.jfree.data.test;

import static org.junit.Assert.*;
import org.junit.Test;
import org.jfree.data.Range; 
import org.junit.*;

public class GetLowerBoundTest {

	
    @BeforeClass public static void setUpBeforeClass() throws Exception {
    }

    @Before
    public void setUp() throws Exception {
    	
    }
    
    //Test Cases for getLowerBound()
    
    @Test
    public void lowerBoundShouldBeNegativeOne() {
    	Range exampleRange = new Range(-1, 1);
        assertEquals("The lower bound of -1 and 1",
        -1, exampleRange.getLowerBound(), .000000001d);
    }
    @Test
    public void lowerBoundShouldBeZero() {
    	Range rangeTestCase = new Range(0, 1);
        assertEquals("The lower bound of 0 and 1",
        0, rangeTestCase.getLowerBound(), .000000001d);
    }
    
    @Test
    public void lowerBoundShouldBePositiveNumber() {
    	Range rangeTestCase = new Range(3, 10);
        assertEquals("The lower bound of 3 and 10",
        3, rangeTestCase.getLowerBound(), .000000001d);
    }
    @Test
    public void lowerBoundShouldBeFloatValue() {
    	Range rangeTestCase = new Range(3.5, 4.7);
        assertEquals("The lower bound of 3.5 and 4.7",
        3.5, rangeTestCase.getLowerBound(), .000000001d);
    }
    
    @Test
    public void lowerBoundForRangeWithSameNumber() {
    	Range rangeTestCase = new Range(3, 3);
        assertEquals("The lower bound of 3 and 3",
        3, rangeTestCase.getLowerBound(), .000000001d);
    }

    @Test
    public void lowerBoundShouldBeInvalidDueToNAN() {
    	Range rangeTestCase = new Range(Double.NaN, 2);
    	assertEquals("The lower bound of NAN and 2",
    	        Double.NaN, rangeTestCase.getLowerBound(), .000000001d);
    }
    
    //Removed test case to increase coverage 
   @Test (expected = IllegalArgumentException.class)
    public void lowerBoundForInvalidRange() {
	   Range rangeTestCase = new Range(5, 2);
	   rangeTestCase.getLowerBound();
  }
    

    @After
    public void tearDown() throws Exception {
    }

    @AfterClass
    public static void tearDownAfterClass() throws Exception {
    }

}
