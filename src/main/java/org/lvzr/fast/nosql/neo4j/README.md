

###neo4j��ѧϰ
http://agapple.iteye.com/blog/1128400

http://blog.csdn.net/gtuu0123/article/details/6384375
http://www.iteye.com/topic/978371
https://www.ibm.com/developerworks/cn/java/j-lo-neo4j/

###Neo4jѧϰ�ʼǾš�Spring Data Neo4j��
http://blog.csdn.net/zoubf/article/details/54895580

###��ν����ģ���ݵ���Neo4j
http://blog.csdn.net/xingxiupaioxue/article/details/71747284


���ͼ�е�һЩ������� 
node : �ڵ�
relationships : ��ϵ��Ҳ����ͼ�еıߣ�ע���������
properties : ���ԣ����node/relationship����������property
Traversal :  ͼ��������
Indexes :  ����

node(�ڵ�)
	ÿ���ڵ���ԺͶ���ڵ�֮�佨�������ϵ(relationship)
	�����ڵ�������ö��(Key,Value)��properties���Եļ�ֵ��

relationships(��ϵ)
	ÿ����ϵ�������һ��startNode��endNode
	ÿ����ϵ�������ö��(Key,Value)��properties���Եļ�ֵ��
	����Ϊ��ϵ�����Ӧ�Ĺ�ϵ����(RelationshipType)
	*  DynamicRelationshipType ��̬��ϵ����
	*  XXXRelationshipType ��̬��ϵ����(ʵ����RelationshipType�ӿ�)

Order : ��Ӧ��ͼ�ı����㷨
	DEPTH_FIRST :  ������������������ҵ���һ���ڵ㣬�ݹ��һֱ�����ң�ֱ���Ҳ������ʵĽڵ�󣬲Ž��л���
	BREADTH_FIRST :  �����������

Direction ����Ӧͼ��edge�ķ���
	OUTGOING : ����
	INCOMING : ���
	BOTH : ����˼��

StopEvaluator : ����ͼ������ֹͣ������Ĭ��������
	DEPTH_ONE :  ��ȳ���1��ֹͣ
	END_OF_GRAPH :  �޺��ʽ����ֹͣ

ReturnableEvaluator : ������������������ö�Ӧ�ķ��ؽ����Ĭ���У�
	ALL_BUT_START_NODE :  �ų���ʼ�ڵ�
	ALL : �������нڵ�

TraversalPosition : ��Ӧ���������е�node�ڵ���Ϣ��������
	��һ���ڵ���Ϣ
	��һ�������Relationship��Ϣ
	�������
	ĿǰΪֹ���������Ľڵ���





