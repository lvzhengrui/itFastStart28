package org.lvzr.fast.ml.text;

import java.util.Locale;

import org.apache.commons.lang3.StringUtils;

/**
 * 文本非语义距离
 * @author lvzr
 */
public class TextLike{

	public static void main(String[] args) {
		String term = "组织的网络类型";
		String query = "网络类型";
		
		//相同字符数
		int dis = StringUtils.getFuzzyDistance(term, query, Locale.CHINA);
		System.out.println(dis);
		
		//莱文斯坦距离(编辑距离)
		int dis2 = StringUtils.getLevenshteinDistance(term, query);
		System.out.println(dis2);
		
		//Jaro距离
		double dis3 = StringUtils.getJaroWinklerDistance(term.toLowerCase(), query.toLowerCase());
		System.out.println(dis3);
		
	}

}