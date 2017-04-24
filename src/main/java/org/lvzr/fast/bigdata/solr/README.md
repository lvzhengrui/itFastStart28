




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







--------------------------------------------------------------------------
solr在java中的使用
http://blog.csdn.net/u012385190/article/details/53115546


学习solr的基础知识：http://blog.csdn.net/u012385190/article/details/51682380 
参考文档：http://www.doc88.com/p-6763747939865.html

SolrJ是操作Solr的Java客户端，它提供了增加、修改、删除、查询Solr索引的JAVA接口。SolrJ针对 Solr提供了Rest 的HTTP接口进行了封装， 
SolrJ底层是通过使用httpClient中的方法来完成Solr的操作。


