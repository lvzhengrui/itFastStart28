
###单元测试系列之3：测试整合之王Unitils
http://stamen.iteye.com/blog/1480316

###Unitils模块组件 
Unitils通过模块化的方式来组织各个功能模块，采用类似于Spring的模块划分方式，如unitils-core、unitils-database、unitils-mock等。
  比以前整合在一个工程里面显得更加清晰，目前所有模块如下所示： 
  unitils-core：核心内核包。
  unitils-database：维护测试数据库及连接池。
  unitils-DbUnit：使用DbUnit来管理测试数据。
  unitils-easymock：支持创建Mock和宽松的反射参数匹配。
  unitils-inject：支持在一个对象中注入另一个对象。
  unitils-mock：整合各种Mock，在Mock的使用语法上进行了简化。
  unitils-orm：支持Hibernate、JPA的配置和自动数据库映射检查。
  unitils-spring：支持加载Spring的上下文配置，并检索和Spring Bean注入。



unitils-defaults.properties：默认配置文件，开启所有功能。
unitils.properties：项目级配置文件，用于项目通用属性配置。
unitils-local.properties：用户级配置文件，用于个人特殊属性配置。



