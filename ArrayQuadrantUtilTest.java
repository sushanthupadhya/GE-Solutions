package com.ge.exercise2;

import org.junit.Assume;
import org.junit.Test;

public class ArrayQuadrantUtilTest {

    @Test
    public void getQuadrantValuesTest() {
        Object[][] data = {
                {'a', 'b', 'c', 'd'},
                {'e', 'f', 'g', 'h'},
                {'i', 'j', 'k', 'l'},
                {'m', 'n', 'o', 'p'}
        };
        
        Object[][] data1 = {
                {1,2},
                {5,6},
                
        };
        
        
        

        ArrayQuadrantUtil util = new ArrayQuadrantUtil(data);
        Assume.assumeNotNull(util.getRowValues(2));

        ArrayQuadrantUtil util1 = new ArrayQuadrantUtil(data1);
        Assume.assumeNotNull(util1.getRowValues(2));
        
        char[] expectedResult1 = {'e', 'f', 'g', 'h'};
        
        char[] expectedResult2 = {5,6};
        
        Assume.assumeNotNull(util1.getQuadrantValues(0, 0));

        char[] expectedResult = {'a', 'b', 'e', 'f'};
        util1.getQuadrantValues(0, 0);
}
}