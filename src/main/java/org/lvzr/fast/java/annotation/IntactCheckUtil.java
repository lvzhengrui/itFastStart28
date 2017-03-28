package org.lvzr.fast.java.annotation;

 
import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.util.Arrays;
import java.util.List;

import org.lvzr.fast.util.ReflectUtil;

public class IntactCheckUtil {

	public static boolean check(Object obj) {

		//反射
		List<Field> list = Arrays.asList(obj.getClass().getDeclaredFields());
		
		for (int i = 0; i < list.size(); i++) {
			Field field = list.get(i);
			// 是否使用MyAnno注解
			if (field.isAnnotationPresent(MyAnno.class)) {
				//获得所有的注解
				for (Annotation anno : field.getDeclaredAnnotations()) {
					//找到自己的注解
					if (anno.annotationType().equals(MyAnno.class)) {
						
						//注解的值
						if (!((MyAnno) anno).isCanNull()) {
							if (ReflectUtil.getFieldValueByName(field.getName(), obj) == null) {
								throw new RuntimeException("类：" + Mouse.class + "的属性：" 
										+ field.getName() + "不能为空，实际的值:"
										+ ReflectUtil.getFieldValueByName(field.getName(), obj)
										+ ",注解：field.getDeclaredAnnotations()");
							}
						}
						
						if (!((MyAnno) anno).isCanEmpty()) {
							if (ReflectUtil.getFieldValueByName(field.getName(), obj).equals("")) {
								throw new RuntimeException("类：" + Mouse.class + "的属性：" 
									+ field.getName()
									+ "不能为空字符串，实际的值:" 
									+ ReflectUtil.getFieldValueByName(field.getName(), obj)
									+ ",注解：field.getDeclaredAnnotations()");
							}
						}
						
						if (!((MyAnno) anno).isCanZero()) {
							if (ReflectUtil.getFieldValueByName(field.getName(), obj).toString().equals("0")
									|| ReflectUtil.getFieldValueByName(field.getName(), obj).toString().equals("0.0")) {
								throw new RuntimeException("类：" + Mouse.class + "的属性：" 
									+ field.getName()
									+ "不能为空字符0，实际的值:" 
									+ ReflectUtil.getFieldValueByName(field.getName(), obj)
									+ ",注解：field.getDeclaredAnnotations()");
							}
						}
					}
				}
			}

		}
		return true;
	}
	

	
	
}
