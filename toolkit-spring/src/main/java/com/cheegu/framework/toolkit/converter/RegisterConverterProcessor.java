package com.cheegu.framework.toolkit.converter;

import com.cheegu.framework.toolkit.converter.annotation.RegisterConverter;
import com.cheegu.framework.toolkit.converter.util.ConverterFactoryUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;

/**
 * @author tac - liaojf@cheegu.com
 * @since 2019/1/21
 */
public class RegisterConverterProcessor implements BeanPostProcessor {
    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        return bean;
    }

    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        if (ConverterFactoryUtils.isConverterCandidate(bean)) {
            RegisterConverter annotation = ConverterFactoryUtils.getRegisterAnnotation(bean);

            Class sourceType = null;
            Class targetType = null;

            if (annotation != null && annotation.register()) {
                sourceType = annotation.from();
                targetType = annotation.to();
            } else if (bean instanceof BeansTypeAware) {
                sourceType = ((BeansTypeAware) bean).getSourceType();
                targetType = ((BeansTypeAware) bean).getTargetType();
            }
            if (sourceType != null && targetType != null) {
                ConverterFactory.register((Converter) bean, sourceType, targetType);
            } else {
                logger.warn("failure to register converter [{}]. can not get source type or target type.", bean.getClass());
            }
        }
        return bean;
    }
}
