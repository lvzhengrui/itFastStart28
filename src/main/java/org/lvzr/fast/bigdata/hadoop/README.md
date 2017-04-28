

###window
set HADOOP_HOME=E:\开源项目\bigdata\hadoop-2.7.3
set Path=%HADOOP_HOME%\bin;%HADOOP_HOME%\sbin;
echo %HADOOP_HOME%

hadoop-common-2.7.1-bin-master拷贝到%HADOOP_HOME%\bin目录
hadoop.dll、winutils.exe、libwinutils.lib放到c:/windows/System32


#JAVA API执行必须配置hosts文件
C:/Windows/System32/drivers/etc/hosts文件加上：
127.0.0.1 jerry2016
127.0.0.1 localhost



###格式化namenode
bin/hdfs namenode -format

###或者
sbin>start-all.sh或start-all.cmd
sbin>stop-all.sh

sbin>hadoop-daemon.sh start namenode
sbin>hadoop-daemon.sh start datanode
sbin>yarn-daemon.sh start resourcemanager
sbin>yarn-daemon.sh start nodemanager

###查看进程
jps

###fs文件操作
bin>hadoop fs -mkdir /in
bin>hadoop fs -put E:\开源项目\bigdata\1901 /in
bin>hadoop fs -ls /in
bin>hadoop fs -cat /out/data/part-r-00000
bin>hadoop fs -rmr /out/data/


###执行jar包
bin>hadoop fs -mkdir /out
bin>hadoop jar E:/开源项目/bigdata/maxtempatur.jar /in/1901 /out/data


###前台页面
查看hdfs
http://127.0.0.1:50070

查看应用程
http://127.0.0.1:8088


###查看日志
http://127.0.0.1:8088/cluster/app/application_1493001095325_0004
yarn logs -applicationId application_1493001095325_0004


###ssh免密登录



-------------------------------------------------------------------------
###hadoop能用到的系统端口
http://blog.csdn.net/wulantian/article/details/46341043
Daemon		缺省端口				配置参数
HDFS		Namenode				50070	dfs.http.address
			Datanodes				50075	dfs.datanode.http.address
			Secondarynamenode		50090	dfs.secondary.http.address
			Backup/Checkpoint node*	50105	dfs.backup.http.address

MR			Jobracker				50030	mapred.job.tracker.http.address
			Tasktrackers			50060	mapred.task.tracker.http.address
			
HBase		HMaster					60010	hbase.master.info.port
			HRegionServer			60030	hbase.regionserver.info.port

8088		Yarn任务监控端口
8080		Spark监控UI端口
4040		Spark任务UI端口


-------------------------------------------------------------------------
###测试眼里的Hadoop系列 之Terasort
http://www.51testing.com/html/15/n-804315.html

IdentityMapper和IdentityReducer对它们的输入不做任何处理，将输入k，v直接输出；也就是说是完全是为了走框架的流程而空跑。

MapReduce过程的理解简要的整理一下：
　　● 一般情况下，作业会需要指定input目录和output目录
　　● 作业的Mapper根据设置的InputFormat来从input目录读取输入数据，分成多个splits； 每一个split交给一个mapper处理
　　● mapper的输出会按照partions分组，每一个partion对应着一个reducer的输入； 在每个partion内，会有一个按key排序的过程，
		也就是说，每一个partion内的数据是有序的。
　　● 当处理完combiner和压缩后（如果有设置），map的输出会写到硬盘上。map结束后，所在的TT会在下一个心跳通知到JT。
　　● 每一个reducer查询JT了解到属于自己对应partition的mapoutput数据的对应的TT位置，然后去那copy到本地（HTTP协议）。
　　● Copy并保存到本地磁盘的过程同mapper端的输出保存过程非常相似。等到reducer获取到属于它的所有mapoutput数据后，它会保持
		之前mapper端的sort顺序，把这些mapoutput合并成较集中的中间文件（个数取决于数据大小和设置）。为了节省io的开销，merge会保证
		最后一轮是满负荷合并；并且，merge的最后一轮输出会直接在内存输入给reducer。
　　● reducer的输出按照OutputFormat来保存到output目录。


-------------------------------------------------------------------------
###常见类或函数
IdentityReducer
IdentityMapper
InputFormat
combiner
HashPartitioner
TotalOrderPartitioner
OutputFormat
JobConf
JobClient
































