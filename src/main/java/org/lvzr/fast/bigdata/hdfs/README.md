Դ����Google��GFS���ģ�������2003��10�£�HDFS��GFS��¡�档
��Hadoop��ϵ�����ݴ洢����Ļ���������һ���߶��ݴ��ϵͳ���ܼ���Ӧ��Ӳ�����ϣ������ڵͳɱ���ͨ��Ӳ�������С�HDFS�����ļ���һ����ģ�ͣ�
ͨ����ʽ���ݷ��ʣ��ṩ��������Ӧ�ó������ݷ��ʹ��ܣ��ʺϴ��д������ݼ���Ӧ�ó���

Client���з��ļ�������HDFS����NameNode��������ȡ�ļ�λ����Ϣ����DataNode��������ȡ��д�����ݡ�
NameNode��Master�ڵ㣬��hadoop1.X��ֻ��һ��������HDFS�����ƿռ�����ݿ�ӳ����Ϣ�����ø������ԣ�����ͻ�������
DataNode��Slave�ڵ㣬�洢ʵ�ʵ����ݣ��㱨�洢��Ϣ��NameNode��
Secondary NameNode������NameNode���ֵ��乤���������ںϲ�fsimage��fsedits�����͸�NameNode����������£��ɸ����ָ�NameNode��
��Secondary NameNode����NameNode���ȱ���


----------------------------------
hadoop�����ļ���⡢��װ����ز���
http://blog.csdn.net/lin_fs/article/details/7349497

hadoop���������ļ��Ĳ�������˵��(������)
http://blog.csdn.net/yangjl38/article/details/7583374
web�˿ڣ�RPC server�˿ڣ�http Server�˿�����?



---------------------------------

HDFS������ͨ�Ż���
http://blog.csdn.net/knowledgeaaa/article/details/17264291

Hadoop NameNodeԪ��������ļ�Ŀ¼���� �C ��������
https://www.iteblog.com/archives/967.html

Hadoop��NameNode�洢��Ԫ���ݼ�¼��NameNode����������
http://www.cnblogs.com/zhangcm/archive/2012/11/24/2787142.html

hadoop����֮һHDFSԪ���ݽ���
http://blog.csdn.net/kntao/article/details/7769199


 

--------------------------------------------
###hdfsԪ����
NameNode��NN��ָ���д洢��HDFS���ļ���Ԫ��Ϣ���Ӵ�ķ�����Է�Ϊ3�����������ļ�ϵͳ��Ŀ¼�����ļ�����blockid��ӳ���ϵ��blockid���ڵ�DN��Ϣ��
����ǰ���������ô���NN�еģ�image�ļ�������������DN����ʱ��NN�㱨���ɵģ������ܹ���NN�Ĵ洢�߼������Ҵ���Сimage�ļ��Ĵ�С��
 
###hadoop��Ԫ����fsimage��edits
http://blog.csdn.net/qa38113202/article/details/51690924

fsimage��edits�ļ����Ǿ������л��ģ���NameNode������ʱ�����Ὣ****fsimage�ļ��е����ݼ��ص��ڴ���****��֮����ִ��edits�ļ��еĸ��������
ʹ���ڴ��е�Ԫ���ݺ�ʵ�ʵ�ͬ���������ڴ��е�Ԫ����֧�ֿͻ��˵Ķ�������

NameNode����֮��HDFS�еĸ��²���������д��edits�ļ��У���Ϊ***fsimage�ļ�һ�㶼�ܴ�GB����ĺܳ�����***��������еĸ��²�������fsimage��
������ӣ������ᵼ��ϵͳ���е�ʮ�ֻ��������������edits�ļ�����д�Ͳ���������ÿ��ִ��д����֮��������ͻ��˷��ͳɹ�����֮ǰ��edits�ļ���
��Ҫͬ�����¡����һ���ļ��Ƚϴ�ʹ��д������Ҫ���̨�������в�����ֻ�е����е�д������ִ�����֮��д�����Ż᷵�سɹ��������ĺô����κ�
�Ĳ�����������Ϊ�����Ĺ��϶�����Ԫ���ݵĲ�ͬ����

