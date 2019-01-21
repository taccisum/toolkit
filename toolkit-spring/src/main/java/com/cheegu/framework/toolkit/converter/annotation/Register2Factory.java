package com.cheegu.framework.toolkit.converter.annotation;

import org.springframework.stereotype.Component;

import java.lang.annotation.*;

/**
 * TODO:: rename to Converter
 *
 * @author tac - liaojf@cheegu.com
 * @since 2019/1/21
 */
@Target(ElementType.TYPE)
@Documented
@Retention(RetentionPolicy.RUNTIME)
@Component
public @interface Register2Factory {
    boolean register() default true;

    Class from();

    Class to();
}
