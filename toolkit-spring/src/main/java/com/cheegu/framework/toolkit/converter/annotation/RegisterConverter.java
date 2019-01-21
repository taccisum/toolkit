package com.cheegu.framework.toolkit.converter.annotation;

import org.springframework.stereotype.Component;

import java.lang.annotation.*;

/**
 * @author tac - liaojf@cheegu.com
 * @since 2019/1/21
 */
@Target(ElementType.TYPE)
@Documented
@Retention(RetentionPolicy.RUNTIME)
@Component
public @interface RegisterConverter {
    boolean register() default true;

    Class from();

    Class to();
}
