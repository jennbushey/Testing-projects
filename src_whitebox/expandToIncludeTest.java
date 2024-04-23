package org.jfree.data.test;

import static org.junit.Assert.*;

import org.junit.Test;
import org.jfree.data.Range; 
import org.junit.*;

public class expandToIncludeTest{
	
	@BeforeClass
    public static void setUpBeforeClass() {
    }

    @Before
    public void setUp() throws Exception {
    }
    
	@Test
	public void valueGreaterThanUpperBound() {
		Range rangeTest = new Range(0,2);
    	Range expected = new Range(0,8);
    	assertEquals( Range.expandToInclude(rangeTest, 8),expected);
	}
	
	@Test
	public void valueLessThanLowerBound() {
		Range rangeTest = new Range(0,2);
    	Range expected = new Range(-2,2);
    	assertEquals(Range.expandToInclude(rangeTest, -2),expected);
	}
	
	@Test
	public void nullRange() {
		
		Range rangeTest = null;
    	Range expected = new Range(8,8);
    	assertEquals(Range.expandToInclude(rangeTest, 8), expected);
	}
	
	@Test
	public void valueWithinRange() {
		Range rangeTest = new Range(0,15);
    	assertEquals(Range.expandToInclude(rangeTest, 4), rangeTest);
	}
	
	
	@After
    public void tearDown() {
    }

    @AfterClass
    public static void tearDownAfterClass() {
    }

}