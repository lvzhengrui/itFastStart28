

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





