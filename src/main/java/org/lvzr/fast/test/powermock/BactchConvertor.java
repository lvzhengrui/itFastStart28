package org.lvzr.fast.test.powermock;

import java.util.ArrayList;
import java.util.List;

public class BactchConvertor{

	/**
	 * 将以下划线分隔的字符串转为驼峰格式
	 * 如user_name=>userName,first_begin_time=>firstBeginTime
	 * 前导，后导的“_”忽略之，中间有多个相连的"_"当成一个处理
	 * @param item
	 * @return
	 */
    public String underscoreToCamel(String item){
        String preItem="",result = "";
        char[] items = item.toCharArray();
        for(char item1 : items){
            if("_".equals(String.valueOf(item1))){

            }else if("_".equals(preItem)){
                result += String.valueOf(item1).toUpperCase();
            }else{
                result += String.valueOf(item1).toLowerCase();
            }
            preItem = String.valueOf(item1);
        }
        return result;
    }

    /**
     * 获取指定个数的驼峰格式的字符串
     * @param itemNum
     * @return
     */
    public List<String> getCamelStringList(int itemNum){
        List<String> resultList = new ArrayList<String>(itemNum);
        
        List<String> sources =  UnderscoreStringGenerator.getRandomUnderscoreStrings(itemNum);
        for(String source :sources){
            resultList.add(underscoreToCamel(source));
        }
        return resultList;
    }



    
    
}

