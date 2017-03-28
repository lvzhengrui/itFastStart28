package org.lvzr.fast.java.annotation;

import java.lang.annotation.*;

@Documented
@Target(ElementType.FIELD)
@Inherited
@Retention(RetentionPolicy.RUNTIME )
public @interface MyAnno {
    /**
     * �Ƿ���Ϊnull
     * @return
     */
    boolean isCanNull() default true;

    /**
     * �Ƿ���Ϊ���ַ���
     * @return
     */
    boolean isCanEmpty() default true;

    /**
     * �Ƿ���Ϊ0
     * @return
     */
    boolean isCanZero() default true;
}

