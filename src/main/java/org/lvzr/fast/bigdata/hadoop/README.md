
###window
set HADOOP_HOME=E:\��Դ��Ŀ\bigdata\hadoop-2.7.3
set Path=%HADOOP_HOME%\bin;%HADOOP_HOME%\sbin;
echo %HADOOP_HOME%

hadoop-common-2.7.1-bin-master������%HADOOP_HOME%\binĿ¼
hadoop.dll��winutils.exe��libwinutils.lib�ŵ�c:/windows/System32


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















