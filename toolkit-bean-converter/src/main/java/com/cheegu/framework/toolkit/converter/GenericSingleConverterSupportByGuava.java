package com.cheegu.framework.toolkit.converter;

import java.util.ArrayList;
import java.util.List;

/**
 * 基于Guava Converter的单向Converter support
 *
 * @author tac
 * @since 2.0
 */
public abstract class GenericSingleConverterSupportByGuava<FROM, TO> extends com.google.common.base.Converter<FROM, TO>
        implements Converter<FROM, TO> {
    @Override
    public List<TO> convertAll(List<FROM> from) {
        List<TO> ls = new ArrayList<>();
        super.convertAll(from).forEach(ls::add);
        return ls;
    }

    @Override
    @Deprecated
    protected final FROM doBackward(TO to) {
        //只支持单向转换
        throw new UnsupportedOperationException();
    }

    @Override
    @Deprecated
    public final com.google.common.base.Converter reverse() {
        //只支持单向转换
        throw new UnsupportedOperationException();
    }
}
