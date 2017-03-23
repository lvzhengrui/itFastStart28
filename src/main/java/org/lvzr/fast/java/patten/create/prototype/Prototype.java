package org.lvzr.fast.java.patten.create.prototype;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

/**
 *5��ԭ��ģʽ��Prototype��
 *ԭ��ģʽ��Ȼ�Ǵ����͵�ģʽ�������빤��ģʽû�й�ϵ�������ּ��ɿ�������ģʽ��˼����ǽ�һ��������Ϊԭ�ͣ�
 *������и��ơ���¡������һ����ԭ�������Ƶ��¶���
 *��С���ͨ������ĸ��ƣ����н��⡣��Java�У����ƶ�����ͨ��clone()ʵ�ֵģ��ȴ���һ��ԭ���ࣺ
 *�ܼ򵥣�һ��ԭ���ֻ࣬��Ҫʵ��Cloneable�ӿڣ���дclone�������˴�clone�������Ըĳ���������ƣ�
 *
   ��ΪCloneable�ӿ��Ǹ��սӿڣ���������ⶨ��ʵ����ķ���������cloneA����cloneB��
    ��Ϊ�˴����ص���super.clone()��仰��super.clone()���õ���Object��clone()����������Object����
   ��clone()��native�ģ�������ôʵ�֣��һ�����һƪ�����У����ڽ��Java�б��ط����ĵ��ã��˴��������
 
  ��������ҽ���϶����ǳ���ƺ������˵һ�£�������Ҫ�˽�����ǳ���Ƶĸ��
  ǳ���ƣ���һ�������ƺ󣬻����������͵ı����������´��������������ͣ�ָ��Ļ���ԭ������ָ��ġ�
  ��ƣ���һ�������ƺ󣬲����ǻ����������ͻ����������ͣ��������´����ġ�����˵��������ƽ�������ȫ���׵ĸ��ƣ�
     ��ǳ���Ʋ����ס�

  �˴���дһ����ǳ���Ƶ����ӣ�
 */
public class Prototype implements Cloneable, Serializable {  
	  
    private static final long serialVersionUID = 1L;  
    private String string;  
  
    private SerializableObject obj;  
  
    /* ǳ���� */  
    public Object clone() throws CloneNotSupportedException {  
        Prototype proto = (Prototype) super.clone();  
        return proto;  
    }  
  
    /* ��� */  
    public Object deepClone() throws IOException, ClassNotFoundException {  
        /* д�뵱ǰ����Ķ������� */  
        ByteArrayOutputStream bos = new ByteArrayOutputStream();  
        ObjectOutputStream oos = new ObjectOutputStream(bos);  
        oos.writeObject(this);  
  
        /* �������������������¶��� */  
        ByteArrayInputStream bis = new ByteArrayInputStream(bos.toByteArray());  
        ObjectInputStream ois = new ObjectInputStream(bis);  
        return ois.readObject();  
    }  
  
    public String getString() {  
        return string;  
    }  
  
    public void setString(String string) {  
        this.string = string;  
    }  
  
    public SerializableObject getObj() {  
        return obj;  
    }  
  
    public void setObj(SerializableObject obj) {  
        this.obj = obj;  
    }  
    
}  

class SerializableObject implements Serializable {  
    private static final long serialVersionUID = 1L;  
}  
