package org.jfree.data.test;

import static org.junit.Assert.*;

import org.junit.Test;
import org.jfree.data.Range; 
import org.junit.*;

public class expandTest{
	
	@BeforeClass
    public static void setUpBeforeClass() {
    }

    @Before
    public void setUp() throws Exception {
    }
    
	@Test (expected = IllegalArgumentException.class)
    public void expandNullRange() {
        Range.expand(null, 3, 3);
    }
	
	@Test 
    public void expandEqualAmount() {
        assertEquals(Range.expand(new Range(-2, 2), 1, 1), new Range(-6, 6));
    }
	
	@Test 
    public void expandByZeroOnUpper() {
	     assertEquals(Range.expand(new Range(-2, 2), -1, 0), new Range(2, 2));
    }
	
	@Test
    public void expandByNegativeMargin() {
        Range result = new Range(2.5, 2.5);
        assertEquals(Range.expand(new Range(-1, 1), -2, 0.5), result);
    }
	


	
	@After
    public void tearDown() {
    }

    @AfterClass
    public static void tearDownAfterClass() {
    }

}