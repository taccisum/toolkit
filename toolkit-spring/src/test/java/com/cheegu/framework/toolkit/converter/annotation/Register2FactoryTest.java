package com.cheegu.framework.toolkit.converter.annotation;

import com.cheegu.framework.toolkit.converter.Converter;
import com.cheegu.framework.toolkit.converter.ConverterFactory;
import com.cheegu.framework.toolkit.converter.util.ConverterFactoryUtils;
import org.junit.After;
import org.junit.Test;
import sun.reflect.generics.reflectiveObjects.NotImplementedException;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * 注解{@link Register2Factory}使用示例
 *
 * @author tac - liaojf@cheegu.com
 * @since 2019/1/21
 */
public class Register2FactoryTest {
    @After
    public void tearDown() throws Exception {
        ConverterFactory.clean();
    }

    @Test
    public void sample() {
        for (Converter converter : scanConverter()) {
            if (ConverterFactoryUtils.isConverterCandidate(converter)) {
                Register2Factory annotation = ConverterFactoryUtils.getRegisterAnnotation(converter);
                ConverterFactory.register(converter, annotation.from(), annotation.to());
            }
        }
        assertThat(ConverterFactory.find(String.class, Integer.class).convert("123")).isEqualTo(123);
        assertThat(ConverterFactory.find(String.class, Boolean.class).convert("true")).isEqualTo(true);
    }

    private Converter[] scanConverter() {
        return new Converter[]{new FooConverter(), new FooConverter1()};
    }

    @Register2Factory(from = String.class, to = Integer.class)
    class FooConverter implements Converter<String, Integer> {
        @Override
        public Integer convert(String s) {
            return Integer.parseInt(s);
        }

        @Override
        public List<Integer> convertAll(List<String> from) {
            throw new NotImplementedException();
        }
    }

    @Register2Factory(from = String.class, to = Boolean.class)
    class FooConverter1 implements Converter<String, Boolean> {
        @Override
        public Boolean convert(String s) {
            return Boolean.parseBoolean(s);
        }

        @Override
        public List<Boolean> convertAll(List<String> from) {
            throw new NotImplementedException();
        }
    }
}
