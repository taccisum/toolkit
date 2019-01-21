package com.cheegu.framework.toolkit.converter;

import java.util.List;

/**
 * @author tac - liaojf@cheegu.com
 * @since 2019/1/21
 */
public interface Converter<S, T> {
    T convert(S source);

    List<T> convertAll(List<S> source);
}
