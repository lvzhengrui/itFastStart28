
###window
set HADOOP_HOME=E:\��Դ��Ŀ\bigdata\hadoop-2.7.3
set Path=%HADOOP_HOME%\bin;%HADOOP_HOME%\sbin;

echo %HADOOP_HOME%
winutils.exe,libwinutils.lib������%HADOOP_HOME%\binĿ¼
hadoop.dll�ŵ�c:/windows/System32


###��ʽ��namenode
bin/hdfs namenode -format

###����
sbin/start-all.sh
sbin/stop-all.sh

sbin/hadoop-daemon.sh start namenode
sbin/hadoop-daemon.sh start datanode
sbin/yarn-daemon.sh start resourcemanager
sbin/yarn-daemon.sh start nodemanager

###�鿴����
jps

###fs�ļ�����
bin/hadoop fs -put input/ /in
bin/hadoop fs -ls /in


###ǰ̨ҳ��
http://127.0.0.1:50070


