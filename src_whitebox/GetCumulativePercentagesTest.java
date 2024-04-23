package org.jfree.data.test;

import static org.junit.Assert.*;


import org.jfree.data.DataUtilities;
import org.jfree.data.KeyedValues;
import org.jfree.data.Values2D;
import org.jmock.Mockery;
import org.jmock.Expectations;
import org.junit.Before;
import org.junit.Test;
import org.junit.After;
import java.util.Arrays;
import java.util.List;
import java.security.InvalidParameterException;
import org.jmock.api.ExpectationError;
import java.util.ArrayList;


public class GetCumulativePercentagesTest {
	
	//Define class Keypair implements Keyedvalues interface to test the function
	//This class has two arrayList, one contains key, and one contains the value
	//The key and value are Double
	public class KeyPair implements KeyedValues{

		private ArrayList<Double> key = new ArrayList<Double>();
		private ArrayList<Double> value = new ArrayList<Double>();
		
		//constructor to create the first key-value pair
		public KeyPair(Double k, Double v) {
			key.add(k);
			value.add(v);
		}
		
		//append method to keep adding key-value pair
		public void append(Double k, Double v){
			key.add(k);
			value.add(v);
		}

		@Override
		public int getItemCount() {
			
			return key.size();
		}

		@Override
		public Number getValue(int index) {
			
			return value.get(index);
		}

		@Override
		public Comparable<Double> getKey(int index) {
			
			return key.get(index);
		}

		@Override
		public int getIndex(Comparable key) {
			for(int i = 0; i < this.key.size(); i++) {
				if(this.key.get(i).equals(key)) {
					return i;
				}
			}
			return -1;
		}

		@Override
		public List getKeys() {
			
			return this.key;
		}

		@Override
		public Number getValue(Comparable key) {
			
			return value.get(getIndex(key));
		}
		
	}
  
    
  
    
    @Before
    public void setUp() throws Exception{
   	 

    }
    
    //Eric test cases for getCumulativePercentages() method
    @Test
  //test case (0,0), expected percentage: 0/0
    public void getCumulativePercentagesTestingOneKpairWithZeroValue() {
    	
    	KeyPair kv = new KeyPair(0.0,0.0);
//        

        KeyedValues result = DataUtilities.getCumulativePercentages(kv);
        assertEquals("The cumulative percentage of key pair (0,0)should be 0.0/0.0", 0.0 / 0.0,
                result.getValue(0));
    }

    @Test
  //test case (0,1), expected percentage: 1
    public void getCumulativePercentagesTestingOneValidKpair() {

    	KeyPair kv = new KeyPair(0.0,1.0);
        KeyedValues result = DataUtilities.getCumulativePercentages(kv);
        assertEquals("The cumulative percentage of key pair (1,1) should be 1", 1.0,
                result.getValue(0));
    }
    
    @Test
    //test case (0,null) expected percentage: NaN
    public void getCumulativePercentagesTestingOneKpairWithNullValue() {
    	KeyPair keyValues = new KeyPair(0.0, null);

        KeyedValues result = DataUtilities.getCumulativePercentages(keyValues);
        assertEquals("The cumulative percentage of null in data should be NaN", Double.NaN, result.getValue(0));
    }
  
  
   @Test
 //test case (0,0), (1,1), expected percentage: 0, 1
  public void getCumulativePercentageTestingTwoKeyPairWithOneZeroValue() {             
	   KeyPair kv = new KeyPair(0.0,0.0);
	   kv.append(1.0, 1.0);
               
       KeyedValues result = DataUtilities.getCumulativePercentages(kv);
       assertEquals("The cumulative Percentage of key pair (0,0) should be 0. ", 0.0, result.getValue(0));
       assertEquals("The cumulative Percentage of key pair (1,1) should be 0. ", 1.0 , result.getValue(1));
       
   }
   
   @Test
 //test case (0,2) (1,3) (2,4), expected result: (0, 2/9), (1,5/9), (2,9/9)
   public void getCumulativePercentageTestingThreeKeyPair() {             
    	        
	   KeyPair kv = new KeyPair(0.0,2.0);
	   kv.append(1.0, 3.0);
	   kv.append(2.0, 4.0);        
        KeyedValues result = DataUtilities.getCumulativePercentages(kv);
        assertEquals("The cumulative Percentage of key pair (0,2) should be 0.22222 ", 2.0/9, result.getValue(0));
        assertEquals("The cumulative Percentage of key pair (1,3) should be 0.5555555 ", 5.0/9 , result.getValue(1));
        assertEquals("The cumulative Percentage of key pair (2,4) should be 1.0 ", 1.0 , result.getValue(2));
        
    }
   
   @Test
 //test case (0,0) (1,3), (2,-2), (3,4), expected result: (0, 0), (1,3/5), (2,-2/5), (3,4/5)
   public void getCumulativePercentageTestingFourKeyPairWithNegative() {               
    	
	   KeyPair kv = new KeyPair(0.0,0.0);
	   kv.append(1.0, 3.0);
	   kv.append(2.0, -2.0);  
	   kv.append(3.0, 4.0); 
        
        KeyedValues result = DataUtilities.getCumulativePercentages(kv);
        assertEquals("The cumulative Percentage of key pair (0,0) should be 0.0 ", 0.0, result.getValue(0));
        assertEquals("The cumulative Percentage of key pair (1,3) should be 0.6 ", 0.6 , result.getValue(1));
        assertEquals("The cumulative Percentage of key pair (2,-2) should be -0.4 ", -0.4 , result.getValue(2));
        assertEquals("The cumulative Percentage of key pair (3,4) should be 0.8 ", 0.8 , result.getValue(3));
        
    }

}
