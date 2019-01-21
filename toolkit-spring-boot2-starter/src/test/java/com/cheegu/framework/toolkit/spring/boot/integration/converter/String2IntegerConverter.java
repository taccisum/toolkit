package com.cheegu.framework.toolkit.spring.boot.integration.converter;

import com.cheegu.framework.toolkit.converter.ConverterSkeleton;
import org.springframework.stereotype.Component;

/**
 * @author tac - liaojf@cheegu.com
 * @since 2019/1/21
 */
@Component
public class String2IntegerConverter extends ConverterSkeleton<String, Integer> {
    @Override
    protected Integer doConvert(String source) {
        return Integer.parseInt(source);
    }
}
