package com.ge.exercise2;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class ArrayQuadrantUtil<E> {
    private static final Logger logger = LogManager.getLogger(ArrayQuadrantUtil.class);

    E[][] data;

    public ArrayQuadrantUtil(E[][] data2) {
        this.data = data2;
    }

   
    
    public E[] getRowValues(int row) {
    	E[] arr = (E[])new Object[data.length];
    	int j=0;
    	for(int i=0;i<data.length;i++)
    	{
    		E alphabet=data[row-1][i];
    		arr[j++]=alphabet;
    	}
		return arr;
        
    }
    
    public E[] getColumnValues(int column) {
    	E output[] = (E[])new Object[data.length];
    	int j=0;
    	for(int i=0;i<data.length;i++)
    	{
    		E alphabet=data[i][column-1];
    		output[j++]=alphabet;
    	}
		return output;
    }
    
    public E[] getQuadrantValues(int row, int column) {
    	E output[] = (E[])new Object[data.length];
    	int j=0;
    	for(int i=0;i<row+1;i++)
    	{
    		E alphabet=data[i][column-1];
    		output[j++]=alphabet;
    		E alphabet1=data[row-1][i];
    		output[j++]=alphabet1;
    	}
		return output;
    }
    
    
}
