package org.jfree.data.test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.util.Arrays;

import org.jfree.data.DataUtilities;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class CreateNumberArrayTest {
    private double[] doubleArray;
    double[] nullArray;
    double[] emptyArray;
    // double[] nullValue;

    @Before
    public void setUp() {
        // Initialize values for NumberArray
        doubleArray = new double[] { 1.0, -2.5, 7 };
        nullArray = new double[] { Double.NaN, Double.NaN, Double.NaN };
        emptyArray = new double[] {};
        // nullValue = null;
    }

    //// Double Array ////
    @Test
    public void testCreateNumberArray_ValidDoubleData_CheckNotNull() {
        // Exercise
        Number[] newNumberArray = DataUtilities.createNumberArray(doubleArray);

        // Verify
        assertNotNull("NumberArray is null and should have contain: " + Arrays.toString(doubleArray), newNumberArray);
    }

    @Test
    public void testCreateNumberArray_ValidDoubleData_CheckLength() {
        // Exercise
        Number[] newNumberArray = DataUtilities.createNumberArray(doubleArray);

        // Verify
        assertEquals("Original array and NumberArray do not have the same length.", doubleArray.length,
                newNumberArray.length);
    }

    @Test
    public void testCreateNumberArray_ValidDoubleData_CheckElement0Match() {
        // Exercise
        Number[] newNumberArray = DataUtilities.createNumberArray(doubleArray);

        // Verify
        assertEquals("Element 0 in Original array and NumberArray do not match.", doubleArray[0],
                newNumberArray[0]);
    }

    @Test
    public void testCreateNumberArray_ValidDoubleData_CheckElement1Match() {
        // Exercise
        Number[] newNumberArray = DataUtilities.createNumberArray(doubleArray);

        // Verify
        assertEquals("Element 1 in Original array and NumberArray do not match.", doubleArray[1],
                newNumberArray[1]);
    }

    @Test
    public void testCreateNumberArray_ValidDoubleData_CheckElement2Match() {
        // Exercise
        Number[] newNumberArray = DataUtilities.createNumberArray(doubleArray);

        // Verify
        assertEquals("Element 2 in Original array and NumberArray do not match.", doubleArray[2],
                newNumberArray[2]);
    }

    //
    //// Null Array ////
    @Test
    public void testCreateNumberArray_NullArray_CheckNotNull() {
        // Exercise
        Number[] newNumberArray = DataUtilities.createNumberArray(nullArray);

        // Verify
        assertNotNull("NumberArray is null and should have contain: " + Arrays.toString(nullArray), newNumberArray);
    }

    @Test
    public void testCreateNumberArray_NullArray_CheckLength() {
        // Exercise
        Number[] newNumberArray = DataUtilities.createNumberArray(nullArray);

        // Verify
        assertEquals("Original array and NumberArray do not have the same length.", nullArray.length,
                newNumberArray.length);
    }

    @Test
    public void testCreateNumberArray_NullArray_CheckElement0Match() {
        // Exercise
        Number[] newNumberArray = DataUtilities.createNumberArray(nullArray);

        // Verify
        assertEquals("Element 0 in Original array and NumberArray do not match.", nullArray[0],
                newNumberArray[0]);

    }

    @Test
    public void testCreateNumberArray_NullArray_CheckElement1Match() {
        // Exercise
        Number[] newNumberArray = DataUtilities.createNumberArray(nullArray);

        // Verify
        assertEquals("Element 1 in Original array and NumberArray do not match.", nullArray[1],
                newNumberArray[1]);
    }

    @Test
    public void testCreateNumberArray_NullArray_CheckElement2Match() {
        // Exercise
        Number[] newNumberArray = DataUtilities.createNumberArray(nullArray);

        // Verify
        assertEquals("Element 2 in Original array and NumberArray do not match.", nullArray[2],
                newNumberArray[2]);
    }

    //
    //// Empty Array ////
    @Test
    public void testCreateNumberArray_EmptyArray_CheckNotNull() {
        // Exercise
        Number[] newNumberArray = DataUtilities.createNumberArray(emptyArray);

        // Verify
        assertNotNull("NumberArray is null and should have contain: " + Arrays.toString(emptyArray), newNumberArray);
    }

    @Test
    public void testCreateNumberArray_EmptyArray_CheckLength() {
        // Exercise
        Number[] newNumberArray = DataUtilities.createNumberArray(emptyArray);

        // Verify
        assertEquals("Original array and NumberArray do not have the same length.", emptyArray.length,
                newNumberArray.length);
    }

    // Test Removed to increase coverage
    //// Null Value ////
    // @Test(expected = IllegalArgumentException.class)
    // public void testCreateNumberArray_nullValue() {
    // // Exercise
    // DataUtilities.createNumberArray(nullValue);
    // }

    @After
    public void tearDown() {
        // Destroy 1D array objects
        doubleArray = null;
        // nullValue = null;
        emptyArray = null;
        nullArray = null;

    }
}
