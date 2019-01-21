package com.cheegu.framework.toolkit.converter;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

/**
 * @author tac - liaojf@cheegu.com
 * @since 2019/1/21
 */
public abstract class ConverterSkeleton<S, T> extends com.google.common.base.Converter<S, T> implements Converter<S, T>, BeansTypeAware<S, T> {
    @Override
    public List<T> convertAll(List<S> source) {
        List<T> ls = new ArrayList<>();
        super.convertAll(source).forEach(ls::add);
        return ls;
    }

    @Override
    protected final T doForward(S s) {
        // make naming more meaningful
        return doConvert(s);
    }

    protected abstract T doConvert(S source);

    @Override
    @Deprecated
    protected final S doBackward(T target) {
        throw new UnsupportedOperationException("not support do convert backward");
    }

    @Override
    @Deprecated
    public final com.google.common.base.Converter reverse() {
        throw new UnsupportedOperationException("not support do convert backward");
    }

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
