package org.jfree.data.test;

import static org.junit.Assert.*;

import org.junit.Test;
import org.jfree.data.Range; 
import org.junit.*;

public class RangeEqualTest{

	//Equals method
	@Test
	   public void equalsObjectTest() {
		   Range one = new Range(-6, -2);
		   Range two = new Range(-6,-2);
	       assertEquals("Object two equals to object one",
	       true, one.equals(two));
	   }
	
	@Test
	   public void notEqualsObjectLower() {
		   Range one = new Range(-6, -2);
		   Range two = new Range(-5,-2);
	       assertEquals("Object one lower bound does not equals to object two.",
	       false, one.equals(two));
	   }
	
	@Test
	   public void notEqualsObjectUpper() {
		   Range one = new Range(-6, -2);
		   Range two = new Range(-6,-3);
	       assertEquals("Object one upper bound does not equals to object two.",
	       false, one.equals(two));
	   }
	
	@Test
	   public void notEqualsObject() {
		   Object one = new Object();
		   Range two = new Range(-6,-3);
	       assertEquals("Object one, a different object) does not equals to object two.",
	       false, two.equals(one));
	   }
	
	//Hashcode method
	public void hashcode() {
		   Object one = new Object();
		   Range two = new Range(-6,-3);
	       assertEquals("Object one, a different object) does not equals to object two.",
	       false, two.equals(one));
	   }
}
