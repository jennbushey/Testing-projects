package org.jfree.data.test;

import static org.junit.Assert.*;

import org.jfree.data.Range; 
import org.junit.*;

public class ContainsTest {

	//declare a Range object for testing contains() method
    private Range exampleRange;   
    
   
    @Before
    public void setUp() throws Exception {
    	//initialize a range object with range (-10, 10) to test the contains() method
    	exampleRange = new Range(-10, 10);
    	    	
    }

    //Eric test case for contains() method. The range of the object is set to (-10,10)
    //The following tests use the boundary techniques to test the contains() method if 
    //it contains an upper bound, lower bound and midpoint
    @Test
    //Testing if the range contains a lower bound of -10
    public void containsLowerBound() {
        assertEquals("The object exampleRange(-10,10) should contains the lower bound of -10",
        true , exampleRange.contains(-10));
    }
    
    @Test
  //Testing if the range contains an upper bound of 10
    public void containsUpperBound() {
        assertEquals("The object exampleRange(-10,10) should contains the upper bound of 10",
        true , exampleRange.contains(10));
    }
    
    @Test
  //Testing if the range contains a mid-point of 0
    public void containsMidpoint() {
        assertEquals("The object exampleRange(-10,10) should contains the mid point of 0",
        true , exampleRange.contains(0));
    }
    
    //The following tests use the robustness technique to test out of bound (lower & upper) values
    @Test
    public void containsOutboundUpper() {
        assertEquals("The object exampleRange(-10,10) should not contains 11 which is outside the upper bound of 10",
        false , exampleRange.contains(11));
    }
    
    @Test
    public void containsOutboundLower() {
        assertEquals("The object exampleRange(-10,10) should not contains -11 which is outside the lower bound of 10",
        false , exampleRange.contains(-11));
    }

}
