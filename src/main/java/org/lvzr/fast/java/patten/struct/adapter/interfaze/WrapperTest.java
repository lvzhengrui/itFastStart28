package org.lvzr.fast.java.patten.struct.adapter.interfaze;

import org.lvzr.fast.java.patten.struct.adapter.Targetable;

/**
 * ������������ģʽ�ǽӿڵ�������ģʽ���ӿڵ��������������ģ���ʱ����д��һ���ӿ����ж�����󷽷���
 * ������д�ýӿڵ�ʵ����ʱ������ʵ�ָýӿڵ����з�������������ʱ�Ƚ��˷ѣ�
 * ��Ϊ���������еķ�������������Ҫ�ģ���ʱֻ��ҪĳһЩ���˴�Ϊ�˽��������⣬
 * ���������˽ӿڵ�������ģʽ��������һ�������࣬�ó�����ʵ���˸ýӿڣ�ʵ�������еķ�����
 * �����ǲ���ԭʼ�Ľӿڴ򽻵���ֻ�͸ó�����ȡ����ϵ����������дһ���࣬�̳иó����࣬
 * ��д������Ҫ�ķ������С���һ����ͼ��
 *
 */
public class WrapperTest {  
  
    public static void main(String[] args) {  
    	
    	Targetable source1 = new SourceSub1();  
    	Targetable source2 = new SourceSub2();  
          
        source1.method1();  
        source1.method2();  
        source2.method1();  
        source2.method2();  
    }  
    
}  

