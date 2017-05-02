package org.lvzr.fast.test.mockito;

import static org.mockito.Mockito.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.junit.Assert;  
import static org.junit.Assert.*;  
import org.junit.Test;
import org.mockito.Matchers;
import org.mockito.invocation.InvocationOnMock;
import org.mockito.stubbing.Answer;  
  

/**
 * mockito单元测试
 * http://blog.csdn.net/zhangxin09/article/details/42422643
 *
 */
public class TestMockito{
	
    @Test  
    public void simpleTest(){  
          
        //创建mock对象，参数可以是类，也可以是接口  
        List<String> list = mock(List.class);  
          
        //设置方法的预期返回值  
        when(list.get(0)).thenReturn("helloworld");  
      
        String result = list.get(0);  
          
        //验证方法调用(是否调用了get(0))  
        verify(list).get(0);  
          
        //junit测试  
        Assert.assertEquals("helloworld", result);  
    }  
    
    @Test
    public void simpleTest2(){  
    	List mock = mock(List.class);  
    	when( mock.get(0) ).thenReturn(1);  
    	assertEquals( "预期返回1", 1, mock.get(0));// mock.get(0) 返回 1  
    	
    	//mock接口方法
    	HttpServletRequest request = mock(HttpServletRequest.class);  
    	when(request.getParameter(anyString())).thenReturn("boo");  
    	assertEquals(request.getParameter("foo"), "boo");
 
    	//answer重新实现接口方法
    	final Map<String, Object> map = new HashMap<String, Object>(); 
    	map.put("errMsg", "errMsg");
    	map.put("msg", "msg");
    	Answer<String> aswser = new Answer<String>() {    
    	    public String answer(InvocationOnMock invocation) {    
    	        Object[] args = invocation.getArguments();    
    	        return map.get(args[0].toString()).toString();    
    	    }   
    	};  
    	when(request.getAttribute("isRawOutput")).thenReturn(true);   
    	when(request.getAttribute("errMsg")).thenAnswer(aswser);   
    	when(request.getAttribute("msg")).thenAnswer(aswser);  
    	
    	assertEquals(request.getAttribute("isRawOutput"), true);
    	assertEquals(request.getAttribute("errMsg"), "errMsg");
    	assertEquals(request.getAttribute("msg"), "msg");
    	
    	Map mockMap = mock(Map.class);  
    	when(mockMap.get("city")).thenReturn("广州");
    	//调用两次
    	mockMap.get("city");
    	mockMap.get("city");
    	//调用行为判断
    	verify(mockMap).get(Matchers.eq("city"));  
    	//是否调用两次
    	verify(mockMap, times(2));    
    	
    }
	
}

