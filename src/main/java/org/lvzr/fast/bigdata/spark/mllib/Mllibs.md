http://www.cnblogs.com/shishanyuan/p/4747761.html

 
###--------------�����㷨
import org.apache.spark.SparkContext
import org.apache.spark.mllib.classification.SVMWithSGD
import org.apache.spark.mllib.regression.LabeledPoint
 
// ���غͽ��������ļ�
val data = sc.textFile("mllib/data/sample_svm_data.txt")
val parsedData = data.map { line =>
  val parts = line.split(' ')
  LabeledPoint(parts(0).toDouble, parts.tail.map(x => x.toDouble).toArray)
}
 
// ���õ������������н���ѵ��
val numIterations = 20
val model = SVMWithSGD.train(parsedData, numIterations)
 
// ͳ�Ʒ���������������
val labelAndPreds = parsedData.map { point =>
val prediction = model.predict(point.features)
(point.label, prediction)
}
val trainErr = labelAndPreds.filter(r => r._1 != r._2).count.toDouble / parsedData.count
println("Training Error = " + trainErr)


###-----------------�ع��㷨
import org.apache.spark.mllib.regression.LinearRegressionWithSGD
import org.apache.spark.mllib.regression.LabeledPoint
 
// ���غͽ��������ļ�
val data = sc.textFile("mllib/data/ridge-data/lpsa.data")
val parsedData = data.map { line =>
  val parts = line.split(',')
  LabeledPoint(parts(0).toDouble, parts(1).split(' ').map(x => x.toDouble).toArray)
}
 
//���õ�������������ѵ��
val numIterations = 20
val model = LinearRegressionWithSGD.train(parsedData, numIterations)
 
// ͳ�ƻع�������������
val valuesAndPreds = parsedData.map { point =>
val prediction = model.predict(point.features)
(point.label, prediction)
}
val MSE = valuesAndPreds.map{ case(v, p) => math.pow((v - p), 2)}.reduce(_ + _)/valuesAndPreds.count
println("training Mean Squared Error = " + MSE)


###----------------�����㷨
import org.apache.spark.mllib.clustering.KMeans
 
// ���غͽ��������ļ�
val data = sc.textFile("kmeans_data.txt")
val parsedData = data.map( _.split(' ').map(_.toDouble))
// ���õ�����������صĸ���
val numIterations = 20
val numClusters = 2
 
// ����ѵ��
val clusters = KMeans.train(parsedData, numClusters, numIterations)
 
// ͳ�ƾ���������������
val WSSSE = clusters.computeCost(parsedData)
println("Within Set Sum of Squared Errors = " + WSSSE)



###------------------Эͬ����
import org.apache.spark.mllib.recommendation.ALS
import org.apache.spark.mllib.recommendation.Rating
 
// ���غͽ��������ļ�
val data = sc.textFile("mllib/data/als/test.data")
val ratings = data.map(_.split(',') match {
case Array(user, item, rate) => Rating(user.toInt, item.toInt, rate.toDouble)
})
 
// ���õ�������
val numIterations = 20
val model = ALS.train(ratings, 1, 20, 0.01)
 
// ���Ƽ�ģ�ͽ�������
val usersProducts = ratings.map{ case Rating(user, product, rate) => (user, product)}
val predictions = model.predict(usersProducts).map{
case Rating(user, product, rate) => ((user, product), rate)
}
val ratesAndPreds = ratings.map{
case Rating(user, product, rate) => ((user, product), rate)
}.join(predictions)
val MSE = ratesAndPreds.map{
case ((user, product), (r1, r2)) => math.pow((r1- r2), 2)
}.reduce(_ + _)/ratesAndPreds.count
println("Mean Squared Error = " + MSE)





