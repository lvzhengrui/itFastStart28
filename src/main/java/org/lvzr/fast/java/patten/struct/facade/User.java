package org.lvzr.fast.java.patten.struct.facade;

/**9�����/����ģʽ��Facade�� ����ģʽ 
 * ���ģʽ��Ϊ�˽��������֮�ҵ�������ϵ�ģ���springһ�������Խ������֮��Ĺ�ϵ���õ������ļ��У�
 * �����ģʽ���ǽ����ǵĹ�ϵ����һ��Facade���У�����������֮�����϶ȣ���ģʽ��û���漰���ӿڣ�
 * ������ͼ����������һ�����������������Ϊ����

 * �������û��Computer�࣬��ô��CPU��Memory��Disk����֮�佫���໥����ʵ����
 * ������ϵ��������������ص��������޸�һ���࣬���ܻ������������޸ģ��ⲻ��������Ҫ�����ģ�
 * ����Computer�࣬����֮��Ĺ�ϵ��������Computer������������˽�������ã��⣬�������ģʽ��
 */
public class User {  
	  
    public static void main(String[] args) {  
        Computer computer = new Computer();  
        computer.startup();  
        computer.shutdown();  
    }  
}  

