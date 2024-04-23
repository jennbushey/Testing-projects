package org.jfree.data.test;

import static org.junit.Assert.*;

import org.jfree.data.*; import org.junit.*;

public class IntersectConstrainCombineTest {
    @BeforeClass public static void setUpBeforeClass() throws Exception {
    }


    @Before
    public void setUp() throws Exception { 

    }
    //Test intersects(Double)() method
    @Test
    public void testIntersectsDouble1() {
        Range intersectDoubleRange = new Range(5.0,10.0); 
        assertEquals("The Intersects method should return True",
                true, intersectDoubleRange.intersects(3,6));
    }
    @Test
    public void testIntersectsDouble2() {
        Range intersectDoubleRange = new Range(5.0,10.0); 
        assertEquals("The Intersects method should return True",
                true, intersectDoubleRange.intersects(6,8));
    }
    
    @Test
    public void testIntersectsDouble3() {
        Range intersectDoubleRange = new Range(5.0,10.0); 
        assertEquals("The Intersects method should return True",
                false, intersectDoubleRange.intersects(3,4));
    }
    
    @Test
    public void testIntersectsDouble4() {
        Range intersectDoubleRange = new Range(5.0,10.0); 
        assertEquals("The Intersects method should return False",
                false, intersectDoubleRange.intersects(11,14));
    }
    @Test
    public void testIntersectsDouble5() {
        Range intersectDoubleRange = new Range(5.0,10.0); 
        assertEquals("The Intersects method should return False",
                false, intersectDoubleRange.intersects(6,4));
    }
 
    //Test intersects(Range)() method
    @Test
    public void testIntersectsRange1() {
        Range intersectRange = new Range(5.0,10.0); 
        Range intersectRange2 = new Range(3.0,14.0);         
        assertEquals("The Intersects method should return True",
                true, intersectRange.intersects(intersectRange2));
    }
    
    //Test Constrain method
    @Test
    public void middleValue() {
    	Range range = new Range(-1,1);
        assertEquals(range.constrain(0), 0.0, .000000001d);
    }

    @Test
    public void rightSideValue() {
    	Range range = new Range(-1,1);
        assertEquals(range.constrain(2), 1, .000000001d);
    }

    @Test
    public void leftSideValue() {
    	Range range = new Range(-1,1);
        assertEquals(range.constrain(-2), -1, .000000001d);
    }

    @Test
    public void NaNValue() {
    	Range range = new Range(-1,1);
        assertEquals(range.constrain(Double.NaN), Double.NaN, .000000001d);
    }
    
    //Test Combine method
    @Test
    public void disconnectedRanges() {
        Range r1 = new Range(-10, -5);
        Range r2 = new Range(5, 10);
        Range result = new Range(-10, 10);
        assertEquals(Range.combine(r1, r2), result);
    }

    @Test
    public void leftNullRange() {
        Range r = new Range(1, 10);
        assertEquals(Range.combine(null, r), r);
    }

    @Test
    public void riightNullRange() {
        Range r = new Range(1, 10);
        assertEquals(Range.combine(r, null), r);
    }

    //Test CombineignoreNaN method
    @Test
    public void combineRegular() {
        Range r1 = new Range(-10, 2);
        Range r2 = new Range(5, 20);
        Range result = Range.combineIgnoringNaN(r1, r2);
        Range expected = new Range(-10, 20);
        assertEquals(expected, result);
    }

    @Test
    public void Nullcombine() {
        Range result = Range.combineIgnoringNaN(null, null);
        assertNull(result);
    }

    @Test
    public void leftNullcombine() {
        Range r = new Range(-10, 5);
        Range result = Range.combineIgnoringNaN(null, r);
        assertEquals(r, result);
    }

    @Test
    public void rightNullcombine() {
        Range r = new Range(-10, 5);
        Range result = Range.combineIgnoringNaN(r, null);
        assertEquals(r, result);
    }

    @Test
    public void leftNullrightNaN() {
        Range r = new Range(Double.NaN, Double.NaN);
        Range result = Range.combineIgnoringNaN(null, r);
        assertNull(result);
    }

    @Test
    public void rightNullleftNaN() {
        Range r = new Range(Double.NaN, Double.NaN);
        Range result = Range.combineIgnoringNaN(r, null);
        assertNull(result);
    }

    @Test
    public void allNan() {
        Range r1 = new Range(Double.NaN, Double.NaN);
        Range r2 = new Range(Double.NaN, Double.NaN);
        Range result = Range.combineIgnoringNaN(r1, r2);
        assertNull(result);
    }

    @Test
    public void oneRangeAllNaN() {
        Range r1 = new Range(-1, 0.5);
        Range r2 = new Range(Double.NaN, Double.NaN);
        Range result = Range.combineIgnoringNaN(r1, r2);
        assertEquals(r1, result);
    }

    @Test
    public void oneRangePartNaN() {
        Range r1 = new Range(-10, 5);
        Range r2 = new Range(Double.NaN,15);
        Range result = Range.combineIgnoringNaN(r1, r2);
        Range expected = new Range(-10, 15);
        assertEquals(expected, result);
    }
    
    //test HashCode
    @Test
    public void testHashCodeEquality() {
        Range range1 = new Range(5.0, 10.0);
        Range range2 = new Range(5.0, 10.0);
        assertEquals("Equal objects must return the same hash code.", range1.hashCode(), range2.hashCode());
    }
        
    @After
    public void tearDown() throws Exception {
    }

    @AfterClass
    public static void tearDownAfterClass() throws Exception {
    }
}
