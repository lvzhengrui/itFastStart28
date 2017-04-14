

HBase和HDFS数据互导程序
http://blog.csdn.net/jethai/article/details/52345071
 
Configuration conf = HBaseConfiguration.create();  
conf.set("hbase.zookeeper.quorum", "192.168.1.139");  
conf.set("hbase.zookeeper.property.clientPort", "2191");  
Job job = new Job(conf, "WordCountHbaseReader");  
TableMapReduceUtil.initTableMapperJob(tablename,scan,WordCountHbaseReaderMapper.class, Text.class, Text.class, job);  
TableMapReduceUtil.initTableReducerJob(tablename, WordCountHbaseReducer.class, job);  


HBase从hdfs导入数据
http://www.cnblogs.com/dongdone/p/5689370.html
job.setOutputFormatClass(TableOutputFormat.class);
context.write(NullWritable.get(),put);

