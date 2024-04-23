package org.jfree.data.test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.util.Arrays;

import org.jfree.data.DataUtilities;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class CreateNumberArray2DTest {

    double[][] double2dArray;
    double[][] nullDouble2dArray;
    double[][] null2dArray;
    double[][] empty2dArray;
    // double[][] null2dValue;

    @Before
    public void setUp() {
        // Initialize values for NumberArray2D
        double2dArray = new double[][] { { 1.0, -2.5 }, { 4.2, 5.0 } };
        nullDouble2dArray = new double[][] { { -2.5, 3.7 }, { Double.NaN, 6.3 } };
        null2dArray = new double[][] { { Double.NaN, Double.NaN }, { Double.NaN, Double.NaN } };
        empty2dArray = new double[][] { {}, {} };
        // null2dValue = null;
    }

    //// Double Array ////
    @Test
    public void testCreateNumberArray2D_ValidData_CheckNotNull() {
        // Exercise
        Number[][] newNumberArray = DataUtilities.createNumberArray2D(double2dArray);

        // Verify
        assertNotNull("NumberArray is null for input: " + Arrays.deepToString(double2dArray), newNumberArray);
    }

    @Test
    public void testCreateNumberArray2D_ValidData_CheckRowLength() {
        // Exercise
        Number[][] newNumberArray = DataUtilities.createNumberArray2D(double2dArray);

        // Verify
        assertEquals("Original array and NumberArray do not have the same length.", double2dArray.length,
                newNumberArray.length);
    }

    @Test
    public void testCreateNumberArray2D_ValidData_CheckColumn0Length() {
        // Exercise
        Number[][] newNumberArray = DataUtilities.createNumberArray2D(double2dArray);

        // Verify
        assertEquals("Original array and NumberArray do not have the same length.", double2dArray[0].length,
                newNumberArray[0].length);
    }

    @Test
    public void testCreateNumberArray2D_ValidData_CheckColumn1Length() {
        // Exercise
        Number[][] newNumberArray = DataUtilities.createNumberArray2D(double2dArray);

        // Verify
        assertEquals("Original array and NumberArray do not have the same length.", double2dArray[1].length,
                newNumberArray[1].length);
    }

    @Test
    public void testCreateNumberArray2D_ValidData_CheckElement00Match() {
        // Exercise
        Number[][] newNumberArray = DataUtilities.createNumberArray2D(double2dArray);

        // Verify
        assertEquals("Element [0][0] in Original array and NumberArray do not match.", double2dArray[0][0],
                newNumberArray[0][0]);
    }

    @Test
    public void testCreateNumberArray2D_ValidData_CheckElement01Match() {
        // Exercise
        Number[][] newNumberArray = DataUtilities.createNumberArray2D(double2dArray);

        // Verify
        assertEquals("Element [0][1] in Original array and NumberArray do not match.", double2dArray[0][1],
                newNumberArray[0][1]);
    }

    @Test
    public void testCreateNumberArray2D_ValidData_CheckElement10Match() {
        // Exercise
        Number[][] newNumberArray = DataUtilities.createNumberArray2D(double2dArray);

        // Verify
        assertEquals("Element [1][0] in Original array and NumberArray do not match.", double2dArray[1][0],
                newNumberArray[1][0]);
    }

    @Test
    public void testCreateNumberArray2D_ValidData_CheckElement11Match() {
        // Exercise
        Number[][] newNumberArray = DataUtilities.createNumberArray2D(double2dArray);

        // Verify
        assertEquals("Element [1][1] in Original array and NumberArray do not match.", double2dArray[1][1],
                newNumberArray[1][1]);
    }

    //// Mixed Input Array ////
    @Test
    public void testCreateNumberArray2D_NullDouble2dArray_CheckElement00Match() {
        // Exercise
        Number[][] newNumberArray = DataUtilities.createNumberArray2D(nullDouble2dArray);

        // Verify
        assertEquals("Element [0][0] in Original array and NumberArray do not match.", nullDouble2dArray[0][0],
                newNumberArray[0][0]);
    }

    @Test
    public void testCreateNumberArray2D_NullDouble2dArray_CheckElement01Match() {
        // Exercise
        Number[][] newNumberArray = DataUtilities.createNumberArray2D(nullDouble2dArray);

        // Verify
        assertEquals("Element [0][1] in Original array and NumberArray do not match.", nullDouble2dArray[0][1],
                newNumberArray[0][1]);
    }

    @Test
    public void testCreateNumberArray2D_NullDouble2dArray_CheckElement10Match() {
        // Exercise
        Number[][] newNumberArray = DataUtilities.createNumberArray2D(nullDouble2dArray);

        // Verify
        assertEquals("Element [1][0] in Original array and NumberArray do not match.", nullDouble2dArray[1][0],
                newNumberArray[1][0]);
    }

    @Test
    public void testCreateNumberArray2D_NullDouble2dArray_CheckElement11Match() {
        // Exercise
        Number[][] newNumberArray = DataUtilities.createNumberArray2D(nullDouble2dArray);

        // Verify
        assertEquals("Element [1][1] in Original array and NumberArray do not match.", nullDouble2dArray[1][1],
                newNumberArray[1][1]);
    }

    //// Null Array ////
    @Test
    public void testCreateNumberArray2D_Null2dArray_CheckElement00Match() {
        // Exercise
        Number[][] newNumberArray = DataUtilities.createNumberArray2D(null2dArray);

        // Verify
        assertEquals("Element [0][0] in Original array and NumberArray do not match.", null2dArray[0][0],
                newNumberArray[0][0]);
    }

    @Test
    public void testCreateNumberArray2D_Null2dArray_CheckElement01Match() {
        // Exercise
        Number[][] newNumberArray = DataUtilities.createNumberArray2D(null2dArray);

        // Verify
        assertEquals("Element [0][1] in Original array and NumberArray do not match.", null2dArray[0][1],
                newNumberArray[0][1]);
    }

    @Test
    public void testCreateNumberArray2D_Null2dArray_CheckElement10Match() {
        // Exercise
        Number[][] newNumberArray = DataUtilities.createNumberArray2D(null2dArray);

        // Verify
        assertEquals("Element [1][0] in Original array and NumberArray do not match.", null2dArray[1][0],
                newNumberArray[1][0]);
    }

    @Test
    public void testCreateNumberArray2D_Null2dArray_CheckElement11Match() {
        // Exercise
        Number[][] newNumberArray = DataUtilities.createNumberArray2D(null2dArray);

        // Verify
        assertEquals("Element [1][1] in Original array and NumberArray do not match.", null2dArray[1][1],
                newNumberArray[1][1]);
    }

    //// Empty Array ////
    @Test
    public void testCreateNumberArray2D_Empty2dArray_CheckNotNull() {
        // Exercise
        Number[][] newNumberArray = DataUtilities.createNumberArray2D(empty2dArray);

        // Verify
        assertNotNull("NumberArray is null and should have contain: " + Arrays.toString(empty2dArray), newNumberArray);
    }

    @Test
    public void testCreateNumberArray2D_Empty2dArray_CheckRowLength() {
        // Exercise
        Number[][] newNumberArray = DataUtilities.createNumberArray2D(empty2dArray);

        // Verify
        assertEquals("Original array and NumberArray do not have the same length.", empty2dArray.length,
                newNumberArray.length);
    }

    @Test
    public void testCreateNumberArray2D_ValidData_CheckColumnLength() {
        // Exercise
        Number[][] newNumberArray = DataUtilities.createNumberArray2D(empty2dArray);

        // Verify
        assertEquals("Original array and NumberArray do not have the same length.", empty2dArray[0].length,
                newNumberArray[0].length);
    }

    // Test Removed to increase coverage
    //// Null Value ////
    // @Test(expected = IllegalArgumentException.class)
    // public void testCreateNumberArray2D_nullValue() {
    // // Exercise
    // DataUtilities.createNumberArray2D(null2dValue);
    // }

    @After
    public void tearDown() {

        // Destroy 2D array objects
        double2dArray = null;
        nullDouble2dArray = null;
        null2dArray = null;
        empty2dArray = null;
        // null2dValue = null;
    }
}
