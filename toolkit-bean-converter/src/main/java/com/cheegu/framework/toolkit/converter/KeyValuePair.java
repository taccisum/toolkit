package com.cheegu.framework.toolkit.converter;

import java.util.AbstractMap;

/**
 * @author tac - liaojf@cheegu.com
 * @since 2019/1/21
 */
public class KeyValuePair<KEY, VALUE> extends AbstractMap.SimpleEntry<KEY, VALUE> {
    public KeyValuePair(KEY key, VALUE value) {
        super(key, value);
    }
}
