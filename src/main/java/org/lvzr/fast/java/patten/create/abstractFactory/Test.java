package org.lvzr.fast.java.patten.create.abstractFactory;

import org.lvzr.fast.java.patten.create.factoryMethod.Sender;

/**
 2�����󹤳�ģʽ��Abstract Factory��
   ��������ģʽ��һ��������ǣ���Ĵ������������࣬Ҳ����˵�������Ҫ��չ���򣬱���Թ���������޸ģ���Υ���˱հ�ԭ��
   ���ԣ�����ƽǶȿ��ǣ���һ�������⣬��ν�������õ����󹤳�ģʽ��������������࣬
   ����һ����Ҫ�����µĹ��ܣ�ֱ�������µĹ�����Ϳ����ˣ�����Ҫ�޸�֮ǰ�Ĵ��롣��Ϊ���󹤳���̫����⣬
   �����ȿ���ͼ��Ȼ��ͺʹ��룬�ͱȽ�������⡣
  
 * ��ʵ���ģʽ�ĺô����ǣ����������������һ�����ܣ�����ʱ��Ϣ����ֻ����һ��ʵ���࣬
 * ʵ��Sender�ӿڣ�ͬʱ��һ�������࣬ʵ��Provider�ӿڣ���OK�ˣ�
 * ����ȥ�Ķ��ֳɵĴ��롣����������չ�ԽϺã�
 */
public class Test {  
  
    public static void main(String[] args) {  
    	//�����ӿ�
        Provider provider = new SendMailFactory();  
        Sender sender = provider.produce();  
        sender.Send();  
    }  
    
}  

