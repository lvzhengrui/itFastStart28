Դ����google��MapReduce���ģ�������2004��12�£�Hadoop MapReduce��google MapReduce ��¡�档
Դ����google��MapReduce����
MapReduce��һ�ּ���ģ�ͣ����Խ��д��������ļ��㡣����Map�����ݼ��ϵĶ���Ԫ�ؽ���ָ���Ĳ��������ɼ�-ֵ����ʽ�м�����
Reduce����м�������ͬ�����������С�ֵ�����й�Լ���Եõ����ս����MapReduce�����Ĺ��ܻ��֣��ǳ��ʺ��ڴ����������ɵķֲ�ʽ���л�����������ݴ���

JobTracker��Master�ڵ㣬ֻ��һ��������������ҵ����ҵ/����ļ�ء�������ȣ�������ֽ��һϵ�����񣬲����ɸ�TaskTracker��
TaskTracker��Slave�ڵ㣬����Map Task��Reduce Task������JobTracker�������㱨����״̬��
Map Task������ÿ�����ݼ�¼�����ݸ��û���д��map(),��ִ�У���������д�뱾�ش���(���Ϊmap-only��ҵ��ֱ��д��HDFS)��
Reducer Task����Map Task��ִ�н���У�Զ�̶�ȡ�������ݣ������ݽ������򣬽����ݰ��շ��鴫�ݸ��û���д��reduce����ִ�С�



--------------------------------------------
###MapReduce��������
http://www.toutiao.com/i6409526349823738369/?tt_from=weixin&utm_campaign=client_share&from=singlemessage&app=news_article&utm_source=weixin&isappinstalled=1&iid=7841861916&utm_medium=toutiao_ios&wxshare_count=2&pbid=41749390721


###yarn���
YARN��Hadoop2.x����µ���Դ����ϵͳ������ɲ���Ϊ��
1��ȫ����Դ��������global resource manager��������ϵͳ����Դ����͵��䡣
2���ڵ��������node manager����ÿ���ڵ㶼��һ����������������������ü�����Դ�ļ��
3�����ÿ��Ӧ�ó����Ӧ�ó����������application-specific application master������ΪHadoop2.x֧�ֵļ������кܶ࣬
	��ֻ��MapReduce��������storm��spark��Tez��ͬ������Ƶļ����ܣ�����MapReduce��һ��Ӧ�ó���
	ÿ��MapReduce��ҵ��MapReduce���ͳ����һ��ʵ����
4����������scheduler��������Դ�������
5��������container����һ����CPU���ڴ����һ����������Ϊ��Դʹ�ã�һ��Ӧ�ó���������һ�������С�
	���˽��˸�������Ĺ���֮�󣬽�����ͼyarn.jpg�����ǿ�һ���ύһ����ҵ�����̣�

###yarn����
1���ͻ�������Դ�������ύ��ҵ������ҵ��������;�����ʹ������Ӧ�ó����������MapReduce��storm��Tez...��
2����Դ������Э����Դ����һ���ڵ��ϻ�ȡһ������Ӧ�ó��������ʵ��������
3��Ӧ�ó����������application master������Դ��������ע��
4��Ӧ�ó��������ͨ����Դ��������Դ������Э����Դ���������������ڵĽڵ�͸���������ϸ˵����CPU���������ڴ��С��
5���� 6��Ӧ�ó����������һ���ڵ��ϻ��߶���ڵ���������Map Task��Reduce Task
7�������������е�Ӧ�ó�����Ӧ�ó���������㱨ִ�ж�
8��Ӧ�ó���ִ����ϣ�Ӧ�ó���������ͻ����Դ��������ȡ��ע�ᣬ��ҵռ�õ���Դ���ͷŵ�ϵͳ��



###MapReduce������

MapReduce�ܵĿ��Է�Ϊmap�׶Ρ�shuffle�׶κ�reduce�׶Ρ�

###map�׶�
1����HDFS�н�����ֵ���䵽Mapper�ڵ�
���˴���֮�⣬�ڶ�ȡ�����У�����Ҫ��һ��ת�����̣�������ת��Ϊ��ֵ�Ե���ʽ��MapReduce������������Ϊ��ֵ�Ե���ʽ����
�������ͨ��InputFormat��ɣ�Ĭ��ΪTextInputFormat��

2��Mapper
�����Լ�д��Mapper�������ļ����д���ͬ��������Ǽ�ֵ�ԣ���wordcount��ͳ���յ���������ÿ���ʳ��ֵĴ�����

3��Partitioner
Patitioner����Reducer���������Զ���Ļ��ַ�����û���Զ���Ļ���Hadoop��Ĭ��ʵ�֣�ȥ����Mapper����������ֵĽ���ᰴ��Mapper����ļ���������

