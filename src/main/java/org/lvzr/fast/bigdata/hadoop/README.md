
###window
set HADOOP_HOME=E:\开源项目\bigdata\hadoop-2.7.3
set Path=%HADOOP_HOME%\bin;%HADOOP_HOME%\sbin;

echo %HADOOP_HOME%
hadoop-common-2.7.1-bin-master拷贝到%HADOOP_HOME%\bin目录
hadoop.dll、winutils.exe、libwinutils.lib放到c:/windows/System32


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
bin>hadoop fs -mkdir
bin>hadoop fs -put E:\开源项目\bigdata\1901 /in
bin>hadoop fs -ls /in

###前台页面
http://127.0.0.1:50070


###ssh免密登录



