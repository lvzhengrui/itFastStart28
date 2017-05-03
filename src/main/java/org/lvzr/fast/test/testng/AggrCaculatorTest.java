package org.lvzr.fast.test.testng;

import org.lvzr.fast.test.testng.AggrCaculator;
import org.lvzr.fast.test.testng.impl.AggrCaculatorImpl;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;


/**
 * testng单元测试
 * @author lvzr
 *
 */
public class AggrCaculatorTest {

    AggrCaculator aggrCaculator;

    @BeforeTest
    public void before(){
        aggrCaculator = new AggrCaculatorImpl();
    }

	/**
	 * DataProvider的使用
	 * @return
	 */
    @DataProvider
    public Object[][] getRateTestData(){
         Object[][] result = {
            {0,0},
            {3500,0},
            {3501,1},
            {5000,1},
            {5001,2},
            {8000,2},
            {8001,5}};
         return result;
    }

    @Test(dataProvider="getRateTestData")
    public void testGetRate(int wage,int rate){
    	Assert.assertEquals(aggrCaculator.getRate(wage), rate);
    }
    
    @Test
    public void testMax() throws Exception {
    	//最大值
        Assert.assertEquals( aggrCaculator.max(new int[]{1,2,3,4,10}), 10 );
    }

    @Test
    public void testAvg() throws Exception {
    	//最小值
        Assert.assertEquals( aggrCaculator.avg(new int[]{1,2,3,4,5}) ,3 );
    }

	

    
    

}
