

###关于 Java 数组的 12 个最佳方法
http://www.iteye.com/news/28296


### JAVA集合详解(Collection和Map接口)
http://blog.csdn.net/lioncode/article/details/8673391


在Java的util包中有两个所有集合的父接口Collection和Map,它们的父子关系： 
           java.util
        +Collection 这个接口extends自 --java.lang.Iterable接口
           +List 接口 
              -ArrayList 类
              -LinkedList 类
              -Vector 类     此类是实现同步的

           +Queue 接口
              +不常用，在此不表.

           +Set 接口
              +SortedSet 接口
                 -TreeSet 类
              -HashSet

        +Map 接口
          -HashMap 类 (除了不同步和允许使用 null 键/值之外,与 Hashtable 大致相同.)
          -Hashtable 类 此类是实现同步的,不允许使用 null 键值
          +SortedMap 接口
             -TreeMap 类
             
             


