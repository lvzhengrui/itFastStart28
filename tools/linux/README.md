




###一个不错的shell 脚本教程 入门级
第13章 学习 shell脚本之前的基础知识
http://m.jb51.net/article/28514.htm?from=singlemessage&isappinstalled=1

###Linux入门教程_linux电子书 - 跟阿铭学linux(第2版)
http://m.jb51.net/article/28514.htm?from=singlemessage&isappinstalled=1



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


---------------------------------------------------------------------------
###常用命令语法及功能 
　　echo "some text": 将文字内容打印在屏幕上 
　　ls: 文件列表 
　　wc –l filewc -w filewc -c file: 计算文件行数计算文件中的单词数计算文件中的字符数 
　　cp sourcefile destfile: 文件拷贝 
　　mv oldname newname : 重命名文件或移动文件 
　　rm file: 删除文件 
　　grep 'pattern' file: 在文件内搜索字符串比如：grep 'searchstring' file.txt 
　　cut -b colnum file: 指定欲显示的文件内容范围，并将它们输出到标准输出设备比如：输出每行第5个到第9个字符cut -b5-9 file.txt千万不要和cat命令混淆，这是两个完全不同的命令 
　　cat file.txt: 输出文件内容到标准输出设备（屏幕）上 
　　file somefile: 得到文件类型 
　　read var: 提示用户输入，并将输入赋值给变量 
　　sort file.txt: 对file.txt文件中的行进行排序 
　　uniq: 删除文本文件中出现的行列比如： sort file.txt | uniq 
　　expr: 进行数学运算Example: add 2 and 3expr 2 "+" 3 
　　find: 搜索文件比如：根据文件名搜索find . -name filename -print 
　　tee: 将数据输出到标准输出设备(屏幕) 和文件比如：somecommand | tee outfile 
　　basename file: 返回不包含路径的文件名比如： basename /bin/tux将返回 tux 
　　dirname file: 返回文件所在路径比如：dirname /bin/tux将返回 /bin 
　　head file: 打印文本文件开头几行 
　　tail file : 打印文本文件末尾几行 
　　sed: Sed是一个基本的查找替换程序。可以从标准输入（比如命令管道）读入文本，并将结果输出到标准输出（屏幕）。该命令采用正则表达式（见参考）进行搜索。不要和shell中的通配符相混淆。比如：将linuxfocus 替换为 LinuxFocus ：cat text.file | sed 's/linuxfocus/LinuxFocus/' > newtext.file 
　　awk: awk 用来从文本文件中提取字段。缺省地，字段分割符是空格，可以使用-F指定其他分割符。cat file.txt | awk -F, '{print $1 "," $3 }'这里我们使用，作为字段分割符，同时打印第一个和第三个字段。如果该文件内容如下： Adam Bor, 34, IndiaKerry Miller, 22, USA命令输出结果为：Adam Bor, IndiaKerry Miller, USA 
2) 概念: 管道, 重定向和 backtick 
　　这些不是系统命令，但是他们真的很重要。 
　　管道 (|) 将一个命令的输出作为另外一个命令的输入。 
grep "hello" file.txt | wc -l 
　　在file.txt中搜索包含有”hello”的行并计算其行数。 
　　在这里grep命令的输出作为wc命令的输入。当然您可以使用多个命令。 
　　重定向：将命令的结果输出到文件，而不是标准输出（屏幕）。 
　　> 写入文件并覆盖旧文件 
　　>> 加到文件的尾部，保留旧文件内容。 







