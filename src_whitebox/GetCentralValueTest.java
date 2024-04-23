package org.jfree.data.test;

import static org.junit.Assert.*;

import org.jfree.data.*; import org.junit.*;

public class GetCentralValueTest {
    @BeforeClass public static void setUpBeforeClass() throws Exception {
    }


    @Before
    public void setUp() throws Exception { 

    }

    @Test
    public void centralValueShouldBeHalfForPositiveRange() {
        Range positiveRange = new Range(2, 10); // Range from 2 to 10
        assertEquals("The central value of 2 and 10 should be 6",
                6, positiveRange.getCentralValue(), .000000001d);
    }

    @Test
    public void centralValueShouldBeHalfForNegativeRange() {
        Range negativeRange = new Range(-10, -2); // Range from -10 to -2
        assertEquals("The central value of -10 and -2 should be -6",
                -6, negativeRange.getCentralValue(), .000000001d);
    }

    @Test
    public void centralValueShouldBeCorrectForLargeRange() {
        Range largeRange = new Range(-1.5E308, 1.5E308); // Range from -1.5E308 to 1.5E308
        assertEquals("The central value of -1.5E308 and 1.5E308 should be 0",
                0, largeRange.getCentralValue(), .000000001d);
    }

    @Test
    public void centralValueShouldBeSameForZeroRange() {
        Range zeroRange = new Range(0, 0); // Range starts and ends at 0
        assertEquals("The central value of 0 and 0 should be 0",
                0, zeroRange.getCentralValue(), .000000001d);
    }
    
    @Test(expected=	IllegalArgumentException.class)
    public void testCentralValueWithIllegalArgument() {
        Range invalidRange = new Range(10, 0); // Invalid Range of 10 to 0
        invalidRange.getCentralValue();
    }
    
    @Test(expected=	NullPointerException.class)
    public void testCentralValueWithNullArgument() {
        Range nullRange = new Range(10, (Double) null); // Invalid Range of 10 and null
        nullRange.getCentralValue();
    }
    
    @Test
    public void centralValueShouldWorkForDecimalRange() {
        Range decimalRange = new Range(2.234, 10.235); // Range from 2 to 10
        assertEquals("The central value of range 2.234 and 10.235 should be 6.2345",
        		6.2345, decimalRange.getCentralValue(), .000000001d);
    }
    
    @After
    public void tearDown() throws Exception {
    }

    @AfterClass
    public static void tearDownAfterClass() throws Exception {
    }
}
