package org.jfree.data.test;

import static org.junit.Assert.*;
import java.security.InvalidParameterException;
import org.jmock.api.ExpectationError;
import org.jmock.Mockery;
import org.jfree.data.DataUtilities;
import org.jfree.data.Values2D;
import org.jmock.Expectations;
import org.junit.Before;
import org.junit.Test;

public class CalculateRowTotalTest {
    private Mockery mockingContext;
    private Values2D values;

	@Before
    public void setUp() throws Exception {
        this.mockingContext = new Mockery();
        this.values = this.mockingContext.mock(Values2D.class);
    }
        
	// #########################
	// calculateRowTotal()
	// #########################
    
    @Test
    public void calculateRowTotalFirstRow() {
        mockingContext.checking(new Expectations() {
            {
                one(values).getColumnCount();
                will(returnValue(3));                
                
                one(values).getValue(0, 0);
                will(returnValue(1.0));
                
                one(values).getValue(0, 1);
                will(returnValue(2.0));
                
                one(values).getValue(0, 2);
                will(returnValue(3.0));                        
            }
        });    	
    	
        double result = DataUtilities.calculateRowTotal(values, 0);
        assertEquals(6.0, result, .000000001d);
    } 
    
    @Test
    public void calculateRowTotalMiddleRow() {
        mockingContext.checking(new Expectations() {
            {
                one(values).getColumnCount();
                will(returnValue(3));                
                
                one(values).getValue(1, 0);
                will(returnValue(1.0));
                
                one(values).getValue(1, 1);
                will(returnValue(2.0));
                
                one(values).getValue(1, 2);
                will(returnValue(3.0));                        
            }
        });    	
    	
        double result = DataUtilities.calculateRowTotal(values, 1);
        assertEquals(6.0, result, .000000001d);
    }       
    
    @Test
    public void calculateRowTotalLastRow() {	
        mockingContext.checking(new Expectations() {
            {
                one(values).getColumnCount();
                will(returnValue(3));                
                
                one(values).getValue(2, 0);
                will(returnValue(1.0));
                
                one(values).getValue(2, 1);
                will(returnValue(2.0));
                
                one(values).getValue(2, 2);
                will(returnValue(3.0));                        
            }
        });    	    	
    	
        double result = DataUtilities.calculateRowTotal(values, 2);
        assertEquals(6.0, result, .000000001d);
    }      
    
    @Test
    public void calculateRowTotalWithNegativeRowIndex() {
        mockingContext.checking(new Expectations() {
            {
                one(values).getColumnCount();
                will(returnValue(3));                
                
                one(values).getValue(-1, 0);
                will(returnValue(1.0));
                
                one(values).getValue(-1, 1);
                will(returnValue(2.0));
                
                one(values).getValue(-1, 2);
                will(returnValue(3.0));                        
            }
        });    	    	
    	
        double result = DataUtilities.calculateRowTotal(values, -1);
        assertEquals(6.0, result, .000000001d);
    }

    @Test(expected = ExpectationError.class)
    public void calculateRowTotalWithOutOfBoundsRowIndex() {
        mockingContext.checking(new Expectations() {
            {
                one(values).getColumnCount();
                will(returnValue(3));                
                
                one(values).getValue(0, 0);
                will(returnValue(1.0));
                
                one(values).getValue(0, 1);
                will(returnValue(2.0));
                
                one(values).getValue(0, 2);
                will(returnValue(3.0));                        
            }
        });    	    	
        double result = DataUtilities.calculateRowTotal(values, -1);
        assertEquals(0.0, result, .000000001d);
    }    
    
    @Test
    public void calculateRowTotalWithNullDataItems() {
        mockingContext.checking(new Expectations() {
            {
                one(values).getColumnCount();
                will(returnValue(3));                
                
                one(values).getValue(0, 0);
                will(returnValue(null));
                
                one(values).getValue(0, 1);
                will(returnValue(null));
                
                one(values).getValue(0, 2);
                will(returnValue(null));                        
            }
        });    	
        double result = DataUtilities.calculateRowTotal(values, 0);
        assertEquals(0, result, .000000001d);
    }        
    
    @Test(expected = IllegalArgumentException.class)
    public void calculateRowTotalWithNullData() {    	
        DataUtilities.calculateRowTotal(null, 0);
    }

    @Test(expected = ExpectationError.class)
    public void calculateRowTotalWithMaxValueColIndex() {
    	
    	mockingContext.checking(new Expectations() {
            {
                one(values).getColumnCount();
                will(returnValue(Integer.MAX_VALUE));
                
                one(values).getValue(0, 0);
                will(returnValue(1.0));
                
                one(values).getValue(0, 1);
                will(returnValue(2.0));
                
                one(values).getValue(0, Integer.MAX_VALUE);
                will(returnValue(3.0));                 
            }
    	});
    	
        DataUtilities.calculateRowTotal(values, Integer.MAX_VALUE);
    }   
    
    @Test
    public void calculateRowTotalWithMaxValueInCols() {
    	
    	mockingContext.checking(new Expectations() {
            {
                one(values).getColumnCount();
                will(returnValue(3));
                
                one(values).getValue(0, 0);
                will(returnValue(Double.MAX_VALUE));
                
                one(values).getValue(0, 1);
                will(returnValue(Double.MAX_VALUE));
                
                one(values).getValue(0, 2);
                will(returnValue(Double.MAX_VALUE));                 
            }
    	});
    	
        double result = DataUtilities.calculateRowTotal(values, 0);
        assertEquals(Double.POSITIVE_INFINITY, result, .000000001d);
    }      

    @Test
    public void calculateRowTotalWithMinValueInCols() {
    	
    	mockingContext.checking(new Expectations() {
            {
                one(values).getColumnCount();
                will(returnValue(3));
                
                one(values).getValue(0, 0);
                will(returnValue(Double.MIN_VALUE));
                
                one(values).getValue(0, 1);
                will(returnValue(Double.MIN_VALUE));
                
                one(values).getValue(0, 2);
                will(returnValue(Double.MIN_VALUE));                 
            }
    	});
    	
        double result = DataUtilities.calculateRowTotal(values, 0);
        assertEquals(Double.MIN_VALUE + Double.MIN_VALUE + Double.MIN_VALUE, result, .000000001d);
    }      
    
    @Test(expected = ExpectationError.class)
    public void calculateRowTotalWithNegativeColumnCount() {
    	
    	mockingContext.checking(new Expectations() {
            {
                one(values).getColumnCount();
                will(returnValue(-3));
                
                one(values).getValue(0, 0);
                will(returnValue(1.0));
                
                one(values).getValue(0, -1);
                will(returnValue(2.0));
                
                one(values).getValue(0, -2);
                will(returnValue(3.0));    
                                  
            }
    	});
    	 double result = DataUtilities.calculateRowTotal(values, 0);
         assertEquals(6.0, result, .000000001d);
    }      
}
