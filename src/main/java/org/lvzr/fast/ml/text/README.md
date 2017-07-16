

#NLP点滴——文本相似度
http://www.cnblogs.com/huilixieqi/p/6493089.html

//相同字符数
int dis = StringUtils.getFuzzyDistance(term, query, Locale.CHINA);

//莱文斯坦距离(编辑距离)
int dis2 = StringUtils.getLevenshteinDistance(term, query);

//Jaro距离
//Jaro Distance也是字符串相似性的一种度量方式，也是一种编辑距离，Jaro 距离越高本文相似性越高;
//而Jaro–Winkler distance是Jaro Distance的一个变种。据说是用来判定健康记录上两个名字是否相同，也有说是是用于人口普查。
//从最初其应用我们便可看出其用法和用途，其定义如下：
double dis3 = StringUtils.getJaroWinklerDistance(term.toLowerCase(), query.toLowerCase());


<dependency>
    <groupId>org.apache.commons</groupId>
    <artifactId>commons-lang3</artifactId>
    <version>3.5</version>
</dependency>
		
		
		 
###文本挖掘(Text Mining)技术基础
https://wenku.baidu.com/view/581b414302020740be1e9b7e.html


### 文本挖掘详解
http://blog.csdn.net/jdbc/article/details/50408238


###阿里自然语言处理--NLP技术的应用及思考
http://www.toutiao.com/a6416452983018209538/?tt_from=mobile_qq&utm_campaign=client_share&app=news_article&utm_source=mobile_qq&iid=7841861916&utm_medium=toutiao_ios


文本转换为**向量形式并经特征选择**以后,便可以进行挖掘分析了。常用的文本挖掘分析技术
有:文本结构分析、文本摘要、文本分类、文本聚类、文本关联分析、分布分析和趋势预测等。文本分类是其中一种很
关键的挖掘任务也是在文本信息处理领域用得最多的一种技术

文本挖掘过程：
1)文本预处理:选取任务相关的文本并将其转化成文本挖掘工具可以处理的中间形式。
2)文本挖掘:在完成文本预处理后，可以利用机器学习、数据挖掘以及模式识别等方法提取面向特定应用目标的知识或模式。
3)模式评估与表示为最后一个环节，是利用已经定义好的评估指标对获取的知识或模式进行评价。如果评价结果符合要求，
就存储该模式以备用户使用;否则返回到前面的某个环节重新调整和改进，然后再进行新一轮的发现。


文本挖掘应用：
主要的应用方向和系统有，详细应用及发展趋势见本blog另外一篇文章《文本挖掘研究进展及趋势》： 
1）基于内容的搜索引擎，代表性的系统有北京大学天网、计算所的“天罗”、百度、慧聪等公司的搜索引擎； 
2）信息自动分类、自动摘要、信息过滤等文本级应用，如上海交通大学纳讯公司的自动摘要、复旦大学的文本分类，计算所基于聚类粒度原理VSM的智多星中文文本分类器
3）信息自动抽取，即将Internet上大量的非结构化的信息，抽取出格式化的数据，以备进一步的搜索应用。目前是研究热点，至今还没有实用的系统； 
4）自动问答、机器翻译等需要更多自然语言处理和理解的应用。

NLP的 四大经典“AI 完全 ” 难题：问答、复述、文摘、翻译，只要解决其中一个，另外三个就都解决了。
问答就是让机器人很开放的回答你提的各种各样问题，就像真人一样；复述是让机器用另外一种方式表达出来；文摘就是告诉你一篇很长的文章，
让你写一个100字的文摘，把它做出来是非常难做的；翻译也是很困难的，英语思维方式和中文思维方式转换过来，中间会涉及到很多复杂的问题。