fsimage����Hadoop�ļ�ϵͳ�е�����Ŀ¼���ļ�idnode�����л���Ϣ�������ļ���˵����������Ϣ���޸�ʱ�䡢����ʱ�䡢���С��***���һ���ļ�����Ϣ***�ȣ�
������Ŀ¼��˵����������Ϣ��Ҫ���޸�ʱ�䡢���ʿ���Ȩ�޵���Ϣ��***fsimage��������DataNode����Ϣ�����ǰ���DataNode�Ͽ��ӳ����Ϣ***������ŵ��ڴ�
�У���һ���µ�DataNode���뵽��Ⱥ�У�DataNode������NameNode�ṩ�����Ϣ����NameNode�ᶨ�ڵġ���ȡ�������Ϣ����ʹ��NameNodeӵ�����µĿ�
ӳ�䡣��Ϊfsimage����Hadoop�ļ�ϵͳ�е�����Ŀ¼���ļ�idnode�����л���Ϣ���������fsimage��ʧ�������ˣ���ô��ʹDataNode���п�����ݣ�
��������û���ļ������ӳ���ϵ������Ҳ�޷���DataNode�ϵ����ݣ�***���Զ��ڼ�ʱ�ı���fsimage��edits�ļ��ǳ���Ҫ***��

 
��ǰ������Ҳ�ᵽ���ļ�ϵͳ�ͻ���ִ�е�����д�������Ȼᱻ��¼��edits�ļ��У���ô�ö���֮��edits��ǳ��Ĵ�
��NameNode��������ʱ����Ҫִ��edits�ļ��еĸ����������ô�����ᵼ��NameNode������ʱ��ǳ���������ƪ��������
��̸����Hadoop 1.x�汾��Hadoop 2.x�汾����ô����edits�ļ���fsimage�ļ��ġ�

###Inode
���Կ���FSNamesystem����Ŀ¼�ṹ�Ĳ�������ͨ��FSDirectory������еġ���FSDirectory����һ����ʾϵͳĿ¼����rootDir��
rootDir��INodeDirectoryWithQuota���ͣ���ͱ���FSDirectory����ΪInode������Linux�е�inode����FSNamesystem֮���������
FSDirectory��װ��Inode�ṩ�˶����ѯ�Ľӿڡ�

Inode��һ�������࣬������������INodeDirectory��INodeFile������˼�壬INodeFile�������һ��������ļ�����INodeDirectory�������һ���ļ�Ŀ¼��
���ſ�һ��INodeDirectory��INodeFile֮���������INodeFile������Ҫ��һ������
protected BlockInfo blocks[] = null;      
����Ǵ���ÿ���ļ�����Ӧ��blockid������INodeDirectory������Ҫ�Ĳ�����

private List<INode> children;    
�����һ���ļ�Ŀ¼�е�Ŀ¼��ļ��ϣ�Ҳ����Ŀ¼����

��������֪����Ŀ¼����blockid�Ĵ洢�ṹ������������image�ļ���edits�ļ�ʱ���Ƿ��������Ľṹ������֯��


------------------------------


��Ӧ�ͻ����������active�ڵ㣬���ֻ��active�ڵ㱣�������µ�Ԫ���ݡ�Ԫ���ݷ�Ϊ�����֣�һ�����Ǹ�д���µ�Ԫ���ݣ�edits����
��һ�����Ǻϲ���ĽϾɵģ�fsimage����HA���ƽ��ͬ������ķ����ǽ�active�ڵ���д���editsԪ���ݷ���zookeeper��Ⱥ��
��zookeeper��Ⱥ��Ҫ������ʵ���������ݵķֲ�ʽͬ��������standby�ڵ���active�ڵ����������ֻ��Ҫ��zookeeper��Ⱥ��edits�ļ�
ͬ�����Լ���fsimage�оͿ��ԡ�

Hadoop���Ϊ�����Ⱥר��д�˸��ֲ�ʽӦ��qjournal������zookeeperʵ�֣���ʵ��qjournal�Ľڵ��Ϊjournalnode��
       
       
����NameNodeΪ������ͬ������ͨ��һ�����JournalNodes�Ķ������̽����໥ͨ�š���active״̬��NameNode�������ռ����κ��޸�ʱ��
���֪�󲿷ֵ�JournalNodes���̡�standby״̬��NameNode��������ȡJNs�еı����Ϣ������һֱ���edit log�ı仯���ѱ仯Ӧ�����Լ�
�������ռ䡣standby����ȷ���ڼ�Ⱥ����ʱ�������ռ�״̬�Ѿ���ȫͬ����

����HA��Ⱥ���ԣ�ȷ��ͬһʱ��ֻ��һ��NameNode����active״̬��������Ҫ�ġ���������NameNode������״̬�ͻ�������磬���ܶ�ʧ���ݣ���
�߲�������Ľ����Ϊ�˱�֤��㣬�����Ҫ����ʹ��ZooKeeper�ˡ�����HDFS��Ⱥ�е�����NameNode����ZooKeeper��ע�ᣬ��active״̬��
NameNode������ʱ��ZooKeeper�ܼ�⵽������������ͻ��Զ���standby״̬��NameNode�л�Ϊactive״̬��










