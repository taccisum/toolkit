package com.cheegu.framework.toolkit.converter.annotation;

import org.springframework.stereotype.Component;

import java.lang.annotation.*;

/**
 * @author tac - liaojf@cheegu.com
 * @since 2019/1/21
 * @deprecated
 */
@Target(ElementType.TYPE)
@Documented
@Retention(RetentionPolicy.RUNTIME)
@Component
@Deprecated
public @interface RegisterConverter {
    boolean register() default true;

    Class from();

    Class to();
}
