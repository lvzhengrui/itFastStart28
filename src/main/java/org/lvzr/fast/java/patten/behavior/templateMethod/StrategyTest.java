package org.lvzr.fast.java.patten.behavior.templateMethod;

/**
 * 
 * 14��ģ�巽��ģʽ��Template Method��
 * ����һ��ģ�巽��ģʽ������ָ��һ���������У���һ�����������ٶ���1...n�������������ǳ���ģ�Ҳ������ʵ�ʵķ�����
       ����һ���࣬�̳иó����࣬��д���󷽷���ͨ�����ó����࣬ʵ�ֶ�����ĵ��ã��ȿ�����ϵͼ��

 * �Ҹ��������С�����ִ�й��̣����Ƚ�exp��"\\+"������������AbstractCalculator�����
 * calculate(String,String)��������calculate(String,String)�����ͬ���split()��
 * ֮���ٵ���calculate(int ,int)������������������뵽�����У�ִ����return num1 + num2��
 * ��ֵ���ص�AbstractCalculator�࣬����result����ӡ������������֤�����ǿ�ͷ��˼·��
 */
public class StrategyTest {  
	  
    public static void main(String[] args) {  
        String exp = "8+8";  
        AbstractCalculator cal = new Plus();  
        int result = cal.calculate(exp, "\\+");  
        System.out.println(result);  
    }  
    
}  

