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

public class CalculateColumnTotalTest {
    private Mockery mockingContext;
    private Values2D values;

	@Before
    public void setUp() throws Exception {
        this.mockingContext = new Mockery();
        this.values = this.mockingContext.mock(Values2D.class);
    }
    
	// #########################
	// calcualteColumnTotal()
	// #########################
    @Test
    public void calculateColumnTotalFirstColumn() {
        mockingContext.checking(new Expectations() {
            {
                one(values).getRowCount();
                will(returnValue(3));                
                
                one(values).getValue(0, 0);
                will(returnValue(1.0));
                
                one(values).getValue(1, 0);
                will(returnValue(2.0));
                
                one(values).getValue(2, 0);
                will(returnValue(3.0));                        
            }
        });
    	
        double result = DataUtilities.calculateColumnTotal(values, 0);
        assertEquals(6.0, result, .000000001d);
    }
    
    @Test
    public void calculateColumnTotalMiddleColumn() {
        mockingContext.checking(new Expectations() {
            {
                one(values).getRowCount();
                will(returnValue(3));                
                
                one(values).getValue(0, 1);
                will(returnValue(1.0));
                
                one(values).getValue(1, 1);
                will(returnValue(2.0));
                
                one(values).getValue(2, 1);
                will(returnValue(3.0));                        
            }
        });    	
    	
        double result = DataUtilities.calculateColumnTotal(values, 1);
        assertEquals(6.0, result, .000000001d);
    }    
    
    @Test
    public void calculateColumnTotalLastColumn() {
        mockingContext.checking(new Expectations() {
            {
                one(values).getRowCount();
                will(returnValue(3));                
                
                one(values).getValue(0, 2);
                will(returnValue(1.0));
                
                one(values).getValue(1, 2);
                will(returnValue(2.0));
                
                one(values).getValue(2, 2);
                will(returnValue(3.0));                        
            }
        });    	
    	
        double result = DataUtilities.calculateColumnTotal(values, 2);
        assertEquals(6.0, result, .000000001d);
    } 
    
    @Test
    public void calculateColumnTotalWithNegativeColumnIndex() {
        mockingContext.checking(new Expectations() {
            {
                one(values).getRowCount();
                will(returnValue(3));                
                
                one(values).getValue(0, -1);
                will(returnValue(1.0));
                
                one(values).getValue(1, -1);
                will(returnValue(2.0));
                
                one(values).getValue(2, -1);
                will(returnValue(3.0));                        
            }
        });    	
        double result = DataUtilities.calculateColumnTotal(values, -1);
        assertEquals(6.0, result, .000000001d);
    }      
    
    @Test(expected = ExpectationError.class)
    public void calculateColumnTotalWithOutOfBoundsColumnIndex() {
        mockingContext.checking(new Expectations() {
            {
                one(values).getRowCount();
                will(returnValue(3));                
                
                one(values).getValue(0, 0);
                will(returnValue(1.0));
                
                one(values).getValue(1, 0);
                will(returnValue(2.0));
                
                one(values).getValue(2, 0);
                will(returnValue(3.0));                        
            }
        });    
        double result = DataUtilities.calculateColumnTotal(values, 4);
        assertEquals(0, result, .000000001d);
    }
    
    
    @Test
    public void calculateColumnTotalWithNullDataItems() {
        mockingContext.checking(new Expectations() {
            {
                one(values).getRowCount();
                will(returnValue(3));                
                
                one(values).getValue(0, 0);
                will(returnValue(null));
                
                one(values).getValue(1, 0);
                will(returnValue(null));
                
                one(values).getValue(2, 0);
                will(returnValue(null));                        
            }
        });    	
        double result = DataUtilities.calculateColumnTotal(values, 0);
        assertEquals(0, result, .000000001d);
    }    
    
    @Test(expected = IllegalArgumentException.class)
    public void calculateColumnTotalWithNullData() {    	
        DataUtilities.calculateRowTotal(null, 0);
    }       
    
    @Test(expected = ExpectationError.class)
    public void calculateColumnTotalWithMaxValueRowIndex() {
    	
    	mockingContext.checking(new Expectations() {
            {
                one(values).getRowCount();
                will(returnValue(Integer.MAX_VALUE));
                
                one(values).getValue(0, 0);
                will(returnValue(1.0));
                
                one(values).getValue(1, 0);
                will(returnValue(2.0));
                
                one(values).getValue(Integer.MAX_VALUE, 0);
                will(returnValue(3.0));                 
            }
    	});
    	
        DataUtilities.calculateColumnTotal(values, Integer.MAX_VALUE);
    }       
    
    @Test
    public void calculateColumnTotalWithMaxValueInRows() {
    	
    	mockingContext.checking(new Expectations() {
            {
                one(values).getRowCount();
                will(returnValue(3));
                
                one(values).getValue(0, 0);
                will(returnValue(Double.MAX_VALUE));
                
                one(values).getValue(1, 0);
                will(returnValue(Double.MAX_VALUE));
                
                one(values).getValue(2, 0);
                will(returnValue(Double.MAX_VALUE));                 
            }
    	});
    	
        double result = DataUtilities.calculateColumnTotal(values, 0);
        assertEquals(Double.POSITIVE_INFINITY, result, .000000001d);
    }      

    @Test
    public void calculateColumnTotalWithMinValueInRows() {
    	
    	mockingContext.checking(new Expectations() {
            {
                one(values).getRowCount();
                will(returnValue(3));
                
                one(values).getValue(0, 0);
                will(returnValue(Double.MIN_VALUE));
                
                one(values).getValue(1, 0);
                will(returnValue(Double.MIN_VALUE));
                
                one(values).getValue(2, 0);
                will(returnValue(Double.MIN_VALUE));                 
            }
    	});
    	
        double result = DataUtilities.calculateColumnTotal(values, 0);
        assertEquals(Double.MIN_VALUE + Double.MIN_VALUE + Double.MIN_VALUE, result, .000000001d);
    }      


    @Test(expected = ExpectationError.class)
    public void calculateColumnTotalWithNegativeRowCount() {
    	
    	mockingContext.checking(new Expectations() {
            {
                one(values).getRowCount();
                will(returnValue(-3));
                one(values).getValue(0, 0);
                will(returnValue(1.0));
                
                one(values).getValue(-1, 0);
                will(returnValue(2.0));
                
                one(values).getValue(-2, 0);
                will(returnValue(3.0));    
                                  
            }
    	});
    	 double result = DataUtilities.calculateColumnTotal(values, 0);
         assertEquals(6.0, result, .000000001d);
    }      
    
}