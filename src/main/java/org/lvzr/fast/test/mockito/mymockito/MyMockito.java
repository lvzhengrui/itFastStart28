package org.lvzr.fast.test.mockito.mymockito;

import java.util.HashMap;
import java.util.Map;

public class MyMockito {  
	
	public static final Map<MethodKey, Object> MOCKED_METHOD_KEYS = new HashMap<MethodKey, Object>();  

    private MethodKey methodKey;  
     
    public MyMockito(MethodKey methodKey) {
		this.methodKey = methodKey;
	}
    
    public static Object mock(Class clazz){
    	return new MyMockCglib().getInstance(clazz);
    }

    public static MyMockito when(Object methodCall) {  
        return new MyMockito((MethodKey)methodCall);  
    }  
    
    public void thenReturn(final Object mockResult) {  
        MyMockito.MOCKED_METHOD_KEYS.put(methodKey, mockResult);  
    }  
 
}  