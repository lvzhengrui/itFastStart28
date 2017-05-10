




###查看帮助
bin/solr -help     
        可以看到solr有哪些子命令，如 start, stop, restart, status, healthcheck, create, create_core, create_collection, delete, version
        
###启动start
bin/solr start  -help    查看start帮助
bin/solr start        启动单机版
bin/solr start -f           前台启动
bin/solr start -p 8984        指定端口启动
bin/solr start -cloud        启动分布式版本
bin/solr start -e cloud -noprompt         -e表示要启动一个现有的例子，例子名称是cloud，cloud这个例子是以SolrCloud方式启动的
bin/solr restart          重启项目



###create
如果是单机版要创建core，如果是分布式的要创建collection

bin/solr create -help     查看create帮助
bin/solr create -c abc

        abc是core或collection的名字，取决于solr是单机版还是cloud版本；刷新http://localhost:8983/solr ，可以看到core selector中多了一个abc
        abc目录的位置创建在solr.solr.home（默认是solr的server/solr目录）目录下


###post提交数据生成索引
bin/post -c abc docs/
        向名为abc的core或collection提交数据，数据源在docs/目录中

###删除
bin/solr delete -c abc     删除一个core或collection

###删除索引
bin/post -c abc  -d "<delete><id>/home/matthewi/software/solr-5.4.1/docs/solr-morphlines-core/allclasses-noframe.html</id></delete>"
重新执行上面的搜索可以看到搜索结果的数量少了一条：numFound列

bin/post -c abc -d "<delete><query>*:*</query></delete>"
删除所有数据

###停止solr
bin/solr stop -all

###状态
bin/solr status


-------------------------------------------------------------------------
###Elasticsearch与Solr的比较*
http://blog.csdn.net/xvshu/article/details/50749809
当单纯的对已有数据进行搜索时，Solr更快。
当实时建立索引时, Solr会产生io阻塞，查询性能较差, Elasticsearch具有明显的优势。
***随着数据量的增加，Solr的搜索效率会变得更低，而Elasticsearch却没有明显的变化。**
综上所述，Solr的架构不适合实时搜索的应用。

二者安装都很简单；
Solr 利用 Zookeeper 进行分布式管理，而 Elasticsearch 自身带有分布式协调管理功能;
Solr 支持更多格式的数据，而 Elasticsearch 仅支持json文件格式；
Solr 官方提供的功能更多，而 Elasticsearch 本身更注重于核心功能，高级功能多有第三方插件提供；
Solr 在传统的搜索应用中表现好于 Elasticsearch，但在处理实时搜索应用时效率明显低于 Elasticsearch。
Solr 是传统搜索应用的有力解决方案，但 Elasticsearch 更适用于新兴的实时搜索应用。


###Solr的优缺点
优点
	Solr有一个更大、更成熟的用户、开发和贡献者社区。
	支持添加多种格式的索引，如：HTML、PDF、微软 Office 系列软件格式以及 JSON、XML、CSV 等纯文本格式。
	Solr比较成熟、稳定。
	不考虑建索引的同时进行搜索，速度更快。
缺点
	**建立索引时，搜索效率下降，实时索引搜索效率不高。**


###Elasticsearch的优缺点**:
优点
	Elasticsearch是分布式的。不需要其他组件，分发是实时的，被叫做”Push replication”。
	Elasticsearch 完全支持 Apache Lucene 的接近实时的搜索。
	处理多租户（multitenancy）不需要特殊配置，而Solr则需要更多的高级设置。
	Elasticsearch 采用 Gateway 的概念，使得完备份更加简单。
	各节点组成对等的网络结构，某些节点出现故障时会自动分配其他节点代替其进行工作。
缺点
	只有一名开发者（当前Elasticsearch GitHub组织已经不只如此，已经有了相当活跃的维护者）
	还不够自动（不适合当前新的Index Warmup API）




--------------------------------------------------------------------------
solr在java中的使用
http://blog.csdn.net/u012385190/article/details/53115546


学习solr的基础知识：http://blog.csdn.net/u012385190/article/details/51682380 
参考文档：http://www.doc88.com/p-6763747939865.html

SolrJ是操作Solr的Java客户端，它提供了增加、修改、删除、查询Solr索引的JAVA接口。SolrJ针对 Solr提供了Rest 的HTTP接口进行了封装， 
SolrJ底层是通过使用httpClient中的方法来完成Solr的操作。


