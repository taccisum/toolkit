package com.cheegu.framework.toolkit.converter.util;

import com.cheegu.framework.toolkit.converter.Converter;
import com.cheegu.framework.toolkit.converter.annotation.RegisterConverter;
import org.junit.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * @author tac - liaojf@cheegu.com
 * @since 2019/1/21
 */
public class ConverterFactoryUtilsTest {
    @Test
    public void isConverterCandidate() throws Exception {
        assertThat(ConverterFactoryUtils.isConverterCandidate(new FooConverter())).isTrue();
        assertThat(ConverterFactoryUtils.isConverterCandidate(new FooConverterNotInheritFromConverter())).isFalse();
    }

    abstract class AbstractFooConverter implements Converter<Object, Object> {
        @Override
        public Object convert(Object o) {
            return null;
        }

        @Override
        public List<Object> convertAll(List<Object> from) {
            return null;
        }
    }

    @RegisterConverter(from = Object.class, to = Object.class)
    class FooConverter extends AbstractFooConverter {
    }

    @RegisterConverter(from = Object.class, to = Object.class)
    class FooConverterNotInheritFromConverter {
    }
}


