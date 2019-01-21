package com.cheegu.framework.toolkit.converter;

import org.junit.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * @author tac - liaojf@cheegu.com
 * @since 2019/1/21
 */
public class ConverterSkeletonTest {
    @Test
    public void getSourceType() throws Exception {
        assertThat(new String2IntegerConverter().getSourceType()).isEqualTo(String.class);
    }

    @Test
    public void getTargetType() throws Exception {
        assertThat(new String2IntegerConverter().getTargetType()).isEqualTo(Integer.class);
    }

    private static class String2IntegerConverter extends ConverterSkeleton<String, Integer> {
        @Override
        public Integer convert(String s) {
            return null;
        }

        @Override
        public List<Integer> convertAll(List<String> from) {
            return null;
        }
    }
}