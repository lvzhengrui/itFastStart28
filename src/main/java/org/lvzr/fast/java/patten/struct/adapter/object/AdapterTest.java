package org.lvzr.fast.java.patten.struct.adapter.object;

import org.lvzr.fast.java.patten.struct.adapter.Source;
import org.lvzr.fast.java.patten.struct.adapter.Targetable;

/**
 * �����������ģʽ(����ע��)
 * ����˼·�����������ģʽ��ͬ��ֻ�ǽ�Adapter�����޸ģ���β��̳�Source�࣬
 * ���ǳ���Source���ʵ�����Դﵽ��������Ե����⡣��ͼ��
 */
public class AdapterTest {  
  
    public static void main(String[] args) {  
        Source source = new Source();  
        Targetable target = new Wrapper(source);  
        target.method1();  
        target.method2();  
    }  
    
}  

