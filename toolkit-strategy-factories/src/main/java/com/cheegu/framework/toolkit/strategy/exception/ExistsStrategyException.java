package com.cheegu.framework.toolkit.strategy.exception;

/**
 * @author tac - liaojf@cheegu.com
 * @since 2019/1/23
 */
public class ExistsStrategyException extends RuntimeException {
    public ExistsStrategyException(String key, Class clazz) {
        super(String.format("exists strategy: %s[%s]", key, clazz));
    }
}
