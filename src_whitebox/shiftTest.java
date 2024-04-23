package org.jfree.data.test;

import static org.junit.Assert.*;

import org.junit.Test;
import org.jfree.data.Range; 
import org.junit.*;

public class shiftTest {

    @BeforeClass
    public static void setUpBeforeClass() {
    }

    @Before
    public void setUp() throws Exception {
    }

    @Test(expected = IllegalArgumentException.class)
    public void shiftWithNullBaseValue() {
        Range rangeTest = null;
        Range result = Range.shift(rangeTest, 0, false);
    }

    @Test
    public void shiftWithZeroCrossingFalse() {
        Range rangeTest = new Range(-3, 0);
        
        //lower can't be greater than 0 hence expected to be 0 and not 1
        Range expected = new Range(0, 4);
        assertEquals("Shifting range by 4 with zero crossing not allowed", expected, Range.shift(rangeTest, 4, false));
    }
    
    @Test
    public void shiftWithZeroCrossingTrue() {
        Range rangeTest  = new Range(- 3, 0);
        Range expected = new Range(1, 4);

        assertEquals("Shifting range by 4 with zero crossing allowed", expected, Range.shift(rangeTest , 4, true));
    }


    @Test
    public void shiftWithNegativeDelta() {
        Range rangeTest = new Range(-3, 0);
  
        Range expected = new Range(-4, -1);
        assertEquals("Shifting range by -1 ", expected, Range.shift(rangeTest, -1, true));
    }

    @Test
    public void shiftWithZeroDelta() {
        Range rangeTest = new Range(-1, 0);
        assertEquals("Shifting range by 0 ", rangeTest, Range.shift(rangeTest, 0, true));
    }

    @Test
    public void shiftWithAlternativeMethod() {
        Range rangeTest = new Range(-3, 0);
        Range expected = new Range(0, 4);

        assertEquals("Shifting range by 4 with zero crossing not allowed", expected, Range.shift(rangeTest, 4));
    }

}