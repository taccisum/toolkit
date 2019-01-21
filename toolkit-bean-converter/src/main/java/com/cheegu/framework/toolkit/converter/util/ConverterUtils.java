package com.cheegu.framework.toolkit.converter.util;

import com.cheegu.framework.toolkit.converter.Converter;
import com.cheegu.framework.toolkit.converter.ConverterFactory;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * @author tac - liaojf@cheegu.com
 * @since 05/02/2018
 */
public abstract class ConverterUtils {
    public static <FROM, TO> TO convert(FROM from, Class<? extends FROM> fromClazz, Class<TO> toClazz) {
        return (TO) getConverter(fromClazz, toClazz).convert(from);
    }

    public static <FROM, TO> TO convert(FROM from, Class<TO> toClazz) {
        Objects.requireNonNull(from, "object from can not be null");
        return convert(from, from.getClass(), toClazz);
    }

    public static <FROM, TO> TO convert(FROM from, TO to) {
        return (TO) convert(from, to.getClass());
    }

    public static <FROM, TO> TO convert(FROM from, Class<? extends FROM> fromClazz, TO to) {
        return (TO) convert(from, fromClazz, to.getClass());
    }

    public static <FROM, TO> List<TO> convertAll(List<FROM> fromList, Class<TO> toCls) {
        if (fromList == null || fromList.size() == 0) {
            return new ArrayList<>();
        }

        return getConverter(fromList.get(0).getClass(), toCls).convertAll(fromList);
    }

    public static Converter getConverter(Class fromCls, Class toCls) {
        return ConverterFactory.find(fromCls, toCls);
    }
}
