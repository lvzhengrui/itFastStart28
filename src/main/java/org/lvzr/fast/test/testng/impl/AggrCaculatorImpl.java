package org.lvzr.fast.test.testng.impl;

import org.lvzr.fast.test.testng.AggrCaculator;

/**
 * @author lvzr
 *
 */
public class AggrCaculatorImpl implements AggrCaculator{

	private String cc;
	/**
	 * 求最大值
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
	 * 求平均值
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
    
    /**
     * 计算税金
     * @param wage
     * @return
     */
	public int getRate(int wage) {
		if(wage>8000){
			return 5;
		}else if(wage>5000){
			return 2;
		}else if(wage>3500){
			return 1;
		}else{
			return 0;
		}
	}

 
}
