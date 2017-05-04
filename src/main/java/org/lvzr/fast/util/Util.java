package org.lvzr.fast.util;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * ������ת��
 * @author lvzr
 */
public class Util{
	
	private final static String ITEM_SPLIT_FLAG = ",";
 	
	private final static String KEY_VALUE_SPLIT_FLAG = ":";

	
	/*Array********************************************************/
	
	/**
	 * �ɱ��������Array
	 * @param items
	 * @return
	 */
	public static <T> T[] asArray(T... items){
		return items;
	}
	
	/**
	 * String����String Array
	 * @param items
	 * @return
	 */
	public static String[] asArray(String items){
		return items.split(ITEM_SPLIT_FLAG);		
	}
	 
	/**
	 * list����String Array
	 * @param items
	 * @return
	 */
	public static String[] asArray(List<String> items){
		return (String[])items.toArray(new String[items.size()]);
	}

	/**
	 * Array����String
	 * @param items
	 * @return
	 */
	public static String toString(Object[] items){	
		return Util.toString(Util.asList(items));
	}	
	
	/*List********************************************************/
	
	/**
	 * �ɱ��������List
	 * @param items
	 * @return
	 */
	public static <T> List<T> asList(T... items){
		return Arrays.asList(items);
	}

	/**
	 * String����List
	 * @param items ����item1,item2
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public static <T> List<T> asList(String items){
		List<T> resultList = new ArrayList<T>();
		String[] array = items.split(ITEM_SPLIT_FLAG);
		for(String item : array){
			resultList.add((T)item);
		}
		return resultList;
	}
	
	/**
	 * Map values����list
	 * @param map
	 * @return
	 */
	public static <K,V> List<V> asList(Map<K,V> map){
		List<V> resultList = new ArrayList<V>();
		for(Map.Entry<K, V> item: map.entrySet()){
			resultList.add(item.getValue());
		}
		return resultList;
	}
	
	/**
	 * Collection����String
	 * @param items
	 * @return
	 */
	public static <T> String toString(Collection<T> items){	
		String splitFlag = "";
		StringBuilder result = new StringBuilder();
		for(T item : items){
			result.append(splitFlag);
			result.append(item);
			splitFlag = ITEM_SPLIT_FLAG;
		}
		return result.toString();
	}
		
	/*Map********************************************************/

	/**
	 * �ɱ��������Map
	 * @param items
	 * @return
	 */
	public static <T> Map<T,T> asMap(T... items){
		Map<T,T> map = new HashMap<T, T>();
		int len = items.length;
		for(int i=0; i<len; i=i+2){
			map.put(items[i], items[i+1]);
		}
		return map;
	}
	
	/**
	 * StringתMap
	 * @param items ����key1:value1,key2:value2
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public static <K,V> Map<K,V> asMap(String items){
		Map<K,V> map = new HashMap<K, V>();
		String[] array = items.split(ITEM_SPLIT_FLAG);
		for(String item : array){
			String[] keyValue = item.split(KEY_VALUE_SPLIT_FLAG);
			K key = (K)keyValue[0];			
			V value = (V)keyValue[1];
			map.put(key, value);
		}
		return map;
	}
 
	/**
	 * List����Map
	 * @param items
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public static <K,V> Map<K, V> asMap(List<V> items){
		Map<K,V> map = new HashMap<K, V>();
		for(V item : items){
			map.put((K)item, item);
		}
		return map;
	}
	
	/**
	 * Map����String
	 * @param items
	 * @return ����key1:value1,key2:value2
	 */
	public static <K,V> String toString(Map<K,V> items){	
		String splitFlag = "";
		StringBuilder result = new StringBuilder();		
		for(Map.Entry<K, V> item: items.entrySet()){
			result.append(splitFlag);
			result.append(item.getKey());
			result.append(KEY_VALUE_SPLIT_FLAG);
			result.append(item.getValue());
			splitFlag = ITEM_SPLIT_FLAG;
		}
		return result.toString();
	}	
	
	/*Main()********************************************************/

	/**
	 * main
	 * @param args
	 */
	public static void main(String[] args){

		//intArray
		Integer[] intArray = Util.asArray(1,2,3,4,5);
		System.out.println("intArray��"+Util.toString(intArray));
		
		//strArray
		String[] strArray = Util.asArray("aa,bb,cc");
		System.out.println("strArray��"+Util.toString(strArray));

		//intList
		List<Integer> intList = Util.asList("1,2,3");			
		System.out.println("intList��"+Util.toString(intList));
		
		//strList
		List<String> strList = Util.asList("xx,yy,zz");			
		System.out.println("strList��"+Util.toString(strList));

		//intList2
		List<Integer> intList2 = Util.asList(1,2,3);			
		System.out.println("intList2��"+Util.toString(intList2));
		
		//intMap
		Map<Integer,Integer> intMap = Util.asMap("1:101,2:202");
		System.out.println("intMap��"+Util.toString(intMap));
 
		//intMap2
		Map<Integer,Integer> intMap2 = Util.asMap(3,300, 4,400, 5,500);
		System.out.println("intMap2��"+Util.toString(intMap2));

		//strMap
		Map<String,String> strMap = Util.asMap("key1:value1,key2:value2");
		System.out.println("strMap��"+Util.toString(strMap));
		
		//strIntMap
		Map<String,Integer> strIntMap = Util.asMap("key1:700,key2:800");
		System.out.println("strIntMap��"+Util.toString(strIntMap));

		//intStrMap
		Map<Integer,String> intStrMap = Util.asMap("700:value1,800:value2");
		System.out.println("intStrMap��"+Util.toString(intStrMap));
 
		//ListתArray
		System.out.println("strList->strArray��"+Util.toString(Util.asArray(strList)));
		
		//ArrayתList
		System.out.println("strArray->strList��"+Util.toString(Util.asList(strArray)));
		
		//MapתList
		System.out.println("strMap->strList��"+Util.toString(Util.asList(strMap)));
		
		//ListתMap
		System.out.println("list->map��"+Util.toString(Util.asMap(strList)));

		
		System.out.println("***************************************");
		//��Map keyת��ΪSet      
        Set<String> mapKeySet = strMap.keySet();    
        System.out.println("mapKeySet��"+mapKeySet);  
          
        //��Map valueת��ΪSet      
        Set<String> mapValuesSet = new HashSet<String>(strMap.values());    
        System.out.println("mapValuesSet��"+mapValuesSet);  
        
		//Map keyת��List
		List<String> mapKeyList = new ArrayList<String>(strMap.keySet());    
        System.out.println("mapKeyList��"+mapKeyList);  
        
        //Map valueת��List
        List<String> mapValuesList = new ArrayList<String>(strMap.values());    
        System.out.println("mapValuesList��"+mapValuesList);  

        System.out.println("***************************************");
        //����-->List
        List<String> arrayList = Arrays.asList(strArray);    
        System.out.println("arrayList��"+arrayList);   
        
        //����-->Set    
        Set<String> arraySet = new HashSet<String>(Arrays.asList(strArray));    
        System.out.println("arraySet��"+arraySet);    

        //List-->����
        Object[] listArray = strList.toArray();    
        System.out.println("listArray��"+Util.toString(listArray));   
        
        //Set-->����
        Object[] setArray = arraySet.toArray();    
        System.out.println("setArray��"+Util.toString(setArray));   
        
	}
	
}