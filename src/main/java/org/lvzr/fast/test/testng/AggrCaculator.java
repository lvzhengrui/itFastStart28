package org.lvzr.fast.test.testng;

public interface AggrCaculator{
	/**
	 * 求最大值
	 * @param items
	 * @return
	 */
	int max(int[] items);
	
	/**
	 * 求平均值
	 * @param items
	 * @return
	 */
   int avg(int[] items);
   
   /**
    * 计算税金
    * @param wage
    * @return
    */
   int getRate(int wage);
}




