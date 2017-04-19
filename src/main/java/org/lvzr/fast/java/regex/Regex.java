package org.lvzr.fast.java.regex;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.junit.Assert;
import org.junit.Test;

/**
 * ������ʽ
 * @author lvzr
 *
 */
public class Regex {
	
	@Test
	public void checkEmail(){
	    //��֤����
	    String regEx = "[a-zA-Z_]{1,}[0-9]{0,}@(([a-zA-z0-9]-*){1,}\\.){1,3}[a-zA-z\\-]{1,}";
	    Pattern pattern = Pattern.compile(regEx);
	    //����֤�ַ���
	    Matcher matcher = pattern.matcher("service@xsoftlab.net");
	    //��֤
	    Assert.assertTrue(matcher.matches());
	}
 
	@Test
	public void syntax(){		
		// ��ȷ�ַ��޶�
		Assert.assertTrue(Pattern.compile("s")
				.matcher("s")
				.matches());
		Assert.assertTrue(Pattern.compile("ss")
				.matcher("ss")
				.matches());

		Assert.assertFalse(Pattern.compile("ss")
				.matcher("s")
				.matches());
		Assert.assertFalse(Pattern.compile("s")
				.matcher("ss")
				.matches());
		
		// | ƥ������һ������
		Assert.assertTrue(Pattern.compile("s|c")
				.matcher("s")
				.matches());
		Assert.assertTrue(Pattern.compile("s|c")
				.matcher("c")
				.matches());
		
		Assert.assertFalse(Pattern.compile("s|c")
				.matcher("ss")
				.matches());
		Assert.assertFalse(Pattern.compile("s|c")
				.matcher("sc")
				.matches());
		Assert.assertFalse(Pattern.compile("s|c")
				.matcher("a")
				.matches());
		
		Assert.assertTrue(Pattern.compile("s|c|f")
				.matcher("f")
				.matches());
		
		//[sc2f] ƥ������һ������
		Assert.assertTrue(Pattern.compile("[sc2f]")
				.matcher("s")
				.matches());
		Assert.assertTrue(Pattern.compile("[sc2f]")
				.matcher("2")
				.matches());
		
		Assert.assertFalse(Pattern.compile("[sc2f]")
				.matcher("sc")
				.matches());
		
		//[a-z] ƥ������һ������
		Assert.assertTrue(Pattern.compile("[a-z]")
				.matcher("s")
				.matches());
		Assert.assertTrue(Pattern.compile("[c-z][s-z]")
				.matcher("ss")
				.matches());
		Assert.assertTrue(Pattern.compile("[2-9]")
				.matcher("3")
				.matches());
		
		Assert.assertTrue(Pattern.compile("[a-z1-9]")
				.matcher("2")
				.matches());
		Assert.assertFalse(Pattern.compile("[a-z1-9]")
				.matcher("b1")
				.matches());
		Assert.assertTrue(Pattern.compile("[a-z][1-9]")
				.matcher("b1")
				.matches());
		
		Assert.assertFalse(Pattern.compile("[a-z]")
				.matcher("ss")
				.matches());
		Assert.assertFalse(Pattern.compile("[a-z][a-z]")
				.matcher("s")
				.matches());
		
		//[^scf] ����ƥ�������κ�һ��
		Assert.assertTrue(Pattern.compile("[^scf]")
				.matcher("a")
				.matches());
		
		Assert.assertFalse(Pattern.compile("[^scf]")
				.matcher("s")
				.matches());
 
		
		// \d�޶���ֵ����
		Assert.assertTrue(Pattern.compile("\\d")
				.matcher("2")
				.matches());
		Assert.assertTrue(Pattern.compile("\\d\\d")
				.matcher("22")
				.matches());
		
		Assert.assertFalse(Pattern.compile("\\d")
				.matcher("22")
				.matches());
		Assert.assertFalse(Pattern.compile("\\d\\d")
				.matcher("2")
				.matches());

		Assert.assertFalse(Pattern.compile("\\d")
				.matcher("s")
				.matches());
		
		// \D�޶�����ֵ����
		Assert.assertTrue(Pattern.compile("\\D")
				.matcher("s")
				.matches());
		Assert.assertFalse(Pattern.compile("\\D")
				.matcher("2")
				.matches());
		
		//{n}ƥ��ȷ����n��
		Assert.assertTrue(Pattern.compile("s{2}")
				.matcher("ss")
				.matches());
		
		Assert.assertFalse(Pattern.compile("s{2}")
				.matcher("sss")
				.matches());
		Assert.assertFalse(Pattern.compile("s{2}")
				.matcher("s")
				.matches());
		
		//{n,}����ƥ��n��
		Assert.assertTrue(Pattern.compile("s{2,}")
				.matcher("ss")
				.matches());
		Assert.assertTrue(Pattern.compile("s{2,}")
				.matcher("sss")
				.matches());
		
		Assert.assertFalse(Pattern.compile("s{2,}")
				.matcher("s")
				.matches());

		//{n,m}����ƥ��n�������ƥ��m��
		
		//?�ȼ���{0,1}��0����1��s
		Assert.assertTrue(Pattern.compile("s?")
				.matcher("")
				.matches());
		Assert.assertTrue(Pattern.compile("s?")
				.matcher("s")
				.matches());
		
		Assert.assertFalse(Pattern.compile("s?")
				.matcher("a")
				.matches());
		Assert.assertFalse(Pattern.compile("s?")
				.matcher("ss")
				.matches());
		
		//?�ȼ���{0,1}��0����1��s
		Assert.assertTrue(Pattern.compile("\\d?")
				.matcher("")
				.matches());
		Assert.assertTrue(Pattern.compile("\\d?")
				.matcher("2")
				.matches());
		
		Assert.assertFalse(Pattern.compile("\\d?")
				.matcher("a")
				.matches());
		Assert.assertFalse(Pattern.compile("\\d?")
				.matcher("ss")
				.matches());
		
		//?ǰ̨û���޶��ַ���������������쳣
		//Assert.assertFalse(Pattern.compile("?").matcher("").matches());
		//Assert.assertFalse(Pattern.compile("?").matcher("s").matches());
		
		//*�ȼ���{0,}��0������s
		Assert.assertTrue(Pattern.compile("s*")
				.matcher("")
				.matches());
		Assert.assertTrue(Pattern.compile("s*")
				.matcher("s")
				.matches());
		Assert.assertTrue(Pattern.compile("s*")
				.matcher("ss")
				.matches());
		
		//+�ȼ���{1,}������һ��s
		Assert.assertTrue(Pattern.compile("s+")
				.matcher("s")
				.matches());
		Assert.assertTrue(Pattern.compile("s+")
				.matcher("ss")
				.matches());
		
		Assert.assertFalse(Pattern.compile("s+")
				.matcher("")
				.matches());
		Assert.assertFalse(Pattern.compile("s+")
				.matcher("a")
				.matches());
		
		//()�ӱ��ʽ
		
		//()������ݣ�ƥ��0�λ���
		Assert.assertTrue(Pattern.compile("(123)*")
				.matcher("")
				.matches());
		Assert.assertTrue(Pattern.compile("(123)*")
				.matcher("123")
				.matches());
		Assert.assertTrue(Pattern.compile("(123)*")
				.matcher("123123")
				.matches());		
		
		Assert.assertFalse(Pattern.compile("(123)*")
				.matcher("121")
				.matches());
		Assert.assertFalse(Pattern.compile("(123)*")
				.matcher("12312")
				.matches());
		
		//()��������ƥ��һ��
		Assert.assertTrue(Pattern.compile("([a-z])+")
				.matcher("a")
				.matches());
		Assert.assertTrue(Pattern.compile("([a-z][1-9])+")
				.matcher("a1")
				.matches());
		
		Assert.assertFalse(Pattern.compile("([a-z])+")
				.matcher("")
				.matches());
		Assert.assertFalse(Pattern.compile("([a-z][1-9])+")
				.matcher("aa")
				.matches());
		
		// (?:)��(?=)��(?<=)��(?!)��(?<!)
		
		// (?:)����ƥ����
		Assert.assertTrue(Pattern.compile("industry|industries")
				.matcher("industry")
				.matches());
		Assert.assertTrue(Pattern.compile("industry|industries")
				.matcher("industries")
				.matches());
		
		Assert.assertFalse(Pattern.compile("industry|industries")
				.matcher("industr")
				.matches());
		
		Assert.assertTrue(Pattern.compile("industr(?:y|ies)")
				.matcher("industry")
				.matches());
		Assert.assertTrue(Pattern.compile("industr(?:y|ies)")
				.matcher("industries")
				.matches());
		
		Assert.assertTrue(Pattern.compile("industr(y|ies)")
				.matcher("industry")
				.matches());
		Assert.assertFalse(Pattern.compile("industr(y|ies)")
				.matcher("industrx")
				.matches());
  

		// \w�ȼ����κε����ַ�[A-Za-z0-9_]  \W�ȼ����κηǵ����ַ�[^A-Za-z0-9_]

		// \s ƥ���κβ��ɼ��ַ��������ո��Ʊ������ҳ���ȵȡ��ȼ���[\f\n\r\t\v]��

		// \f��ҳ��  \n���з�  \r�س���  \t�Ʊ��tab \v��ֱ�Ʊ��
		
	}
	
}
