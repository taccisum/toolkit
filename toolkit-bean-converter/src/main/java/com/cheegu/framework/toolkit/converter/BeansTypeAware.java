package com.cheegu.framework.toolkit.converter;

/**
 * @author tac - liaojf@cheegu.com
 * @since 2019/1/21
 */
public interface BeansTypeAware<S, T> {
    Class<S> getSourceType();

    Class<T> getTargetType();
}
