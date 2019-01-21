package com.cheegu.framework.toolkit.converter;

import java.util.List;

/**
 * @author tac - liaojf@cheegu.com
 * @since 2019/1/21
 */
public interface Converter<FROM, TO> {
    TO convert(FROM from);

    List<TO> convertAll(List<FROM> from);
}
