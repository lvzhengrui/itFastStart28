package org.lvzr.fast.test.powermock;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;
 

import java.util.ArrayList;
import java.util.List;

/**
 * PowerMock单元测试
 * @author lvzr
 * 请注意junit,powermock,mockito之间版本必须一致
 *
 */
@RunWith(PowerMockRunner.class)  //mock静态方法时必须加此注解
public class BactchConvertorJunitTest {

	private final static String LVZR_NAME = "lvzr_name";
	private final static String ELVA_TIME = "elva_time";
	
	private final static String LVZR_NAME_C = "lvzrName";
	private final static String ELVA_TIME_C = "elvaTime";	
	
	private List<String> mockResultList;

    @Before
    public void before(){
    	mockResultList = new ArrayList<String>();
		mockResultList.add(LVZR_NAME);
		mockResultList.add(ELVA_TIME);
    }
    
    /**
     * 普通公共方法
     * @throws Exception
     */
    @Test
    public void testNormalMock() throws Exception {    	
    	UnderscoreStringGenerator underscoreStringGenerator = PowerMockito.mock(UnderscoreStringGenerator.class);
    	PowerMockito.when(underscoreStringGenerator.getRandomUnderscoreStringsNormal(2)).thenReturn(mockResultList);
    	
    	List<String> resultList = underscoreStringGenerator.getRandomUnderscoreStringsNormal(2);
        Assert.assertEquals(resultList.get(0), LVZR_NAME);
        Assert.assertEquals(resultList.get(1), ELVA_TIME);        
    }

    /**
     * 静态方法
     * @throws Exception
     */
    @Test
    @PrepareForTest({UnderscoreStringGenerator.class})//mock静态方法时必须加此注解
    public void testStaticMock() throws Exception {    	
    	PowerMockito.mockStatic(UnderscoreStringGenerator.class);
    	//或PowerMockito.spy(UnderscoreStringGenerator.class);
    	PowerMockito.when(UnderscoreStringGenerator.getRandomUnderscoreStrings(2)).thenReturn(mockResultList);

    	//直接调用
    	List<String> resultList = UnderscoreStringGenerator.getRandomUnderscoreStrings(2);
        Assert.assertEquals(resultList.get(0), LVZR_NAME);
        Assert.assertEquals(resultList.get(1), ELVA_TIME);     

        //内部调用转换
        BactchConvertor bactchConvertor = new BactchConvertor();
        resultList = bactchConvertor.getCamelStringList(2);
        Assert.assertEquals(resultList.get(0), LVZR_NAME_C);
        Assert.assertEquals(resultList.get(1), ELVA_TIME_C);
    }

}
