package org.lvzr.fast.test.powermock;

import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * PowerMockµ¥Ôª²âÊÔ
 * @author lvzr
 *
 */
public class BactchConvertorTest {

	private final static String LVZR_NAME = "lvzrName";
	private final static String ELVA_TIME = "elvaTime";
	private List<String> mockResultList;

    @BeforeTest
    public void before(){
    	mockResultList = new ArrayList<String>();
		mockResultList.add(LVZR_NAME);
		mockResultList.add(ELVA_TIME);
    }
    
    @Test
    public void testNormalMock() throws Exception {
    	
    	UnderscoreStringGenerator underscoreStringGenerator = PowerMockito.mock(UnderscoreStringGenerator.class);
    	PowerMockito.when(underscoreStringGenerator.getRandomUnderscoreStringsNormal(2)).thenReturn(mockResultList);
    	
    	List<String> resultList = underscoreStringGenerator.getRandomUnderscoreStringsNormal(2);
        Assert.assertEquals(resultList.get(0), LVZR_NAME);
        Assert.assertEquals(resultList.get(1), ELVA_TIME);
        
    }
    
    @PrepareForTest( { UnderscoreStringGenerator.class })
    @Test
    public void testStaticMock() throws Exception {
    	
    	PowerMockito.spy(UnderscoreStringGenerator.class);
    	PowerMockito.when(UnderscoreStringGenerator.getRandomUnderscoreStrings(2)).thenReturn(mockResultList);
    	
    	List<String> resultList = UnderscoreStringGenerator.getRandomUnderscoreStrings(2);
        Assert.assertEquals(resultList.get(0), LVZR_NAME);
        Assert.assertEquals(resultList.get(1), ELVA_TIME);
        
    }
    
    
    
   
    public void testGetCamelStringList() throws Exception {
        
        List<String> mockList = new ArrayList<String>(2);
        mockList.add("lvzr_name");
        mockList.add("elva_time");

        //PowerMockito.spy(UnderscoreStringGenerator.class);
        //PowerMockito.doReturn(mockList).when(UnderscoreStringGenerator.class
        //	,"getRandomUnderscoreStrings", null);

        //PowerMockito.mockStatic(UnderscoreStringGenerator.class); 
        PowerMockito.when(UnderscoreStringGenerator.getRandomUnderscoreStrings(2)).thenReturn(mockList);

        
        BactchConvertor bactchConvertor = new BactchConvertor();
        List<String> resultList = bactchConvertor.getCamelStringList(2);

        Assert.assertEquals(resultList.get(0), "lvzrName");
        Assert.assertEquals(resultList.get(1), "elvaTime");

    }

}
