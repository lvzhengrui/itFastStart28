package org.lvzr.fast.java.annotation;

import java.lang.annotation.*;

@Documented
@Target(ElementType.FIELD)
@Inherited
@Retention(RetentionPolicy.RUNTIME )
public @interface MyAnno {
    /**
     * 是否能为null
     * @return
     */
    boolean isCanNull() default true;

    /**
     * 是否能为空字符串
     * @return
     */
    boolean isCanEmpty() default true;

    /**
     * 是否能为0
     * @return
     */
    boolean isCanZero() default true;
}

