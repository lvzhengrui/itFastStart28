package org.lvzr.fast.ml.text;

import java.util.Locale;

import org.apache.commons.lang3.StringUtils;

/**
 * �ı����������
 * @author lvzr
 */
public class TextLike{

	public static void main(String[] args) {
		String term = "��֯����������";
		String query = "��������";
		
		//��ͬ�ַ���
		int dis = StringUtils.getFuzzyDistance(term, query, Locale.CHINA);
		System.out.println(dis);
		
		//����˹̹����(�༭����)
		int dis2 = StringUtils.getLevenshteinDistance(term, query);
		System.out.println(dis2);
		
		//Jaro����
		double dis3 = StringUtils.getJaroWinklerDistance(term.toLowerCase(), query.toLowerCase());
		System.out.println(dis3);
		
	}

}