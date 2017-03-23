package org.lvzr.fast.java.patten.behavior.iterator;

/**
 * 16��������ģʽ��Iterator��
	����˼�壬������ģʽ����˳����ʾۼ��еĶ���һ����˵�������зǳ�����������Լ�����Ƚ���Ϥ�Ļ���
	��Ȿģʽ��ʮ�����ɡ���仰����������˼��һ����Ҫ�����Ķ��󣬼��ۼ����󣬶��ǵ���������
	���ڶԾۼ�������б������ʡ����ǿ��¹�ϵͼ��
	
	���˼·�����ǳ��õ�һģһ����MyCollection�ж����˼��ϵ�һЩ������MyIterator�ж�����һϵ�е���������
	�ҳ���Collectionʵ��������������ʵ�ִ��룺
	
	�˴�����ò��ģ����һ��������Ĺ��̣��о��ǲ��Ǻ�ˬ����ʵJDK�и�����Ҳ������Щ�����Ķ�������һЩ���ģʽ��
	�ټ�һЩ�Ż��ŵ�һ��ģ�ֻҪ���ǰ���Щ����ѧ���ˣ����պ��ˣ�����Ҳ����д���Լ��ļ����࣬������ܣ�
 *
 */
public class Test {  
  
    public static void main(String[] args) {  
        Collection collection = new MyCollection();  
        Iterator it = collection.iterator();  
          
        while(it.hasNext()){  
            System.out.println(it.next());  
        }  
    }  
    
}  

