package com.cheegu.framework.toolkit.converter;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;

/**
 * @author tac - liaojf@cheegu.com
 * @since 2019/1/21
 */
public abstract class ConverterSkeleton<S, T> implements Converter<S, T>, BeansTypeAware<S, T> {
    @Override
    public Class<S> getSourceType() {
        return (Class<S>) getSuperClassActualTypeArguments()[0];
    }

    @Override
    public Class<T> getTargetType() {
        return (Class<T>) getSuperClassActualTypeArguments()[1];
    }

    private Type[] getSuperClassActualTypeArguments() {
        Type superclass = this.getClass().getGenericSuperclass();
        if (superclass instanceof ParameterizedType) {
            return ((ParameterizedType) superclass).getActualTypeArguments();
        }
        return null;
    }
}
