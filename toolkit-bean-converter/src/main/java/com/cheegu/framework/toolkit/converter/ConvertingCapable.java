package com.cheegu.framework.toolkit.converter;

import com.cheegu.framework.toolkit.converter.util.ConverterUtils;

import java.util.List;

/**
 * @author tac - liaojf@cheegu.com
 * @since 2019/1/21
 */
public abstract class ConvertingCapable {
    protected <FROM, TO> TO convert(FROM from, Class<? extends FROM> fromClazz, Class<TO> toClazz) {
        return ConverterUtils.convert(from, fromClazz, toClazz);
    }

    protected <FROM, TO> TO convert(FROM from, Class<TO> toClazz) {
        return ConverterUtils.convert(from, toClazz);
    }

    protected <FROM, TO> TO convert(FROM from, TO to) {
        return (TO) ConverterUtils.convert(from, to.getClass());
    }

    protected <FROM, TO> TO convert(FROM from, Class<? extends FROM> fromClazz, TO to) {
        return (TO) ConverterUtils.convert(from, fromClazz, to.getClass());
    }

    protected <FROM, TO> List<TO> convertAll(List<FROM> fromList, Class<TO> toCls) {
        return ConverterUtils.convertAll(fromList, toCls);
    }
}
