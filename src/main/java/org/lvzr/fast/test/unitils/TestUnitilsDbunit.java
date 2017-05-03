package org.lvzr.fast.test.unitils;

import org.junit.Test;
import org.unitils.UnitilsJUnit4;
import org.unitils.dbunit.annotation.DataSet;

import static org.hamcrest.MatcherAssert.assertThat;


/**
 * 必须配置classpath:unitils.properties对应的数据库数据源
 * @author lvzr
 *
 */
public class TestUnitilsDbunit extends UnitilsJUnit4{ //必须继承UnitilsJUnit4
    
    /**
     * 整合Spring
     * @return
     */
    @Test
    @DataSet("TestUnitilsDbunit.Employee.xml")
    public void testDataSet(){
    	assertThat("测试插入DataSet数据集", true);
    }
    
    
}