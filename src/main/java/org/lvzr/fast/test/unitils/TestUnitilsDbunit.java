package org.lvzr.fast.test.unitils;

import org.junit.Test;
import org.unitils.UnitilsJUnit4;
import org.unitils.dbunit.annotation.DataSet;

import static org.hamcrest.MatcherAssert.assertThat;


/**
 * ��������classpath:unitils.properties��Ӧ�����ݿ�����Դ
 * @author lvzr
 *
 */
public class TestUnitilsDbunit extends UnitilsJUnit4{ //����̳�UnitilsJUnit4
    
    /**
     * ����Spring
     * @return
     */
    @Test
    @DataSet("TestUnitilsDbunit.Employee.xml")
    public void testDataSet(){
    	assertThat("���Բ���DataSet���ݼ�", true);
    }
    
    
}