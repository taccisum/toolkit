package com.cheegu.framework.toolkit.spring.boot;

import com.cheegu.framework.toolkit.converter.RegisterConverterProcessor;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.context.annotation.Bean;

/**
 * @author tac - liaojf@cheegu.com
 * @since 2019/1/21
 */
public class BeanConverterAutoConfiguration {
    @Bean
    @ConditionalOnMissingBean
    public RegisterConverterProcessor registerConverterProcessor() {
        return new RegisterConverterProcessor();
    }
}
