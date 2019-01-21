package com.cheegu.framework.toolkit.spring.boot.integration;

import com.cheegu.framework.toolkit.converter.exception.NoSuchConverterException;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static com.cheegu.framework.toolkit.converter.util.ConverterUtils.convert;
import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;

/**
 * @author tac - liaojf@cheegu.com
 * @since 2019/1/21
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class BeanConverterIntegrationTest {
    @Test
    public void convert_() throws Exception {
        assertThat(convert("123", Integer.class)).isInstanceOf(Integer.class);
        assertThat(convert("123", Integer.class)).isEqualTo(123);
    }

    @Test(expected = NoSuchConverterException.class)
    public void converterNotExist() throws Exception {
        assertThat(convert("123", Long.class)).isEqualTo(123);
    }
}