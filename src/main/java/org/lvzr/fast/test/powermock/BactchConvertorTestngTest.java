package org.lvzr.fast.test.powermock;

import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.testng.Assert;
import org.testng.IObjectFactory;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.ObjectFactory;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * PowerMock��Ԫ����
 * @author lvzr
 *
 */
@PrepareForTest({UnderscoreStringGenerator.class }) //mock��̬��������Ӵ�ע��
public class BactchConvertorTestngTest{

	private final static String LVZR_NAME = "lvzr_name";
	private final static String ELVA_TIME = "elva_time";
	
	private final static String LVZR_NAME_C = "lvzrName";
	private final static String ELVA_TIME_C = "elvaTime";	
	
	private List<String> mockResultList;

	@BeforeTest
	public void before(){
    	mockResultList = new ArrayList<String>();
		mockResultList.add(LVZR_NAME);
		mockResultList.add(ELVA_TIME);
	}
	
    /**
     * TestNG��ܺ�PowerMock����ʱ��������������Ǳ���ģ�����̬ģ��ʧ��
     * @return
     */
    @ObjectFactory
    public IObjectFactory getObjectFactory() {
        return new org.powermock.modules.testng.PowerMockObjectFactory();
    }
 
    @Test
    public void testNormalMock() throws Exception {
    	UnderscoreStringGenerator underscoreStringGenerator = PowerMockito.mock(UnderscoreStringGenerator.class);
    	PowerMockito.when(underscoreStringGenerator.getRandomUnderscoreStringsNormal(2)).thenReturn(mockResultList);
    	
    	List<String> resultList = underscoreStringGenerator.getRandomUnderscoreStringsNormal(2);
        Assert.assertEquals(resultList.get(0), LVZR_NAME);
        Assert.assertEquals(resultList.get(1), ELVA_TIME);             
    }

    
    @Test
    public void testStaticMock() throws Exception {		
    	//�������̬��
    	PowerMockito.mockStatic(UnderscoreStringGenerator.class);
    	//��PowerMockito.spy(UnderscoreStringGenerator.class);
    	PowerMockito.when(UnderscoreStringGenerator.getRandomUnderscoreStrings(2)).thenReturn(mockResultList);

    	//ֱ�ӵ���
    	List<String> resultList = UnderscoreStringGenerator.getRandomUnderscoreStrings(2);
        Assert.assertEquals(resultList.get(0), LVZR_NAME);
        Assert.assertEquals(resultList.get(1), ELVA_TIME);     

        //�ڲ�����ת��
        BactchConvertor bactchConvertor = new BactchConvertor();
        resultList = bactchConvertor.getCamelStringList(2);
        Assert.assertEquals(resultList.get(0), LVZR_NAME_C);
        Assert.assertEquals(resultList.get(1), ELVA_TIME_C);
        
    }
 

}
