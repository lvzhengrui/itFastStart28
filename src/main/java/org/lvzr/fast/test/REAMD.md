

###Unitils的简单实用
https://my.oschina.net/u/856702/blog/86302

###unitil.properties配置文件 
http://blog.sina.com.cn/s/blog_573a052b0102e9xu.html

Test Stub 只参与测试， 不在乎它是何时何地以何种方式参与测试的，不验证产生的结果
Test Spy  不但参与测试，你还要验证它的参与产生了某种结果。非mock模拟对象的监视，进行调用验证。
Mock Object 参与测试，验证某种结果，还要验证调用次数



测试哑元(Dummy) - 只是帮助测试项目编译通过，不在具体测试里面起任何作用。
测试桩(Stub) - 只是能返回帮助测试的值
测试间谍(Spy) - 目的是测试被测单元接收到的值，也能返回值。Test Spy里肯定是要增加取参数的函数，用于测试
仿冒对象(Fake): 用能更简单的实现，部分实行测试替代。
仿制对象(Mock object) - 主要目的是测试函数调用，调用顺序。同时具备Stub， Spy功能。Mock不是仿真器，
但是一个Mock Case的确可以仿真在某一个特定场景下被测模块与其他模块的交互。