4��Combiner��***��һ���ǿ�ѡ��***��
����Partitioner����������ҵ��������Combiner���ͻ����Combiner��Combiner�ͺ�����Mapper����ǰ����һ��Reducerһ����
��ΪʲôҪ��ǰ�����أ�����Ϊ�˾������ٶ������������󣬱��羭���wordcount������Mapper�˴���֮�����ǿ��ܵõ�һ����key = apple��
value = {1,1,1,1,1,1}�Ľ��������������ȶ������һ��Combiner����ô���ܵõ�key = apple��value = 6�Ľ�����������������ݣ�
�϶���Ҫ��key = apple��value = {1,1,1,1,1,1}�����ݽ�ʡ����ġ�
�Ǽ�Ȼ�ܹ���ʡ�������Ϊʲô���ǿ�ѡ���أ��β�ÿ�ζ�Ĭ��ִ��Combiner��������Ϊ������ÿһ��Mapper���ܽ���Combiner�������������ǵ���
��Ҫͳ��һ��ʱ���ڵ�ÿ���������£����迪ʼ������Mapper�����Ϊ��0��10��20���ͣ�15��25������ô��ǰ����Combiner����ʹ�ô��ݸ�Reducer
�˵�����Ϊ��20�� 25���������Ľ������Ϊ25���Ҵ������������С�����Ǽ�������Ҫ��һ��ʱ���ڵ�ƽ���¶��أ������ʼ����Mapper�˽���Combiner��ƽ
���¶ȣ���ôReducer�˵õ�������Ϊ��10, 20���������ƽ���¶�Ϊ15������ʵ���ϵ�ƽ���¶�Ϊ��0�� 10�� 20 �� 15 ��25����ƽ����Ϊ14��
***������Ҫ�����Combiner���ʲ�������ǰ����***��


###shuffle�׶�
shuffle�׶�Ҫ�����¾��Ǳ�֤Mapper��������ݴ��䵽���ʵ�Reducer���д�������ͼ��ʾ��

shuffle�׶Σ�ÿ��Reducer����ʹ��HTTPЭ���Mapper�ڵ����Լ��Ļ��֣�Reducerͨ��Application Master����ȡ�Լ�Ӧ�ò�ѯ��ЩMapper
�ڵ�����ȡ�Լ����ֵ���Ϣ����Ϊÿ��Mapperʵ����ɺ󣬻�֪ͨApplication Master���н׶β����Ļ��֣�


###reduce�׶�
1��Reducer
�����Լ�д��reduce��������ݽ��д�����wordcount�н�ÿ�����ʳ��ֵĴ����������õ��ܺͣ�
2���������������HDFS


###�ܽ�
ͨ����Hadoop2.x��ܵĴ������̺�MapReduce�����ܵĴ������̵����������ڽ��г����дʱ��һ�����������ʶ����һ��Ӧ�þ�����Щʲô��
 �Ƽ�
 
--------------------------------------------------------------------
###Mapreduce��Combiner��ʹ�ü�����
http://blog.csdn.net/guoery/article/details/8529004

����Combiner�м�����Ҫ˵�����ǣ�

1���кܶ�����Ϊ���combiner��map��������ݺϲ���һ�����̣���ʵ��Ȼ��map��������ݺϲ�ֻ�������������spill����ʱ�򣬼�����merge������

2����mapper��reducer��ͬ���ǣ�***combinerû��Ĭ�ϵ�ʵ�֣���Ҫ��ʽ��������conf�в�������***��

3�����������е�job������combiner��ֻ�в����������ɵĲſ�����combiner��combine���������ڣ�opt(opt(1, 2, 3), opt(4, 5, 6))��
���optΪ��͡������ֵ�Ļ�������ʹ�ã��������������ֵ�Ļ��������á�

4��һ����˵��combiner��reducer����������ͬ���Ĳ�����

���ǣ��ر�ֵ��ע���һ�㣬һ��combinerֻ�Ǵ���һ������еĵ������������������reduceһ�������루������shuffle�׶ε����ݣ���
���ǳ��ؼ�������ԭ��鿴��������������ͣ�

������reduce�ǿɽ���������ϵģ���ô��Ҳ�Ϳ�����Ϊһ��Combiner��***��ֻҪ��driver������������д���Ϳ����ڴ�Ƶͳ�Ƴ���������Combiner***��


--------------------------------------------------------------------
###MapReduceʹ��combiner�Ż�����
http://blog.csdn.net/moxiaomomo/article/details/15676575

(ʾ��Ϊ��HBase���ȡ���ݣ����㣬Ȼ��д����һ��HBase����)

Configuration configuration = HBaseConfiguration.create();  
Job job = new Job(configuration, "test_mr");  
ob.setJarByClass(Test.class);            
job.setNumReduceTasks(4);  // reduce��������Ĭ��Ϊ1  
          
Scan scan = new Scan();  
scan.setCacheBlocks(false);   
scan.setCaching(1000); //ÿ�δӷ������˶�ȡ��������Ĭ��Ϊ�����ļ������õ�ֵ  
TableMapReduceUtil.initTableMapperJob("table_for_read", scan, MyMapper.class, ImmutableBytesWritable.class, ImmutableBytesWritable.class, job);  

job.setCombinerClass(MyCombiner.class);   //***����combiner***  

TableMapReduceUtil.initTableReducerJob("table_to_write", MyReducer.class, job);  
          
job.waitForCompletion(true);  
















