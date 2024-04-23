package org.jfree.data.test;

import static org.junit.Assert.*;

import org.jfree.data.*; import org.junit.*;

public class GetLengthTest {
    @BeforeClass public static void setUpBeforeClass() throws Exception {
    }


    @Before
    public void setUp() throws Exception { 

    }
    
  //Test getLength() method
    @Test
    public void lengthValueShouldWorkForDecimalRange() {
        Range decimalRange = new Range(2.234, 10.235); // Range from 2 to 10
        assertEquals("The length value of range 2.234 and 10.235 should be 8.001",
                8.001, decimalRange.getLength(), .000000001d);
    }
    
    @Test
    public void lengthValueShouldWorkForPositiveRange() {
        Range positiveRange = new Range(2, 10); // Range from 2 to 10
        assertEquals("The length value of range 2 and 10 should be 8",
                8, positiveRange.getLength(), .000000001d);
    }

    @Test
    public void lengthValueShouldWorkForNegativeRange() {
        Range negativeRange = new Range(-10, -2); // Range from -10 to -2
        assertEquals("The length value of range -10 and -2 should be 8",
                8, negativeRange.getLength(), .000000001d);
    }

    @Test
    public void lengthValueShouldBeCorrectForLargeRange() {
        Range largeRange = new Range(-1.5E307, 1.5E307); // Range from -1.5E307 to 1.5E307
        assertEquals("The length value of range -1.5E307 and 1.5E307 should be 3E307",
                3E307, largeRange.getLength(), .000000001d);
    }
    
    @Test
    public void lengthValueShouldBeSameForZeroRange() {
        Range zeroRange = new Range(0, 0); // Range starts and ends at 0
        assertEquals("The length value of range 0 and 0 should be 0",
                0, zeroRange.getLength(), .000000001d);
    }
    
    @Test(expected=	NullPointerException.class)
    public void testLengthWithNullArgument() {
        Range nullRange = new Range(10, (Double) null); // Invalid Range of 10 and null
        nullRange.getLength();
    }

    @Test
    public void testLengthWithInvalidRange2() {
        double lower = 55.0;
        double upper = 15.0;
        try {
            Range invalidRange = new Range(lower, upper); // This is an invalid range because lower > upper
            invalidRange.getLength();
        } catch (IllegalArgumentException msg) {
            String expectedMessage = "Range(double, double): require lower (" + lower
            		+ ") <= upper (" + upper + ").";
            assertEquals("Exception message should match the expected message.", expectedMessage, msg.getMessage());
        }
    }

    @After
    public void tearDown() throws Exception {
    }

    @AfterClass
    public static void tearDownAfterClass() throws Exception {
    }
}
