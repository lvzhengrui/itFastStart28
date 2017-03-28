源自于google的MapReduce论文，发表于2004年12月，Hadoop MapReduce是google MapReduce 克隆版。
源自于google的MapReduce论文
MapReduce是一种计算模型，用以进行大数据量的计算。其中Map对数据集上的独立元素进行指定的操作，生成键-值对形式中间结果。
Reduce则对中间结果中相同“键”的所有“值”进行规约，以得到最终结果。MapReduce这样的功能划分，非常适合在大量计算机组成的分布式并行环境里进行数据处理。

JobTracker：Master节点，只有一个，管理所有作业，作业/任务的监控、错误处理等；将任务分解成一系列任务，并分派给TaskTracker。
TaskTracker：Slave节点，运行Map Task和Reduce Task；并与JobTracker交互，汇报任务状态。
Map Task：解析每条数据记录，传递给用户编写的map(),并执行，将输出结果写入本地磁盘(如果为map-only作业，直接写入HDFS)。
Reducer Task：从Map Task的执行结果中，远程读取输入数据，对数据进行排序，将数据按照分组传递给用户编写的reduce函数执行。




