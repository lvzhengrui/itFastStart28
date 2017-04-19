package org.lvzr.fast.java.regex;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.junit.Assert;
import org.junit.Test;

/**
 * 正则表达式
 * @author lvzr
 *
 */
public class Regex {
	
	@Test
	public void checkEmail(){
	    //验证规则
	    String regEx = "[a-zA-Z_]{1,}[0-9]{0,}@(([a-zA-z0-9]-*){1,}\\.){1,3}[a-zA-z\\-]{1,}";
	    Pattern pattern = Pattern.compile(regEx);
	    //待验证字符串
	    Matcher matcher = pattern.matcher("service@xsoftlab.net");
	    //验证
	    Assert.assertTrue(matcher.matches());
	}
 
	@Test
	public void syntax(){		
		// 明确字符限定
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
		
		// | 匹配其中一个即可
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
		
		//[sc2f] 匹配其中一个即可
		Assert.assertTrue(Pattern.compile("[sc2f]")
				.matcher("s")
				.matches());
		Assert.assertTrue(Pattern.compile("[sc2f]")
				.matcher("2")
				.matches());
		
		Assert.assertFalse(Pattern.compile("[sc2f]")
				.matcher("sc")
				.matches());
		
		//[a-z] 匹配其中一个即可
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
		
		//[^scf] 不能匹配其中任何一个
		Assert.assertTrue(Pattern.compile("[^scf]")
				.matcher("a")
				.matches());
		
		Assert.assertFalse(Pattern.compile("[^scf]")
				.matcher("s")
				.matches());
 
		
		// \d限定数值类型
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
		
		// \D限定非数值类型
		Assert.assertTrue(Pattern.compile("\\D")
				.matcher("s")
				.matches());
		Assert.assertFalse(Pattern.compile("\\D")
				.matcher("2")
				.matches());
		
		//{n}匹配确定的n个
		Assert.assertTrue(Pattern.compile("s{2}")
				.matcher("ss")
				.matches());
		
		Assert.assertFalse(Pattern.compile("s{2}")
				.matcher("sss")
				.matches());
		Assert.assertFalse(Pattern.compile("s{2}")
				.matcher("s")
				.matches());
		
		//{n,}至少匹配n个
		Assert.assertTrue(Pattern.compile("s{2,}")
				.matcher("ss")
				.matches());
		Assert.assertTrue(Pattern.compile("s{2,}")
				.matcher("sss")
				.matches());
		
		Assert.assertFalse(Pattern.compile("s{2,}")
				.matcher("s")
				.matches());

		//{n,m}最少匹配n个且最多匹配m个
		
		//?等价于{0,1}，0个或1个s
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
		
		//?等价于{0,1}，0个或1个s
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
		
		//?前台没有限定字符，下面两句会抛异常
		//Assert.assertFalse(Pattern.compile("?").matcher("").matches());
		//Assert.assertFalse(Pattern.compile("?").matcher("s").matches());
		
		//*等价于{0,}，0个或多个s
		Assert.assertTrue(Pattern.compile("s*")
				.matcher("")
				.matches());
		Assert.assertTrue(Pattern.compile("s*")
				.matcher("s")
				.matches());
		Assert.assertTrue(Pattern.compile("s*")
				.matcher("ss")
				.matches());
		
		//+等价于{1,}，至少一个s
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
		
		//()子表达式
		
		//()里的内容，匹配0次或多次
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
		
		//()内容至少匹配一次
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
		
		// (?:)、(?=)、(?<=)、(?!)、(?<!)
		
		// (?:)不返匹配结果
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
  

		// \w等价于任何单词字符[A-Za-z0-9_]  \W等价于任何非单词字符[^A-Za-z0-9_]

		// \s 匹配任何不可见字符，包括空格、制表符、换页符等等。等价于[\f\n\r\t\v]。

		// \f换页符  \n换行符  \r回车符  \t制表符tab \v垂直制表符
		
	}
	
}
