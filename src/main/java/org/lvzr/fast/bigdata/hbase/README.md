




###����
HBASE_HOME=E:\��Դ��Ŀ\bigdata\hbase-1.3.1
Path=%HBASE_HOME%\bin
echo %HBASE_HOME%

###��������hosts
hbase.zookeeper.quorum����Ϊ�������jerry2016
C:/Windows/System32/drivers/etc/hosts�ļ�����һ�䣺
127.0.0.1 jerry2016



###��ͣ����
cd E:\��Դ��Ŀ\bigdata\hbase-1.3.1\bin
bin>start-hbase
bin>stop-hbase

����hbase���Զ���hadoop�д���hbase.rootdirĿ¼
bin>hadoop fs -ls /


###ǰ̨ҳ��
http://127.0.0.1:16010/

###����shell����
bin>hbase shell

�鿴��
bin>list

ɾ����
bin>disable 't1'
bin>drop 't1'

�鿴��ṹ
bin>describe 't1'

�鿴������
bin>scan 'hbase:meta'

�����������
bin>create 't1','f1','f2'

��������
bin>alter 't1','f3','f4'

��������
bin>put 't1','r1','f1:c1','value0'
bin>get 't1','r1'
bin>get 't1','r1','f1'
bin>delete 't1','rowkey001','f1:col1'
bin>deleteall 't1','rowkey001'
bin>truncate 't1'
bin> count 't1', {INTERVAL => 100, CACHE => 500}















































-----------------------------------------------------------------------------------------
Դ��Google��Bigtable���ģ�������2006��11�£�HBase��Google Bigtable��¡��
HBase��һ����Խṹ�����ݵĿ��������߿ɿ��������ܡ��ֲ�ʽ�������еĶ�̬ģʽ���ݿ⡣
�ʹ�ͳ��ϵ���ݿⲻͬ��HBase������BigTable������ģ�ͣ���ǿ��ϡ������ӳ���Key/Value����
���У������йؼ��֡��йؼ��ֺ�ʱ������ɡ�HBase�ṩ�˶Դ��ģ���ݵ������ʵʱ��д���ʣ�ͬʱ��
HBase�б�������ݿ���ʹ��MapReduce�������������ݴ洢�Ͳ��м��������ؽ����һ��
����ģ�ͣ�Schema-->Table-->Column Family-->Column-->RowKey-->TimeStamp-->Value

------------------------------------------
###����HBase�ܹ�������һ��
http://www.blogjava.net/DLevin/archive/2015/08/22/426877.html
 
###hbase ѧϰ�ʼ�һ---��������
http://blog.csdn.net/zhouleilei/article/details/12653243


---------------------------------------------------
###Apache HBase 2015�귢չ�ع���δ��չ��
http://chuansong.me/n/2112995

�� HBase �У�Table �����򻮷�Ϊ Region������һ�����ݵĹ����ߣ�Region ���ַ��� RegionServer �Ͻ��й���
һ�� Region ֻ��һ�� RegionServer �����������ݴ洢�� HDFS �ϣ��ǿ����ж�������ġ�

Ҳ����˵�������� (Region) ֻ��һ���������ж��������

HBase ����ǰʵ��Hbase0.8�У���һ̨ RegionServer ������ʱ����Ҫ��ʮ�����������Ӳſ�����ɷ��ֺͻָ������������ʱ���ڣ�
��̨ RegionServer �ϵ� Region �ǲ����õġ���һ�� Region ������ʱ������Ҫһ��ʱ��ſ��Ա����� RegionServer �ӹܡ�

������Hbase1.0��ʵ���У�һ�� Region �����ж��������Region �����ݵĹ����ߣ���ʵ�����ݵĳ��󣩣��ֲ��ڶ�� RegionServer �ϡ�

 

 
------------------------------------------
###����HMaster�ڵ����ڣ�
����HRegionServer��ʵ���为�ؾ��⡣
����ͷ���HRegion��������HRegion splitʱ�����µ�HRegion����HRegionServer�˳�ʱǨ�����ڵ�HRegion������HRegionServer�ϡ�
ʵ��DDL������Data Definition Language��namespace��table����ɾ�ģ�column familiy����ɾ�ĵȣ���
����namespace��table��Ԫ���ݣ�ʵ�ʴ洢��HDFS�ϣ���
Ȩ�޿��ƣ�ACL����

###HRegionServer�ڵ����ڣ�
��ź͹�����HRegion��
��дHDFS������Table�е����ݡ�
Clientֱ��ͨ��HRegionServer��д���ݣ���HMaster�л�ȡԪ���ݣ��ҵ�RowKey���ڵ�HRegion/HRegionServer�󣩡�

###ZooKeeper��Ⱥ��Э��ϵͳ�����ڣ�
������� HBase��Ⱥ��Ԫ�����Լ���Ⱥ��״̬��Ϣ��
ʵ��HMaster���ӽڵ��failover��

HBase Clientͨ��RPC��ʽ��HMaster��HRegionServerͨ�ţ�һ��HRegionServer���Դ��1000��HRegion���ײ�Table���ݴ洢��HDFS�У�
��HRegion����������ݾ������������ڵ�DataNode��һ��ʵ�����ݵı��ػ������ݱ��ػ�����������ʵ�֣�������HRegion�ƶ�(����Split)ʱ��
��Ҫ����һ��Compact���ܼ����ص����ػ���


