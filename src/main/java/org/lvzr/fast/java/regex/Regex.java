package org.lvzr.fast.java.regex;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.junit.Assert;
import org.junit.Test;

public class Regex {
	
	@Test
	public void checkEmail(){
		// Ҫ��֤���ַ���
	    String str = "service@xsoftlab.net";
	    // ������֤����
	    String regEx = "[a-zA-Z_]{1,}[0-9]{0,}@(([a-zA-z0-9]-*){1,}\\.){1,3}[a-zA-z\\-]{1,}";
	    // ����������ʽ
	    Pattern pattern = Pattern.compile(regEx);
	    // ���Դ�Сд��д��
	    // Pattern pat = Pattern.compile(regEx, Pattern.CASE_INSENSITIVE);
	    Matcher matcher = pattern.matcher(str);
	    // �ַ����Ƿ���������ʽ��ƥ��
	    Assert.assertTrue(matcher.matches());
	}
	
	@Test
	public void searchStr(){
		// Ҫ��֤���ַ���
	    String str = "baike.xsoftlab.net";
	    // ������ʽ����
	    String regEx = "baike.*";
	    // ����������ʽ
	    Pattern pattern = Pattern.compile(regEx);
	    // ���Դ�Сд��д��
	    // Pattern pat = Pattern.compile(regEx, Pattern.CASE_INSENSITIVE);
	    Matcher matcher = pattern.matcher(str);
	    // �����ַ������Ƿ���ƥ��������ʽ���ַ�/�ַ���
	    Assert.assertTrue(matcher.find());
	}
	
	
}
