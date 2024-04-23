package org.jfree.data.test;

import static org.junit.Assert.*;

import org.junit.Test;
import org.jfree.data.Range; 
import org.junit.*;

public class isNanRangeTest{

	@BeforeClass
    public static void setUpBeforeClass() {
    }

    @Before
    public void setUp() throws Exception {
    }
    
    @Test
    public void bothBoundsNaN() {
    	Range rangeTest = new Range(Double.NaN,Double.NaN);
    	assertTrue(rangeTest.isNaNRange());
    }
    
    @Test
    public void lowerBoundNaN() {
    	Range rangeTest = new Range(Double.NaN, 2);
    	assertFalse(rangeTest.isNaNRange());
    }
    
    @Test
    public void upperBoundNaN() {
    	Range rangeTest = new Range(2,Double.NaN);
    	assertFalse(rangeTest.isNaNRange());
    }
    
    
    @After
    public void tearDown() {
    }

    @AfterClass
    public static void tearDownAfterClass() {
    }
}
