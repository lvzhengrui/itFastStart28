package org.lvzr.fast.java.patten.create.factoryMethod.statiz;

import org.lvzr.fast.java.patten.create.factoryMethod.Sender;

/**
 * 1.3��̬��������ģʽ��������Ķ����������ģʽ��ķ�����Ϊ��̬�ģ�����Ҫ����ʵ����ֱ�ӵ��ü��ɡ�
 * ������˵������ģʽ�ʺϣ����ǳ����˴����Ĳ�Ʒ��Ҫ���������Ҿ��й�ͬ�Ľӿ�ʱ��
 * ����ͨ����������ģʽ���д����������ϵ�����ģʽ�У���һ�����������ַ������󣬲�����ȷ��������
 * ����������ڵڶ��֣�����Ҫʵ���������࣬���ԣ����������£����ǻ�ѡ�õ����֡�����̬��������ģʽ��
 */
public class FactoryTest {  
  
    public static void main(String[] args) {      
        Sender sender = SendFactory.produceMail();  
        sender.Send();  
    }  
}  

