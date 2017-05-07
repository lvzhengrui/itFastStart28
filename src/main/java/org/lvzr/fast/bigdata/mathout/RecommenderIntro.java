package org.lvzr.fast.bigdata.mathout;

import java.io.File;
import java.util.List;

import org.apache.mahout.cf.taste.impl.model.file.FileDataModel;
import org.apache.mahout.cf.taste.impl.neighborhood.NearestNUserNeighborhood;
import org.apache.mahout.cf.taste.impl.recommender.GenericUserBasedRecommender;
import org.apache.mahout.cf.taste.impl.similarity.PearsonCorrelationSimilarity;
import org.apache.mahout.cf.taste.model.DataModel;
import org.apache.mahout.cf.taste.neighborhood.UserNeighborhood;
import org.apache.mahout.cf.taste.recommender.RecommendedItem;
import org.apache.mahout.cf.taste.recommender.Recommender;
import org.apache.mahout.cf.taste.similarity.UserSimilarity;  

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