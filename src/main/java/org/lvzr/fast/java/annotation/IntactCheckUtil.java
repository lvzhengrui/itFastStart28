package org.lvzr.fast.java.annotation;

 
import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.util.Arrays;
import java.util.List;

import org.lvzr.fast.util.ReflectUtil;

public class IntactCheckUtil {

	public static boolean check(Object obj) {

		//����
		List<Field> list = Arrays.asList(obj.getClass().getDeclaredFields());
		
		for (int i = 0; i < list.size(); i++) {
			Field field = list.get(i);
			// �Ƿ�ʹ��MyAnnoע��
			if (field.isAnnotationPresent(MyAnno.class)) {
				//������е�ע��
				for (Annotation anno : field.getDeclaredAnnotations()) {
					//�ҵ��Լ���ע��
					if (anno.annotationType().equals(MyAnno.class)) {
						
						//ע���ֵ
						if (!((MyAnno) anno).isCanNull()) {
							if (ReflectUtil.getFieldValueByName(field.getName(), obj) == null) {
								throw new RuntimeException("�ࣺ" + Mouse.class + "�����ԣ�" 
										+ field.getName() + "����Ϊ�գ�ʵ�ʵ�ֵ:"
										+ ReflectUtil.getFieldValueByName(field.getName(), obj)
										+ ",ע�⣺field.getDeclaredAnnotations()");
							}
						}
						
						if (!((MyAnno) anno).isCanEmpty()) {
							if (ReflectUtil.getFieldValueByName(field.getName(), obj).equals("")) {
								throw new RuntimeException("�ࣺ" + Mouse.class + "�����ԣ�" 
									+ field.getName()
									+ "����Ϊ���ַ�����ʵ�ʵ�ֵ:" 
									+ ReflectUtil.getFieldValueByName(field.getName(), obj)
									+ ",ע�⣺field.getDeclaredAnnotations()");
							}
						}
						
						if (!((MyAnno) anno).isCanZero()) {
							if (ReflectUtil.getFieldValueByName(field.getName(), obj).toString().equals("0")
									|| ReflectUtil.getFieldValueByName(field.getName(), obj).toString().equals("0.0")) {
								throw new RuntimeException("�ࣺ" + Mouse.class + "�����ԣ�" 
									+ field.getName()
									+ "����Ϊ���ַ�0��ʵ�ʵ�ֵ:" 
									+ ReflectUtil.getFieldValueByName(field.getName(), obj)
									+ ",ע�⣺field.getDeclaredAnnotations()");
							}
						}
					}
				}
			}

		}
		return true;
	}
	

	
	
}
