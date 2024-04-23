package org.jfree.data.test;

import static org.junit.Assert.assertArrayEquals;

import org.jfree.data.DataUtilities;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class CloneTest {

	double[][] double2dArray;
    double[][] nullDouble2dArray;
    double[][] null2dArray;
    double[][] empty2dArray;
    double[][] null2dValue;
    
    @Before
    public void setUp() {
        // Initialize values 
        double2dArray = new double[][] { { 1.0, -2.5 }, { 4.2, 5.0 } };
        nullDouble2dArray = new double[][] { { -2.5, 3.7 }, { Double.NaN, 6.3 } };
        null2dArray = new double[][] { { Double.NaN, Double.NaN }, { Double.NaN, Double.NaN } };
        empty2dArray = new double[][] { {}, {} };
        null2dValue =  new double[][] { null, null };
    }
    
   @Test
   public void testDouble2DArray() {
       // Exercise
       double[][] cloneDoubleArray = DataUtilities.clone(double2dArray);

       // Verify
       assertArrayEquals(double2dArray, cloneDoubleArray);
   }
   
   @Test
   public void testNullDouble2DArray() {
       // Exercise
       double[][] cloneDoubleArray = DataUtilities.clone(nullDouble2dArray);

       // Verify
       assertArrayEquals(nullDouble2dArray, cloneDoubleArray);
   }
   
   @Test
   public void testNull2DArray() {
       // Exercise
       double[][] cloneDoubleArray = DataUtilities.clone(null2dArray);

       // Verify
       assertArrayEquals(null2dArray, cloneDoubleArray);
   }
   
   @Test
   public void testEmpty2DArray() {
       // Exercise
       double[][] cloneDoubleArray = DataUtilities.clone(empty2dArray);

       // Verify
       assertArrayEquals(empty2dArray, cloneDoubleArray);
   }
   
   @Test
   public void testnull2DArray() {
       // Exercise
       double[][] cloneDoubleArray = DataUtilities.clone(null2dValue);

       // Verify
       assertArrayEquals(null2dValue, cloneDoubleArray);
   }
   
   
   @After
   public void tearDown() {

       // Destroy 2D array objects
       double2dArray = null;
       nullDouble2dArray = null;
       null2dArray = null;
       empty2dArray = null;
       null2dValue= null;
   }
   
   
}
   