����ܹ�ͼ�Ƚ������ı����HMaster��NameNode��֧�ֶ���ȱ��ݣ�ʹ��ZooKeeper����Э����ZooKeeper�������ư����أ�
��һ������̨�������һ����Ⱥ���ڲ�ʹ��PAXOS�㷨֧����̨Server�е�һ̨崻���Ҳ��ʹ����̨�����ģ���ʱ�����֧��ͬ
ʱ��̨崻��������ڰ�����崻���Ȼ�����Ż��������ӣ���������Ҳ���½���RegionServer��DataNodeһ��������ͬ��Server��ʵ�����ݵı��ػ���

-------------------------------------
###HRegion
HBaseʹ��RowKey����ˮƽ�и�ɶ��HRegion��***��HMaster�ĽǶȣ�ÿ��HRegion����¼������StartKey��EndKey***
����һ��HRegion��StartKeyΪ�գ����һ��HRegion��EndKeyΪ�գ�������RowKey������ģ����Client����ͨ��HMaster���ٵĶ�λÿ��RowKey���ĸ�HRegion��
��***HRegion��HMaster���䵽��Ӧ��HRegionServer��***��Ȼ����HRegionServer����HRegion�������͹�����Client��ͨ�ţ�
�������ݵĶ�(ʹ��HDFS)��ÿ��HRegionServer����ͬʱ����1000�����ҵ�HRegion�����������ô���ģ�û�дӴ����п������ƣ�
�ѵ��ǳ��ھ��飿����1000���������������⣿���ش�������⣺�о����1000�������Ǵ�BigTable�����������ģ�5 Implementation�ڣ���
Each tablet server manages a set of tablets(typically we have somewhere between ten to a thousand tablets per tablet server)����


###HMaster
***HMasterû�е���������⣬�����������HMaster��ͨ��ZooKeeper��Master Election���Ʊ�֤ͬʱֻ��һ��HMaster����Active״̬***��
������HMaster�����ȱ���״̬��һ������»���������HMaster����Active��HMaster�ᶨ�ڵĺ�Active HMasterͨ���Ի�ȡ������״̬��
�Ӷ���֤����ʵʱ���µģ������������˶��HMaster����������Active HMaster�ĸ�����ǰ���Ѿ����ܹ���HMaster����Ҫ����HRegion�ķ����
����DDL(Data Definition Language����Table���½���ɾ�����޸ĵ�)��ʵ�ֵȣ�������Ҫ���������ְ��
Э��HRegionServer
	����ʱHRegion�ķ��䣬�Լ����ؾ�����޸�ʱHRegion�����·��䡣
	��ؼ�Ⱥ������HRegionServer��״̬(ͨ��Heartbeat�ͼ���ZooKeeper�е�״̬)��
Adminְ��
	������ɾ�����޸�Table�Ķ��塣


###ZooKeeper��Э����
ZooKeeperΪHBase��Ⱥ�ṩЭ��������***������HMaster��HRegionServer��״̬(available/alive��)�����һ�������崻�ʱ֪ͨ��HMaster***��
�Ӷ�HMaster����ʵ��HMaster֮���failover�����崻���HRegionServer�е�HRegion���ϵ��޸�(�����Ƿ����������HRegionServer)��
ZooKeeper��Ⱥ����ʹ��һ����Э��(PAXOSЭ��)��֤ÿ���ڵ�״̬��һ���ԡ�

--------------------------------------------
###�ͻ����ڵ�һ�η����û�Table������
��ZooKeeper(/hbase/meta-region-server)�л�ȡhbase:meta��λ�ã�HRegionServer��λ�ã��������λ����Ϣ��
��HRegionServer�в�ѯ�û�Table��Ӧ�����RowKey���ڵ�HRegionServer�������λ����Ϣ��
�Ӳ�ѯ��HRegionServer�ж�ȡRow��

---------------------------------------------
###HRegionServer���
HRegion��һ��Table�е�һ��Region��һ��HRegionServer�еı�һ��Table������һ������Region�����ǿ�����һ��
��ͬ��HRegionServer�ϣ�Ҳ���Էֲ��ڲ�ͬ��HRegionServer�ϣ�һ��HRegionServer�����ж��HRegion�����Ƿֱ�����
��ͬ��Table��****HRegion�ɶ��Store(HStore)���ɣ�ÿ��HStore��Ӧ��һ��Table�����HRegion�е�һ��Column Family****����
ÿ��Column Family����һ�����еĴ洢��Ԫ�������ý��������IO���Ե�Column�洢��һ��Column Family����ʵ�ָ�Ч��
ȡ(���ݾֲ���ԭ��������߻����������)��***HStore��HBase�д洢�ĺ��ģ���ʵ���˶�дHDFS���ܣ�һ��HStore��һ��MemStore ��0������StoreFile���***��
MemStore��һ��д����(In Memory Sorted Buffer)���������ݵ�д�����WAL��־д�󣬻� д��MemStore�У���MemStore��
��һ�����㷨������Flush���ز�HDFS�ļ���(HFile)��ͨ��ÿ��HRegion�е�ÿ�� Column Family��һ���Լ���MemStore��
HFile(StoreFile) ���ڴ洢HBase������(Cell/KeyValue)����HFile�е������ǰ�RowKey��Column Family��Column���򣬶���
ͬ��Cell(��������ֵ��һ��)����timestamp�������С�





































