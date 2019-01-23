package com.cheegu.framework.toolkit.strategy.annotation;


import com.cheegu.framework.toolkit.strategy.Strategy;

import java.lang.annotation.*;

/**
 * @author tac - liaojf@cheegu.com
 * @since 2019/1/23
 */
@Target(ElementType.TYPE)
@Documented
@Retention(RetentionPolicy.RUNTIME)
public @interface RegisterStrategy {
    boolean register() default true;

    Class<? extends Strategy> type();

    String key();
}
