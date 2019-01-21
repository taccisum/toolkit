package com.cheegu.framework.toolkit.converter.util;


import com.cheegu.framework.toolkit.converter.Converter;
import com.cheegu.framework.toolkit.converter.annotation.RegisterConverter;
import org.springframework.core.annotation.AnnotationUtils;

/**
 * @author tac - liaojf@cheegu.com
 * @since 2019/1/21
 */
public abstract class ConverterFactoryUtils {
    public static boolean isConverterCandidate(Object obj) {
        if (obj != null && obj instanceof Converter) {
            return true;
        }
        return false;
    }

    public static RegisterConverter getRegisterAnnotation(Object obj) {
        return AnnotationUtils.findAnnotation(obj.getClass(), RegisterConverter.class);
    }
}
