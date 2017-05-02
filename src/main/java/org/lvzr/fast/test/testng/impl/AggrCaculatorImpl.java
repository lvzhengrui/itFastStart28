package org.lvzr.fast.test.testng.impl;

import org.lvzr.fast.test.testng.AggrCaculator;

public class AggrCaculatorImpl implements AggrCaculator{

	/**
	 * �����ֵ
	 * @param items
	 * @return
	 */
    public int max(int[] items){
        int result = Integer.MIN_VALUE;
        for(int item : items){
            if(result<item){
                result = item;
            }
        }
        return result;
    }

	/**
	 * ��ƽ��ֵ
	 * @param items
	 * @return
	 */
    public int avg(int[] items){
        if(items.length==0){
            return 0;
        }
        int result = 0;
        for(int item : items){
            result += item;
        }
        return result/items.length;
    }

}
