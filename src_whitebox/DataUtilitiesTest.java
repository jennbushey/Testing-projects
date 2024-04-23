package org.jfree.data.test;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;

@RunWith(Suite.class)
@Suite.SuiteClasses({
    CalculateColumnTotalTest.class,
		//CalculateRowTotalValidColumnsTest.class,
        CalculateRowTotalTest.class,
		//CalculateColumnTotalValidRowsTest.class,
        GetCumulativePercentagesTest.class,
        CreateNumberArrayTest.class,
        CreateNumberArray2DTest.class,
        CloneTest.class,
        EqualTest.class,

})
public class DataUtilitiesTest {
}