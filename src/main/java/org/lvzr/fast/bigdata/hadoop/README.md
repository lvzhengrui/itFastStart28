
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
bin>hadoop fs -mkdir
bin>hadoop fs -put E:\��Դ��Ŀ\bigdata\1901 /in
bin>hadoop fs -ls /in

###ǰ̨ҳ��
http://127.0.0.1:50070


###ssh���ܵ�¼



