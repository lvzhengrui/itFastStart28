

###hamcrest
hamcrest可以有效增加junit的测试能力，用一些对通俗语言来进行测试.

Hamcrest 是一个测试的框架，它提供了一套通用的匹配符 Matcher，灵活使用这些匹配符定义的规则，程序员可以更加精确的表达自己
的测试思想，指定所想设定的测试条件。比如，有时候定义的测试数据范围太精 确，往往是若干个固定的确定值，这时会导致测试非常
脆弱，因为接下来的测试数据只要稍稍有变化，就可能导致测试失败（比如 assertEquals( x, 10 ); 只能判断 x 是否等于 10，如果 
x 不等于 10， 测试失败）；有时候指定的测试数据范围又不够太精确，这时有可能会造成某些本该会导致测试不通过的数据，仍然会
通过接下来的测试，这样就会降低测试的价 值。 Hamcrest 的出现，给程序员编写测试用例提供了一套规则和方法，使用其可以更加精
确的表达程序员所期望的测试的行为。


###hamcrest常用的匹配器:
核心
anything - 总是匹配,如果你不关心测试下的对象是什么是有用的
describedAs - 添加一个定制的失败表述装饰器
is - 改进可读性装饰器 - 见下 “Sugar”

逻辑
allOf - 如果所有匹配器都匹配才匹配, short circuits (很难懂的一个词,意译是短路,感觉不对,就没有翻译)(像 Java &&)
anyOf - 如果任何匹配器匹配就匹配, short circuits (像 Java ||)
not - 如果包装的匹配器不匹配器时匹配,反之亦然

对象
equalTo - 测试对象相等使用Object.equals方法
hasToString - 测试Object.toString方法
instanceOf, isCompatibleType - 测试类型
notNullValue, nullValue - 测试null
sameInstance - 测试对象实例
Beans
hasProperty - 测试JavaBeans属性

集合
array - 测试一个数组元素test an array’s elements against an array of matchers
hasEntry, hasKey, hasValue - 测试一个Map包含一个实体,键或者值
hasItem, hasItems - 测试一个集合包含一个元素
hasItemInArray - 测试一个数组包含一个元素

数字
closeTo - 测试浮点值接近给定的值
greaterThan, greaterThanOrEqualTo, lessThan, lessThanOrEqualTo - 测试次序

文本
equalToIgnoringCase - 测试字符串相等忽略大小写
equalToIgnoringWhiteSpace - 测试字符串忽略空白
containsString, endsWith, startsWith - 测试字符串匹配









