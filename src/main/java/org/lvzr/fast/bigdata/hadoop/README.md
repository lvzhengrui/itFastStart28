

###window
set HADOOP_HOME=E:\��Դ��Ŀ\bigdata\hadoop-2.7.3
set Path=%HADOOP_HOME%\bin;%HADOOP_HOME%\sbin;
echo %HADOOP_HOME%

hadoop-common-2.7.1-bin-master������%HADOOP_HOME%\binĿ¼
hadoop.dll��winutils.exe��libwinutils.lib�ŵ�c:/windows/System32


#JAVA APIִ�б�������hosts�ļ�
C:/Windows/System32/drivers/etc/hosts�ļ����ϣ�
127.0.0.1 jerry2016
127.0.0.1 localhost



###��ʽ��namenode
bin/hdfs namenode -format

###����
sbin>start-all.sh��start-all.cmd
sbin>stop-all.sh

sbin>hadoop-daemon.sh start namenode
sbin>hadoop-daemon.sh start datanode
sbin>yarn-daemon.sh start resourcemanager
sbin>yarn-daemon.sh start nodemanager

###�鿴����
jps

###fs�ļ�����
bin>hadoop fs -mkdir /in
bin>hadoop fs -put E:\��Դ��Ŀ\bigdata\1901 /in
bin>hadoop fs -ls /in
bin>hadoop fs -cat /out/data/part-r-00000
bin>hadoop fs -rmr /out/data/


###ִ��jar��
bin>hadoop fs -mkdir /out
bin>hadoop jar E:/��Դ��Ŀ/bigdata/maxtempatur.jar /in/1901 /out/data


###ǰ̨ҳ��
�鿴hdfs
http://127.0.0.1:50070

�鿴Ӧ�ó�
http://127.0.0.1:8088


###�鿴��־
http://127.0.0.1:8088/cluster/app/application_1493001095325_0004
yarn logs -applicationId application_1493001095325_0004


###ssh���ܵ�¼



-------------------------------------------------------------------------
###hadoop���õ���ϵͳ�˿�
http://blog.csdn.net/wulantian/article/details/46341043
Daemon		ȱʡ�˿�				���ò���
HDFS		Namenode				50070	dfs.http.address
			Datanodes				50075	dfs.datanode.http.address
			Secondarynamenode		50090	dfs.secondary.http.address
			Backup/Checkpoint node*	50105	dfs.backup.http.address

MR			Jobracker				50030	mapred.job.tracker.http.address
			Tasktrackers			50060	mapred.task.tracker.http.address
			
HBase		HMaster					60010	hbase.master.info.port
			HRegionServer			60030	hbase.regionserver.info.port

8088		Yarn�����ض˿�
8080		Spark���UI�˿�
4040		Spark����UI�˿�





