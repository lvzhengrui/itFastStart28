




###һ�������shell �ű��̳� ���ż�
http://m.jb51.net/article/28514.htm?from=singlemessage&isappinstalled=1


###Linux���Ž̳�_linux������ - ������ѧlinux(��2��)
http://www.apelearn.com/study_v2/

###Linux���Ž̳�_linux������ - ������ѧlinux(��2��)
��13�� ѧϰ shell�ű�֮ǰ�Ļ���֪ʶ
http://www.apelearn.com/study_v2/chapter13.html



###��������
sudo ln -s Դ�ļ� Ŀ���ļ� 

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
###���������﷨������ 
chmod +x filename 
#�Ա�����ֵ�� 
a="hello world" 
# ���ڴ�ӡ����a�����ݣ� 
echo "A is:" 
echo $a 

num=2
echo "this is the ${num}nd" 



1)Unix ����:
����echo "some text": ���������ݴ�ӡ����Ļ�� 
����ls: �ļ��б� 
����wc �Cl filewc -w filewc -c file: �����ļ����������ļ��еĵ����������ļ��е��ַ��� 
����cp sourcefile destfile: �ļ����� 
����mv oldname newname : �������ļ����ƶ��ļ� 
����rm file: ɾ���ļ� 
����grep 'pattern' file: ���ļ��������ַ������磺grep 'searchstring' file.txt 
����cut -b colnum file: ָ������ʾ���ļ����ݷ�Χ�����������������׼����豸���磺���ÿ�е�5������9���ַ�cut -b5-9 file.txtǧ��Ҫ��cat���������
		����������ȫ��ͬ������ 
����cat file.txt: ����ļ����ݵ���׼����豸����Ļ���� 
����file somefile: �õ��ļ����� 
����read var: ��ʾ�û����룬�������븳ֵ������ 
����sort file.txt: ��file.txt�ļ��е��н������� 
����uniq: ɾ���ı��ļ��г��ֵ����б��磺 sort file.txt | uniq 
����expr: ������ѧ����Example: add 2 and 3expr 2 "+" 3 
����find: �����ļ����磺�����ļ�������find . -name filename -print 
����tee: �������������׼����豸(��Ļ) ���ļ����磺somecommand | tee outfile 
����basename file: ���ز�����·�����ļ������磺 basename /bin/tux������ tux 
����dirname file: �����ļ�����·�����磺dirname /bin/tux������ /bin 
����head file: ��ӡ�ı��ļ���ͷ���� 
����tail file : ��ӡ�ı��ļ�ĩβ���� 
����sed: Sed��һ�������Ĳ����滻���򡣿��Դӱ�׼���루��������ܵ��������ı�����������������׼�������Ļ����
		���������������ʽ�����ο���������������Ҫ��shell�е�ͨ�������������磺��linuxfocus �滻Ϊ LinuxFocus ��
		cat text.file | sed 's/linuxfocus/LinuxFocus/' > newtext.file 
����awk: awk �������ı��ļ�����ȡ�ֶΡ�ȱʡ�أ��ֶηָ���ǿո񣬿���ʹ��-Fָ�������ָ����cat file.txt | awk -F, '{print $1 "," $3 }'��������ʹ�ã�
		��Ϊ�ֶηָ����ͬʱ��ӡ��һ���͵������ֶΡ�������ļ��������£� Adam Bor, 34, IndiaKerry Miller, 22, USA����������Ϊ��
		A dam Bor, IndiaKerry Miller, USA 

2) ����: �ܵ�, �ض���� backtick 
������Щ����ϵͳ�������������ĺ���Ҫ�� 
�����ܵ� (|) ��һ������������Ϊ����һ����������롣 
	grep "hello" file.txt | wc -l ��file.txt�����������С�hello�����в������������� 
����������grep����������Ϊwc��������롣��Ȼ������ʹ�ö����� 
�����ض��򣺽�����Ľ��������ļ��������Ǳ�׼�������Ļ���� 
����> д���ļ������Ǿ��ļ� 
����>> �ӵ��ļ���β�����������ļ����ݡ� 
    ʹ�÷���б�߿��Խ�һ������������Ϊ����һ�������һ�������в�����  tar -zcvf lastmod.tar.gz `find . -mtime -1 -type f -print` 
    
3) ���̿��� 
if ....; then 
�� .... 
elif ....; then 
�� .... 
else 
�� .... 
fi 

[ -f "somefile" ] ���ж��Ƿ���һ���ļ� 
[ -x "/bin/ls" ] ���ж�/bin/ls�Ƿ���ڲ��п�ִ��Ȩ�� 
[ -n "$var" ] ���ж�$var�����Ƿ���ֵ 
[ "$a" = "$b" ] ���ж�$a��$b�Ƿ���� 

