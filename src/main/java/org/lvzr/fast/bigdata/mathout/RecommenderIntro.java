package org.lvzr.fast.bigdata.mathout;

import org.apache.mahout.cf.taste.impl.model.file.*;  
import org.apache.mahout.cf.taste.impl.neighborhood.*;  
import org.apache.mahout.cf.taste.impl.recommender.*;  
import org.apache.mahout.cf.taste.impl.similarity.*;  
import org.apache.mahout.cf.taste.model.*;  
import org.apache.mahout.cf.taste.neighborhood.*;  
import org.apache.mahout.cf.taste.recommender.*;  
import org.apache.mahout.cf.taste.similarity.*;  
import java.io.*;  
import java.util.*;  

/**
 * 
 * @author lvzr
 */

public class RecommenderIntro {  
    private RecommenderIntro(){};  
      
    public static void main (String args[])throws Exception{  
        // step:1 ����ģ�� 2 �������ƶ� 3 ����k���� 4 �����Ƽ�����   
        DataModel  model =new FileDataModel(
        		new File("E:/project/wsx/fast/src/main/java/org/lvzr/fast/bigdata/mathout/test.txt"));//�ļ���һ��Ҫ�Ǿ���·��   
        UserSimilarity similarity =new PearsonCorrelationSimilarity(model);  
        UserNeighborhood neighborhood =new NearestNUserNeighborhood(2,similarity,model);  
        Recommender recommender= new GenericUserBasedRecommender(model,neighborhood,similarity);  
        List<RecommendedItem> recommendations =recommender.recommend(1, 2);//Ϊ�û�1�Ƽ�����ItemID   
        for(RecommendedItem recommendation :recommendations){  
            System.out.println(recommendation);  
        }  
          
    }  
}  