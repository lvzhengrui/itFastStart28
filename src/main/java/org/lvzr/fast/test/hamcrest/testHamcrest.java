package org.lvzr.fast.test.hamcrest;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

import org.hamcrest.Matchers;
import org.junit.Test;


public class testHamcrest {

	@Test
	public void testHamcrest() {
		// 比较50是否和50相等
		assertThat(50, Matchers.equalTo(50));
		// 50是否大于30并且小于60
		assertThat("错误", 50, allOf(greaterThan(30), lessThan(60)));
		// 判断字符串是否以.txt结尾
		assertThat("错误", "abc.txt", endsWith(".txt"));
	}
	
}
