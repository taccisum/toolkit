package com.cheegu.framework.toolkit.strategy;

import com.cheegu.framework.toolkit.strategy.annotation.RegisterStrategy;
import com.cheegu.framework.toolkit.strategy.exception.TypeErrorStrategyException;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;

/**
 * @author tac - liaojf@cheegu.com
 * @since 2019/1/23
 */
public class RegisterStrategyProcessor implements BeanPostProcessor {
    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        return bean;
    }

    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        if (bean != null && bean instanceof Strategy) {
            RegisterStrategy annotation = bean.getClass().getAnnotation(RegisterStrategy.class);
            if (annotation != null && annotation.register()) {
                if (!annotation.type().isAssignableFrom(bean.getClass())) {
                    throw new TypeErrorStrategyException(annotation.type(), bean.getClass());
                }
                StrategyFactories.register(annotation.type(), annotation.key(), (Strategy) bean);
            }
        }
        return bean;
    }
}
