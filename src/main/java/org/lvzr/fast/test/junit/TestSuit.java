package org.lvzr.fast.test.junit;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;
import org.lvzr.fast.test.powermock.complex.EmployeeRepositoryTest;
import org.lvzr.fast.test.powermock.simple.BactchConvertorJunitTest;

//RunWith��ʾ�������һ��suite����
@RunWith(Suite.class)

//˵��������а�����Щ�����齨
@SuiteClasses({BactchConvertorJunitTest.class,EmployeeRepositoryTest.class,})

public class TestSuit{
	
	
	
}


