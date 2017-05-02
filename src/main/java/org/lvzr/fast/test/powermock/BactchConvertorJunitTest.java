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
 * PowerMock��Ԫ����
 * @author lvzr
 * ��ע��junit,powermock,mockito֮��汾����һ��
 *
 */
@RunWith(PowerMockRunner.class)  //mock��̬����ʱ����Ӵ�ע��
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
     * ��ͨ��������
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
     * ��̬����
     * @throws Exception
     */
    @Test
    @PrepareForTest({UnderscoreStringGenerator.class})//mock��̬����ʱ����Ӵ�ע��
    public void testStaticMock() throws Exception {    	
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
