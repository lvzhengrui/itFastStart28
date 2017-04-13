package org.lvzr.fast.bigdata.spark.rdd;

 
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.apache.spark.api.java.JavaDoubleRDD;
import org.apache.spark.api.java.JavaPairRDD;
import org.apache.spark.api.java.JavaRDD;
import org.apache.spark.api.java.JavaSparkContext;
import org.apache.spark.api.java.function.DoubleFunction;
import org.apache.spark.api.java.function.FlatMapFunction;
import org.apache.spark.api.java.function.Function;
import org.apache.spark.api.java.function.Function2;
import org.apache.spark.api.java.function.PairFunction;
import org.apache.spark.storage.StorageLevel;

import scala.Tuple2;

/**
 * http://www.cnblogs.com/zhoudayang/p/5008010.html
 * @author lvzr
 *
 */
public class Rdd{
	
	public static void main(String[] args){
		//spark上下文
		String inputFile = "";
		JavaSparkContext sc = new JavaSparkContext(args[0], "Rdd",
				System.getenv("SPARK_HOME"), JavaSparkContext.jarOfClass(Rdd.class));
		//读取一个外部数据集
		JavaRDD<String> lines = sc.textFile(inputFile);
		
		//创建rdd
		List<String> list=new ArrayList<String>();
		list.add("a");
		list.add("b");
		list.add("c");
		JavaRDD<String> temp=sc.parallelize(list);
		//上述方式等价于
		JavaRDD<String> temp2=sc.parallelize(Arrays.asList("a","b","c"));
		
		//转化
		list=new ArrayList<String>();
		//建立列表，列表中包含以下自定义表项
		list.add("error:a");
		list.add("error:b");
		list.add("error:c");
		list.add("warning:d");
		list.add("hadppy ending!");
		//将列表转换为RDD对象
		lines = sc.parallelize(list);
		//将RDD对象lines中有error的表项过滤出来，放在RDD对象errorLines中
		JavaRDD<String> errorLines = lines.filter(
		        new Function<String, Boolean>() {
		            public Boolean call(String v1) throws Exception {
		                return v1.contains("error");
		            }
		        }
		);
		//遍历过滤出来的列表项
		List<String> errorList = errorLines.collect();
		for (String line : errorList){
		    System.out.println(line);
		}
		
		//union()
		JavaRDD<String> warningLines=lines.filter(
		        new Function<String, Boolean>() {
		            public Boolean call(String v1) throws Exception {
		                return v1.contains("warning");
		            }
		        }
		);
		JavaRDD<String> unionLines=errorLines.union(warningLines);
		for(String line :unionLines.collect()){
		    System.out.println(line);   
		}
		
		//take(2)
		unionLines=errorLines.union(warningLines);
		for(String line :unionLines.take(2)){
		    System.out.println(line);
		}
		
		//collect
		List<String> unions=unionLines.collect();
		for(String line :unions){
		    System.out.println(line);
		}
		
		//Function<T,R>
		JavaRDD<String> errorLines2 = lines.filter(
		        new Function<String, Boolean>() {
		            public Boolean call(String v1)throws Exception {
		                return v1.contains("error");
		            }
		        }
		);
		
		//flatMapFuncton<T,R>
		List<String> strLine=new ArrayList<String>();
		strLine.add("how are you");
		strLine.add("I am ok");
		strLine.add("do you love me");
		JavaRDD<String> input=sc.parallelize(strLine);
		JavaRDD<String> words=input.flatMap(
		        new FlatMapFunction<String, String>() {
		            public Iterable<String> call(String s) throws Exception {
		                return Arrays.asList(s.split(" "));
		            }
		        }
		);
		
		//Functionn2<T1,T2,R>
		//PairFunction<T1,R1,R2>
		strLine=new ArrayList<String>();
		strLine.add("how are you");
		strLine.add("I am ok");
		strLine.add("do you love me");
		input=sc.parallelize(strLine);
		JavaRDD<String> words2 =input.flatMap(
		        new FlatMapFunction<String, String>() {
		            public Iterable<String> call(String s) throws Exception {
		                return Arrays.asList(s.split(" "));
		            }
		        }
		);
		JavaPairRDD<String,Integer> counts2=words2.map(
		        new PairFunction<String, String, Integer>() {
		            public Tuple2<String, Integer> call(String s) throws Exception {
		                return new Tuple2(s, 1);
		            }
		        }
		);
		JavaPairRDD <String,Integer> results2=counts2.reduceByKey(
		        new Function2<Integer, Integer, Integer>() {
		            public Integer call(Integer v1, Integer v2) throws Exception {
		                return v1 + v2;
		            }
		        }
		) ;
		
		//具名类
		class ContainFunc extends Function<String,Boolean>{
			private String containWord;
			public ContainFunc(String containWord){
				super();
				this.containWord = containWord;
			}
		    public Boolean call(String v1) throws Exception {
		        return v1.contains(this.containWord);
		    }
		}
		JavaRDD<String> errorLines3 = lines.filter(new ContainFunc("error"));
		for(String line :errorLines3.collect()){
		    System.out.println(line);
		}
		
		//map
		JavaRDD<Integer> rdd =sc.parallelize(Arrays.asList(1,2,3,4));
		JavaRDD<Integer> result=rdd.map(
		    new Function<Integer, Integer>() {
		        public Integer call(Integer v1) throws Exception {
		        return v1*v1;
		        }
		    }
		);
		System.out.println(StringUtils.join(result.collect(),","));
		
		//filter
		JavaRDD<Integer> rdd2 =sc.parallelize(Arrays.asList(1,2,3,4));
		JavaRDD<Integer> results=rdd2.filter(
			new Function<Integer, Boolean>() {
				public Boolean call(Integer v1) throws Exception {
					return v1!=1;
		        }
		    }
		);
		System.out.println(StringUtils.join(results.collect(),","));
		
		//flatMap
		JavaRDD<String> rdd3 =sc.parallelize(Arrays.asList("hello world","hello you","world i love you"));
		JavaRDD<String> words3 = rdd3.flatMap(
		    new FlatMapFunction<String, String>() {
		        public Iterable<String> call(String s) throws Exception {
		            return Arrays.asList(s.split(" "));
		        }
		    }
		);
		System.out.println(StringUtils.join(words3.collect(),'\n'));
		
		//cartesian笛卡尔积
		JavaRDD<Integer> rdda = sc.parallelize(Arrays.asList(1,2));
		JavaRDD<Integer> rddb = sc.parallelize(Arrays.asList(1,2));
		//2x2两两相交，返回四组
		JavaPairRDD<Integer ,Integer> rddc=rdda.cartesian(rddb);
		for(Tuple2<Integer,Integer> tuple:rddc.collect()){
		    System.out.println(tuple._1()+"->"+tuple._2());
		}
	
		//reduce
		JavaRDD<Integer> rddr = sc.parallelize(Arrays.asList(1,2,3,4,5,6,7,8,9,10));
		Integer sum =rddr.reduce(
		    new Function2<Integer, Integer, Integer>() {
		        public Integer call(Integer v1, Integer v2) throws Exception {
		            return v1+v2;
		        }
		    }
		);
		System.out.println(sum.intValue());
		
		//fold，给出初始化再reduce
		JavaRDD<Integer> rddf = sc.parallelize(Arrays.asList(1,2,3,4,5,6,7,8,9,10));
		Integer sum2 =rddf.fold(0,
		        new Function2<Integer, Integer, Integer>() {
		            public Integer call(Integer v1, Integer v2) throws Exception {
		                return v1+v2;
		            }
		        }
		);
		System.out.println(sum2);
		
		//持久化
		JavaRDD<Integer> rdds =sc.parallelize(Arrays.asList(1,2,3,4,5));
		rdds.persist(StorageLevel.MEMORY_ONLY());
		System.out.println(rdds.count());
		System.out.println(StringUtils.join(rdds.collect(),','));
		
		
		//两个专门的类JavaDoubleRDD和JavaPairRDD
		JavaRDD<Integer> rddd =sc.parallelize(Arrays.asList(1,2,3,4,5));
		JavaDoubleRDD resultd=rddd.map(
		    new DoubleFunction<Integer>() {
		        public Double call(Integer integer) throws Exception {
		            return (double) integer*integer;
		        }
		    }
		);
		System.out.println(resultd.count());
		
	}
	
	
 
	
}