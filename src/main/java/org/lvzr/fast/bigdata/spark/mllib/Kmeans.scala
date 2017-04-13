import org.apache.log4j.{Level, Logger}
import org.apache.spark.{SparkConf, SparkContext}
import org.apache.spark.mllib.clustering.KMeans
import org.apache.spark.mllib.linalg.Vectors
 
object Kmeans {

  def main(args: Array[String]) {
    // ���β���Ҫ����־��ʾ���ն���
    Logger.getLogger("org.apache.spark").setLevel(Level.WARN)
    Logger.getLogger("org.eclipse.jetty.server").setLevel(Level.OFF)
 
    // �������л���
    val conf = new SparkConf().setAppName("Kmeans").setMaster("local[4]")
    val sc = new SparkContext(conf)
 
    // װ�����ݼ�
    val data = sc.textFile("/home/hadoop/upload/class8/kmeans_data.txt", 1)
    val parsedData = data.map(s => Vectors.dense(s.split(' ').map(_.toDouble)))
 
    // �����ݼ����࣬2���࣬20�ε���������ģ��ѵ���γ�����ģ��
    val numClusters = 2
    val numIterations = 20
    val model = KMeans.train(parsedData, numClusters, numIterations)
 
    // ��ӡ����ģ�͵����ĵ�
    println("Cluster centers:")
    for (c <- model.clusterCenters) {
      println("  " + c.toString)
    }
 
    // ʹ�����ƽ��֮������������ģ��
    val cost = model.computeCost(parsedData)
    println("Within Set Sum of Squared Errors = " + cost)
 
    // ʹ��ģ�Ͳ��Ե�������
	println("Vectors 0.2 0.2 0.2 is belongs to clusters:" + model.predict(Vectors.dense("0.2 0.2 0.2".split(' ').map(_.toDouble))))
	println("Vectors 0.25 0.25 0.25 is belongs to clusters:" + model.predict(Vectors.dense("0.25 0.25 0.25".split(' ').map(_.toDouble))))
	println("Vectors 8 8 8 is belongs to clusters:" + model.predict(Vectors.dense("8 8 8".split(' ').map(_.toDouble))))
	 
    // ��������1��ֻ���ؽ��
    val testdata = data.map(s => Vectors.dense(s.split(' ').map(_.toDouble)))
    val result1 = model.predict(testdata)
   result1.saveAsTextFile("/home/hadoop/upload/class8/result_kmeans1")
 
    // ��������2���������ݼ��ͽ��
    val result2 = data.map {
      line =>
        val linevectore = Vectors.dense(line.split(' ').map(_.toDouble))
        val prediction = model.predict(linevectore)
        line + " " + prediction
    }.saveAsTextFile("/home/hadoop/upload/class8/result_kmeans2")
 
    sc.stop()
  }
  
}

