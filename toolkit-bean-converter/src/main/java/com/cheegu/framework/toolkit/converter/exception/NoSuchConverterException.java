package com.cheegu.framework.toolkit.converter.exception;

/**
 * @author tac - liaojf@cheegu.com
 * @since 2019/1/21
 */
public class NoSuchConverterException extends RuntimeException {
    public NoSuchConverterException(Class fromCls, Class toCls) {
        super("does not exist converter: from [" + fromCls + "] to [" + toCls + "]");
    }
}
