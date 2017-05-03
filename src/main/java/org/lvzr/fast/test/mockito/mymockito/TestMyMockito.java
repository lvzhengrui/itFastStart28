package org.lvzr.fast.test.mockito.mymockito;

import java.util.List;
import java.util.Map;

public class TestMyMockito {  

    public static void main(String[] args) {  
        
    	List<String> myMockList1 = (List<String>)MyMockito.mock(List.class);           
        
        List<String> myMockList2 = (List<String>)MyMockito.mock(List.class);          
        
        Map<Integer, String> myMockMap = (Map<Integer, String>)MyMockito.mock(Map.class);   
        
        MyMockito.when(myMockList1.get(0)).thenReturn("Hello, I am James");  
        MyMockito.when(myMockList1.get(2)).thenReturn("Hello, I am Billy");  
        MyMockito.when(myMockList2.get(0)).thenReturn("Hello, I am Tom");  
        MyMockito.when(myMockMap.get(10)).thenReturn("Hello, I am Bob");  
          
        System.out.println("myMockList1.get(0) = " + myMockList1.get(0));  
        System.out.println("myMockList1.get(2) = " + myMockList1.get(2));  
        System.out.println("myMockList2.get(0) = " + myMockList2.get(0));  
        System.out.println("myMockMap.get(10) = " + myMockMap.get(10));  
    }  
}  