




###一个不错的shell 脚本教程 入门级
http://m.jb51.net/article/28514.htm?from=singlemessage&isappinstalled=1


###Linux入门教程_linux电子书 - 跟阿铭学linux(第2版)
http://www.apelearn.com/study_v2/

###Linux入门教程_linux电子书 - 跟阿铭学linux(第2版)
第13章 学习 shell脚本之前的基础知识
http://www.apelearn.com/study_v2/chapter13.html



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
chmod +x filename 
#对变量赋值： 
a="hello world" 
# 现在打印变量a的内容： 
echo "A is:" 
echo $a 

num=2
echo "this is the ${num}nd" 



1)Unix 命令:
　　echo "some text": 将文字内容打印在屏幕上 
　　ls: 文件列表 
　　wc –l filewc -w filewc -c file: 计算文件行数计算文件中的单词数计算文件中的字符数 
　　cp sourcefile destfile: 文件拷贝 
　　mv oldname newname : 重命名文件或移动文件 
　　rm file: 删除文件 
　　grep 'pattern' file: 在文件内搜索字符串比如：grep 'searchstring' file.txt 
　　cut -b colnum file: 指定欲显示的文件内容范围，并将它们输出到标准输出设备比如：输出每行第5个到第9个字符cut -b5-9 file.txt千万不要和cat命令混淆，
		这是两个完全不同的命令 
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
　　sed: Sed是一个基本的查找替换程序。可以从标准输入（比如命令管道）读入文本，并将结果输出到标准输出（屏幕）。
		该命令采用正则表达式（见参考）进行搜索。不要和shell中的通配符相混淆。比如：将linuxfocus 替换为 LinuxFocus ：
		cat text.file | sed 's/linuxfocus/LinuxFocus/' > newtext.file 
　　awk: awk 用来从文本文件中提取字段。缺省地，字段分割符是空格，可以使用-F指定其他分割符。cat file.txt | awk -F, '{print $1 "," $3 }'这里我们使用，
		作为字段分割符，同时打印第一个和第三个字段。如果该文件内容如下： Adam Bor, 34, IndiaKerry Miller, 22, USA命令输出结果为：
		A dam Bor, IndiaKerry Miller, USA 

2) 概念: 管道, 重定向和 backtick 
　　这些不是系统命令，但是他们真的很重要。 
　　管道 (|) 将一个命令的输出作为另外一个命令的输入。 
	grep "hello" file.txt | wc -l 在file.txt中搜索包含有”hello”的行并计算其行数。 
　　在这里grep命令的输出作为wc命令的输入。当然您可以使用多个命令。 
　　重定向：将命令的结果输出到文件，而不是标准输出（屏幕）。 
　　> 写入文件并覆盖旧文件 
　　>> 加到文件的尾部，保留旧文件内容。 
    使用反短斜线可以将一个命令的输出作为另外一个命令的一个命令行参数。  tar -zcvf lastmod.tar.gz `find . -mtime -1 -type f -print` 
    
3) 流程控制 
if ....; then 
　 .... 
elif ....; then 
　 .... 
else 
　 .... 
fi 

[ -f "somefile" ] ：判断是否是一个文件 
[ -x "/bin/ls" ] ：判断/bin/ls是否存在并有可执行权限 
[ -n "$var" ] ：判断$var变量是否有值 
[ "$a" = "$b" ] ：判断$a和$b是否相等 

case ... in 
...) do something here ;; 
esac 

while ...; do 
.... 
done 

for var in ....; do 
　.... 
done 

echo *.jpg 

引号 (单引号和双引号) 将防止这种通配符扩展： 
echo "*.jpg" 
echo '*.jpg' 
这将打印"*.jpg" 两次。 

最后，还有一种防止这种扩展的方法，那就是使用转义字符——反斜杆： 
echo \$SHELL 

-------------------------------------------------------------------------------
###学习linux前准备
.bash_history
>!! #表示执行上一条指令
tab键补全，连续按两次tab键，系统则会把所有的指令或者文件名都列出来
alias aming='pwd'
unalias aming
你可以使它暂停（按Ctrl+z），然后使用fg命令恢复它，利用bg命令使他到后台运行，你也可以使它终止（按Ctrl+c）。
echo $PATH #变量
env #环境变量
set #env命令显示的变量只是环境变量，系统预设的变量其实还有很多，你可以使用set命令把系统预设的全部变量都显示出来。
export #export其实就是声明一下这个变量的意思，让该shell的子shell也知道变量abc的值是123.如果export后面不加任何变量名，则它会声明所有的变量。

/etc/profile ：这个文件预设了几个重要的变量，例如PATH, USER, LOGNAME, MAIL, INPUTRC, HOSTNAME, HISTSIZE, umask等等。
/etc/bashrc ：这个文件主要预设umask以及PS1
.bash_profile ：定义了用户的个人化路径与环境变量的文件名称。每个用户都可使用该文件输入专用于自己使用的shell信息,当用户登录时,该文件仅仅执行一次。
.bashrc ：该文件包含专用于你的shell的bash信息,当登录时以及每次打开新的shell时,该该文件被读取。例如你可以将用户自定义的alias或者自定义变量写到这个文件中。
.bash_history ：记录命令历史用的。
.bash_logout ：当退出shell时，会执行该文件。可以把一些清理的工作放到这个文件中。

cut 用来截取某一个字段

sort 用做排序

wc 用于统计文档的行数、字符数、词数，常用的选项为：
-l ：统计行数
-m ：统计字符数
-w ：统计词数

uniq去重复的行，阿铭最常用的选项只有一个：
-c ：统计重复的行数，并把行数写在前面

echo "aaaa" |tee testb.txt #后跟文件名，类似与重定向 “>”, 但是比重定向多了一个功能，在把文件写入后面所跟的文件中的同时，还显示在屏幕上。

head -n2 /etc/passwd |tr '[a-z]' '[A-Z]' #tr字符替换

split
切割文档，常用选项：
-b ：依据大小来分割文档，单位为byte
-l ：依据行数来分割文档
split -l10 passwd 
wc -l *



--------------------------------------------------------------------------------
###vim使用
下面阿铭给你留一个小作业，希望你能认真完成！
请把/etc/init.d/iptables 复制到/root/目录下，并重命名为test.txt
用vim打开test.txt并设置行号
分别向下、向右、向左、向右移动5个字符
分别向下、向上翻两页
把光标移动到第49行
让光标移动到行末，再移动到行首
移动到test.txt文件的最后一行
移动到文件的首行
搜索文件中出现的 iptables 并数一下一共出现多少个
把从第一行到第三行出现的iptables 替换成iptable
还原上一步操作
把整个文件中所有的iptables替换成iptable
把光标移动到25行，删除字符 “$”
还原上一步操作
删除第50行
还原上一步操作
删除从37行到42行的所有内容
还原上一步操作
复制48行并粘贴到52行下面
还原上一步操作（按两次u）
复制从37行到42行的内容并粘贴到44行上面
还原上一步操作（按两次u）
把37行到42行的内容移动到19行下面
还原上一步操作（按两次u）
光标移动到首行，把/bin/sh 改成 /bin/bash
在第一行下面插入新的一行，并输入”# Hello!”
保存文档并退出






