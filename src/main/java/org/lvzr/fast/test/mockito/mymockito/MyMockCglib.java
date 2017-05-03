package org.lvzr.fast.test.mockito.mymockito;

import java.lang.reflect.Method;

import org.springframework.cglib.proxy.Enhancer;
import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.cglib.proxy.MethodProxy;

public class MyMockCglib implements MethodInterceptor {  
	
	public Object intercept(Object obj, Method method, Object[] args, MethodProxy proxy) throws Throwable {
        
		final MethodKey key = new MethodKey(this, method, args);  
        
        final boolean hasMocked = MyMockito.MOCKED_METHOD_KEYS.containsKey(key);  
        
        if (!hasMocked) {  
            // When called for the first time (by MyMockito.when(...)),  
            // return a MethodInfo object used as key,  
            // so that the later MethodInfo.thenReturn(...) will use this key  
            // to insert mock result into the MyMockito.MOCKED_METHODS.  
            System.out.println("Initializing the mock for " + key.toString());  
            return key;  
        } else {  
            // Now that MyMockito.MOCKED_METHODS already contains the mock result  
            // for this method call, just return the mock result.  
            System.out.println("Returns the mock result:");  
            return MyMockito.MOCKED_METHOD_KEYS.get(key);  
        }
        
	}  
	  
    public Object getInstance(final Class<?> t) {  
        final Enhancer enhancer = new Enhancer();    
        enhancer.setSuperclass(t);    
        enhancer.setCallback(this);    
        return enhancer.create();  
    }


}  