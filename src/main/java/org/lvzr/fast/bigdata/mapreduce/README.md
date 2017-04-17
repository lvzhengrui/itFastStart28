源自于google的MapReduce论文，发表于2004年12月，Hadoop MapReduce是google MapReduce 克隆版。
源自于google的MapReduce论文
MapReduce是一种计算模型，用以进行大数据量的计算。其中Map对数据集上的独立元素进行指定的操作，生成键-值对形式中间结果。
Reduce则对中间结果中相同“键”的所有“值”进行规约，以得到最终结果。MapReduce这样的功能划分，非常适合在大量计算机组成的分布式并行环境里进行数据处理。

JobTracker：Master节点，只有一个，管理所有作业，作业/任务的监控、错误处理等；将任务分解成一系列任务，并分派给TaskTracker。
TaskTracker：Slave节点，运行Map Task和Reduce Task；并与JobTracker交互，汇报任务状态。
Map Task：解析每条数据记录，传递给用户编写的map(),并执行，将输出结果写入本地磁盘(如果为map-only作业，直接写入HDFS)。
Reducer Task：从Map Task的执行结果中，远程读取输入数据，对数据进行排序，将数据按照分组传递给用户编写的reduce函数执行。



--------------------------------------------
###MapReduce处理流程
http://www.toutiao.com/i6409526349823738369/?tt_from=weixin&utm_campaign=client_share&from=singlemessage&app=news_article&utm_source=weixin&isappinstalled=1&iid=7841861916&utm_medium=toutiao_ios&wxshare_count=2&pbid=41749390721


###yarn组件
YARN是Hadoop2.x框架下的资源管理系统，其组成部分为：
1）全局资源管理器（global resource manager）：整个系统的资源管理和调配。
2）节点管理器（node manager）（每个节点都有一个）负责任务的启动、配置及其资源的监控
3）针对每个应用程序的应用程序管理器（application-specific application master）（因为Hadoop2.x支持的计算框架有很多，
	不只是MapReduce，还有像storm、spark、Tez不同处理机制的计算框架，所以MapReduce是一种应用程序，
	每个MapReduce作业是MapReduce类型程序的一个实例）
4）调度器（scheduler）（在资源管理器里）
5）容器（container）：一部分CPU和内存组成一个容器，最为资源使用，一个应用程序运行在一组容器中。
	在了解了各个组件的功能之后，借助下图yarn.jpg，我们看一下提交一个作业的流程：

###yarn调度
1）客户端向资源管理器提交作业程序，作业程序的类型决定了使用哪种应用程序管理器（MapReduce、storm、Tez...）
2）资源管理器协调资源，在一个节点上获取一个运行应用程序管理器实例的容器
3）应用程序管理器（application master）在资源管理器中注册
4）应用程序管理器通过资源请求与资源管理器协商资源，包括该容器所在的节点和该容器的详细说明（CPU核数量和内存大小）
5）和 6）应用程序管理器在一个节点上或者多个节点上运行其Map Task和Reduce Task
7）在容器中运行的应用程序向应用程序管理器汇报执行度
8）应用程序执行完毕，应用程序管理器就会从资源管理器中取消注册，作业占用的资源会释放到系统中



###MapReduce计算框架

MapReduce总的可以分为map阶段、shuffle阶段和reduce阶段。

###map阶段
1）从HDFS中将输入值传输到Mapper节点
除了传输之外，在读取过程中，还需要做一个转换过程，将数据转换为键值对的形式（MapReduce处理的输入必须为键值对的形式），
这个过程通过InputFormat完成（默认为TextInputFormat）

2）Mapper
根据自己写的Mapper函数对文件进行处理，同样输出的是键值对（如wordcount中统计收到的数据中每个词出现的次数）

3）Partitioner
Patitioner根据Reducer的数量和自定义的划分方法（没有自定义的话，Hadoop有默认实现）去划分Mapper的输出；划分的结果会按照Mapper输出的键进行排序。

