package org.lvzr.fast.test.testng;

import org.lvzr.fast.test.testng.AggrCaculator;
import org.lvzr.fast.test.testng.impl.AggrCaculatorImpl;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
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
