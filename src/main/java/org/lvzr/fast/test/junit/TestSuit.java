package org.lvzr.fast.test.junit;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;
import org.lvzr.fast.test.powermock.complex.EmployeeRepositoryTest;
import org.lvzr.fast.test.powermock.simple.BactchConvertorJunitTest;

//RunWith表示这个类是一个suite的类
@RunWith(Suite.class)

//说明这个类中包含哪些测试组建
@SuiteClasses({BactchConvertorJunitTest.class,EmployeeRepositoryTest.class,})

public class TestSuit{
	
	
	
}


