package org.lvzr.fast.test.hamcrest;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

import org.hamcrest.Matchers;
import org.junit.Test;


public class testHamcrest {

	@Test
	public void testHamcrest() {
		// �Ƚ�50�Ƿ��50���
		assertThat(50, Matchers.equalTo(50));
		// 50�Ƿ����30����С��60
		assertThat("����", 50, allOf(greaterThan(30), lessThan(60)));
		// �ж��ַ����Ƿ���.txt��β
		assertThat("����", "abc.txt", endsWith(".txt"));
	}
	
}
