###常用命令
sudo ln -s 源文件 目标文件 

head -2 Finance_inequality_and_the_poor_data_6005.csv

scep localfile root@ip:remotefile


case "`uname`" in
    CYGWIN*)    DT_PATH_SEP=";"  ;;
    *)          DT_PATH_SEP=":" ;;
esac

DT_CLASSPATH=

for i in $DT_HOME/lib/*.jar
do
    DT_CLASSPATH="$i$DT_PATH_SEP$DT_CLASSPATH"
done

$JAVA_HOME/bin/java -ea -classpath $DT_CLASSPATH $DEBUG_OPTIONS -Xms256m -Xmx1024m -DDT_HOME=$DT_HOME com.icsshs.datatransfer.DtServer $*




