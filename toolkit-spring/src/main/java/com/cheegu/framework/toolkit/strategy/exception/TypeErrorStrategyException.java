package com.cheegu.framework.toolkit.strategy.exception;

/**
 * @author tac - liaojf@cheegu.com
 * @since 2019/1/23
 */
public class TypeErrorStrategyException extends RuntimeException {
    public TypeErrorStrategyException(Class type, Class realType) {
        super(String.format("%s not instance of %s", realType, type));
    }
}
