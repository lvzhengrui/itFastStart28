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
 * mockito��Ԫ����
 * http://blog.csdn.net/zhangxin09/article/details/42422643
 *
 */
public class TestMockito{
	
    @Test  
    public void simpleTest(){  
          
        //����mock���󣬲����������࣬Ҳ�����ǽӿ�  
        List<String> list = mock(List.class);  
          
        //���÷�����Ԥ�ڷ���ֵ  
        when(list.get(0)).thenReturn("helloworld");  
      
        String result = list.get(0);  
          
        //��֤��������(�Ƿ������get(0))  
        verify(list).get(0);  
          
        //junit����  
        Assert.assertEquals("helloworld", result);  
    }  
    
    @Test
    public void simpleTest2(){  
    	List mock = mock(List.class);  
    	when( mock.get(0) ).thenReturn(1);  
    	assertEquals( "Ԥ�ڷ���1", 1, mock.get(0));// mock.get(0) ���� 1  
    	
    	//mock�ӿڷ���
    	HttpServletRequest request = mock(HttpServletRequest.class);  
    	when(request.getParameter(anyString())).thenReturn("boo");  
    	assertEquals(request.getParameter("foo"), "boo");
 
    	//answer����ʵ�ֽӿڷ���
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
    	when(mockMap.get("city")).thenReturn("����");
    	//��������
    	mockMap.get("city");
    	mockMap.get("city");
    	//������Ϊ�ж�
    	verify(mockMap).get(Matchers.eq("city"));  
    	//�Ƿ��������
    	verify(mockMap, times(2));    
    	
    }
	
}

