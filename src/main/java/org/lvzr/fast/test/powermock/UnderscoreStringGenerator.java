package org.lvzr.fast.test.powermock;

import java.util.ArrayList;
import java.util.List;

public class UnderscoreStringGenerator{

        private static String[] UnderscoreStrings = "user_name,first_begin_time,end_time,start_date,end_date,from_site,one_column,two_row".split(",");

        /**
         * 获取随机产生的下划线分隔字符
         * 可mock静态、final、私有方法
         * @param itemNum
         * @return
         */
        public static List<String> getRandomUnderscoreStrings(int itemNum){
            List<String> resultList = new ArrayList<String>(itemNum);
            int randomIndex = 0;
            for(int i=0;i<itemNum;i++){
                randomIndex = (int)Math.random()*(UnderscoreStrings.length-1);
                resultList.add(UnderscoreStrings[randomIndex]);
            }
            return resultList;
        }
        
        /**
         * 普通公共方法
         * @param itemNum
         * @return
         */
        public List<String> getRandomUnderscoreStringsNormal(int itemNum){
            List<String> resultList = new ArrayList<String>(itemNum);
            int randomIndex = 0;
            for(int i=0;i<itemNum;i++){
                randomIndex = (int)Math.random()*(UnderscoreStrings.length-1);
                resultList.add(UnderscoreStrings[randomIndex]);
            }
            return resultList;
        }
        
        



    }

