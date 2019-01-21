package com.cheegu.framework.toolkit.converter;

import com.cheegu.framework.toolkit.converter.annotation.Register2Factory;
import com.cheegu.framework.toolkit.converter.util.ConverterFactoryUtils;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;

/**
 * @author tac - liaojf@cheegu.com
 * @since 2019/1/21
 */
public class RegisterConverterProcessor implements BeanPostProcessor {
    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        return bean;
    }

    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        if (ConverterFactoryUtils.isConverterCandidate(bean)) {
            Register2Factory annotation = ConverterFactoryUtils.getRegisterAnnotation(bean);
            ConverterFactory.register((Converter) bean, annotation.from(), annotation.to());
        }
        return bean;
    }
}
