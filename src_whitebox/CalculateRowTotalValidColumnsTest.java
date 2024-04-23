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

public class CalculateRowTotalValidColumnsTest {
    private Mockery mockingContext;
    private Values2D values;

	@Before
    public void setUp() throws Exception {
        this.mockingContext = new Mockery();
        this.values = this.mockingContext.mock(Values2D.class);
    }
    
	// #########################
	// calcualteRowTotalValidRowsTest()
	// #########################
    @Test
    public void calculateRowTotalOfOneRowWithEmptyValidColumns() {
        mockingContext.checking(new Expectations() {
            {
                one(values).getColumnCount();
                will(returnValue(1));                
                
                one(values).getValue(0, 0);
                will(returnValue(1.0));
                                    
            }
        });
    	
        double result = DataUtilities.calculateRowTotal(values, 0, new int[] {});
        assertEquals(1.0, result, .000000001d);
    }
    
    @Test
    public void calculateRowTotalOfOneRowWithAllValidColumns() {
        mockingContext.checking(new Expectations() {
            {
                one(values).getColumnCount();
                will(returnValue(1));                
                
                one(values).getValue(0, 0);
                will(returnValue(1.0));
                                    
            }
        });
    	
        double result = DataUtilities.calculateRowTotal(values, 0, new int[] {0});
        assertEquals(1.0, result, .000000001d);
    }  
    
    @Test
    public void calculateRowTotalOfOneRowWIthMoreValidColumns() {
        mockingContext.checking(new Expectations() {
            {
                one(values).getColumnCount();
                will(returnValue(1));                
                
                one(values).getValue(0, 0);
                will(returnValue(1.0));
                                    
            }
        });
    	
        double result = DataUtilities.calculateRowTotal(values, 0, new int[] {0, 1});
        assertEquals(1.0, result, .000000001d);
    }
    
    @Test
    public void calculateRowTotalOfOneColumnWithNullElement() {
        mockingContext.checking(new Expectations() {
            {
                one(values).getColumnCount();
                will(returnValue(1));                
                
                one(values).getValue(0, 0);
                will(returnValue(null));
                                    
            }
        });
    	
        double result = DataUtilities.calculateRowTotal(values, 0, new int[] {0, 1});
        assertEquals(0, result, .000000001d);
    }    
}