case ... in 
...) do something here ;; 
esac 

while ...; do 
.... 
done 

for var in ....; do 
��.... 
done 

echo *.jpg 

���� (�����ź�˫����) ����ֹ����ͨ�����չ�� 
echo "*.jpg" 
echo '*.jpg' 
�⽫��ӡ"*.jpg" ���Ρ� 

��󣬻���һ�ַ�ֹ������չ�ķ������Ǿ���ʹ��ת���ַ�������б�ˣ� 
echo \$SHELL 

-------------------------------------------------------------------------------
###ѧϰlinuxǰ׼��
.bash_history
>!! #��ʾִ����һ��ָ��
tab����ȫ������������tab����ϵͳ�������е�ָ������ļ������г���
alias aming='pwd'
unalias aming
�����ʹ����ͣ����Ctrl+z����Ȼ��ʹ��fg����ָ���������bg����ʹ������̨���У���Ҳ����ʹ����ֹ����Ctrl+c����
echo $PATH #����
env #��������
set #env������ʾ�ı���ֻ�ǻ���������ϵͳԤ��ı�����ʵ���кܶ࣬�����ʹ��set�����ϵͳԤ���ȫ����������ʾ������
export #export��ʵ��������һ�������������˼���ø�shell����shellҲ֪������abc��ֵ��123.���export���治���κα��������������������еı�����

/etc/profile ������ļ�Ԥ���˼�����Ҫ�ı���������PATH, USER, LOGNAME, MAIL, INPUTRC, HOSTNAME, HISTSIZE, umask�ȵȡ�
/etc/bashrc ������ļ���ҪԤ��umask�Լ�PS1
.bash_profile ���������û��ĸ��˻�·���뻷���������ļ����ơ�ÿ���û�����ʹ�ø��ļ�����ר�����Լ�ʹ�õ�shell��Ϣ,���û���¼ʱ,���ļ�����ִ��һ�Ρ�
.bashrc �����ļ�����ר�������shell��bash��Ϣ,����¼ʱ�Լ�ÿ�δ��µ�shellʱ,�ø��ļ�����ȡ����������Խ��û��Զ����alias�����Զ������д������ļ��С�
.bash_history ����¼������ʷ�õġ�
.bash_logout �����˳�shellʱ����ִ�и��ļ������԰�һЩ����Ĺ����ŵ�����ļ��С�

cut ������ȡĳһ���ֶ�

sort ��������

wc ����ͳ���ĵ����������ַ��������������õ�ѡ��Ϊ��
-l ��ͳ������
-m ��ͳ���ַ���
-w ��ͳ�ƴ���

uniqȥ�ظ����У�������õ�ѡ��ֻ��һ����
-c ��ͳ���ظ�����������������д��ǰ��

echo "aaaa" |tee testb.txt #����ļ������������ض��� ��>��, ���Ǳ��ض������һ�����ܣ��ڰ��ļ�д������������ļ��е�ͬʱ������ʾ����Ļ�ϡ�

head -n2 /etc/passwd |tr '[a-z]' '[A-Z]' #tr�ַ��滻

split
�и��ĵ�������ѡ�
-b �����ݴ�С���ָ��ĵ�����λΪbyte
-l �������������ָ��ĵ�
split -l10 passwd 
wc -l *



--------------------------------------------------------------------------------
###vimʹ��
���氢��������һ��С��ҵ��ϣ������������ɣ�
���/etc/init.d/iptables ���Ƶ�/root/Ŀ¼�£���������Ϊtest.txt
��vim��test.txt�������к�
�ֱ����¡����ҡ����������ƶ�5���ַ�
�ֱ����¡����Ϸ���ҳ
�ѹ���ƶ�����49��
�ù���ƶ�����ĩ�����ƶ�������
�ƶ���test.txt�ļ������һ��
�ƶ����ļ�������
�����ļ��г��ֵ� iptables ����һ��һ�����ֶ��ٸ�
�Ѵӵ�һ�е������г��ֵ�iptables �滻��iptable
��ԭ��һ������
�������ļ������е�iptables�滻��iptable
�ѹ���ƶ���25�У�ɾ���ַ� ��$��
��ԭ��һ������
ɾ����50��
��ԭ��һ������
ɾ����37�е�42�е���������
��ԭ��һ������
����48�в�ճ����52������
��ԭ��һ��������������u��
���ƴ�37�е�42�е����ݲ�ճ����44������
��ԭ��һ��������������u��
��37�е�42�е������ƶ���19������
��ԭ��һ��������������u��
����ƶ������У���/bin/sh �ĳ� /bin/bash
�ڵ�һ����������µ�һ�У������롱# Hello!��
�����ĵ����˳�






