

###neo4j简单学习
http://agapple.iteye.com/blog/1128400

http://blog.csdn.net/gtuu0123/article/details/6384375
http://www.iteye.com/topic/978371
https://www.ibm.com/developerworks/cn/java/j-lo-neo4j/

###Neo4j学习笔记九【Spring Data Neo4j】
http://blog.csdn.net/zoubf/article/details/54895580

###如何将大规模数据导入Neo4j
http://blog.csdn.net/xingxiupaioxue/article/details/71747284


针对图中的一些基本概念： 
node : 节点
relationships : 关系，也就是图中的边，注意是有向边
properties : 属性，针对node/relationship都可以设置property
Traversal :  图遍历工具
Indexes :  索引

node(节点)
	每个节点可以和多个节点之间建立多个关系(relationship)
	单个节点可以设置多个(Key,Value)的properties属性的键值对

relationships(关系)
	每个关系都会包含一个startNode和endNode
	每个关系可以设置多个(Key,Value)的properties属性的键值对
	可以为关系定义对应的关系类型(RelationshipType)
	*  DynamicRelationshipType 动态关系类型
	*  XXXRelationshipType 静态关系类型(实现了RelationshipType接口)

Order : 对应的图的遍历算法
	DEPTH_FIRST :  深度优先搜索，就是找到第一个节点，递归的一直往下找，直到找不到合适的节点后，才进行回溯
	BREADTH_FIRST :  广度优先搜索

Direction ：对应图中edge的方向
	OUTGOING : 出边
	INCOMING : 入边
	BOTH : 顾明思议

StopEvaluator : 定义图搜索的停止条件，默认有两个
	DEPTH_ONE :  深度超过1后停止
	END_OF_GRAPH :  无合适结果和停止

ReturnableEvaluator : 结果处理器，可以设置对应的返回结果，默认有：
	ALL_BUT_START_NODE :  排除初始节点
	ALL : 返回所有节点

TraversalPosition : 对应搜索过程中的node节点信息，包括：
	上一个节点信息
	上一个进入的Relationship信息
	搜索深度
	目前为止满足条件的节点数