4）Combiner（***这一步是可选的***）
经过Partitioner排序后，如果作业中配置了Combiner，就会调用Combiner，Combiner就好像在Mapper端提前进行一下Reducer一样。
那为什么要提前进行呢？这是为了尽量减少对网络带宽的需求，比如经典的wordcount程序，在Mapper端处理之后，我们可能得到一个像key = apple，
value = {1,1,1,1,1,1}的结果，如果我们能先对其进行一下Combiner，那么就能得到key = apple，value = 6的结果，传输这样的数据，
肯定是要比key = apple，value = {1,1,1,1,1,1}的数据节省带宽的。
那既然能够节省传输带宽，为什么又是可选的呢？何不每次都默认执行Combiner？这是因为并不是每一个Mapper都能进行Combiner；比如现在我们的任
务要统计一段时间内的每天的最高气温，假设开始有两个Mapper，输出为（0，10，20）和（15，25），那么提前进行Combiner可以使得传递给Reducer
端的数据为（20， 25）这样最后的结果还是为25，且传输的数据量变小；但是假如我们要求一段时间内的平均温度呢？如果开始就在Mapper端进行Combiner求平
均温度，那么Reducer端得到的数据为（10, 20），算出的平均温度为15，但是实际上的平均温度为（0， 10， 20 ， 15 ，25）的平均，为14；
***所以需要搞清楚Combiner合适不合适提前进行***。


###shuffle阶段
shuffle阶段要做的事就是保证Mapper输出的数据传输到合适的Reducer进行处理，如下图所示：

shuffle阶段，每个Reducer都会使用HTTP协议从Mapper节点获得自己的划分（Reducer通过Application Master来获取自己应该查询哪些Mapper
节点来获取自己划分的信息，因为每个Mapper实例完成后，会通知Application Master运行阶段产生的划分）


###reduce阶段
1）Reducer
根据自己写的reduce程序对数据进行处理（如wordcount中将每个单词出现的次数加起来得到总和）
2）将处理结果输出到HDFS


###总结
通过对Hadoop2.x框架的处理流程和MapReduce计算框架的处理流程的梳理，可以在进行程序编写时有一个更清楚的认识，下一步应该具体做些什么。
 科技
 
--------------------------------------------------------------------
###Mapreduce中Combiner的使用及误区
http://blog.csdn.net/guoery/article/details/8529004

对于Combiner有几点需要说明的是：

1）有很多人认为这个combiner和map输出的数据合并是一个过程，其实不然，map输出的数据合并只会产生在有数据spill出的时候，即进行merge操作。

2）与mapper与reducer不同的是，***combiner没有默认的实现，需要显式的设置在conf中才有作用***。

3）并不是所有的job都适用combiner，只有操作满足结合律的才可设置combiner。combine操作类似于：opt(opt(1, 2, 3), opt(4, 5, 6))。
如果opt为求和、求最大值的话，可以使用，但是如果是求中值的话，不适用。

4）一般来说，combiner和reducer它们俩进行同样的操作。

但是：特别值得注意的一点，一个combiner只是处理一个结点中的的输出，而不能享受像reduce一样的输入（经过了shuffle阶段的数据），
这点非常关键。具体原因查看下面的数据流解释：

如果你的reduce是可交换及可组合的，那么它也就可以作为一个Combiner。***你只要在driver中添加下面这行代码就可以在词频统计程序中启用Combiner***。


--------------------------------------------------------------------
###MapReduce使用combiner优化性能
http://blog.csdn.net/moxiaomomo/article/details/15676575

(示例为从HBase表读取数据，计算，然后写入另一个HBase表中)

Configuration configuration = HBaseConfiguration.create();  
Job job = new Job(configuration, "test_mr");  
ob.setJarByClass(Test.class);            
job.setNumReduceTasks(4);  // reduce任务数量默认为1  
          
Scan scan = new Scan();  
scan.setCacheBlocks(false);   
scan.setCaching(1000); //每次从服务器端读取的行数，默认为配置文件中设置的值  
TableMapReduceUtil.initTableMapperJob("table_for_read", scan, MyMapper.class, ImmutableBytesWritable.class, ImmutableBytesWritable.class, job);  

job.setCombinerClass(MyCombiner.class);   //***设置combiner***  

TableMapReduceUtil.initTableReducerJob("table_to_write", MyReducer.class, job);  
          
job.waitForCompletion(true);  
















