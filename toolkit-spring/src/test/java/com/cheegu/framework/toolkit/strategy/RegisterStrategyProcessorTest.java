package com.cheegu.framework.toolkit.strategy;

import com.cheegu.framework.toolkit.strategy.annotation.RegisterStrategy;
import com.cheegu.framework.toolkit.strategy.exception.ExistsStrategyException;
import com.cheegu.framework.toolkit.strategy.exception.TypeErrorStrategyException;
import org.junit.After;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * @author tac - liaojf@cheegu.com
 * @since 2019/1/23
 */
public class RegisterStrategyProcessorTest {
    @After
    public void tearDown() throws Exception {
        StrategyFactories.clear();
    }

    @Test
    public void postProcessAfterInitialization() throws Exception {
        new RegisterStrategyProcessor().postProcessAfterInitialization(new SayHelloWorldStrategy(), "s");
        FooStrategy strategy = StrategyFactories.get(FooStrategy.class, "SayHelloWorldStrategy");
        assertThat(strategy).isNotNull();
        assertThat(strategy.greeting()).isEqualTo("hello world");
    }

    @Test(expected = TypeErrorStrategyException.class)
    public void registerErrorTypeStrategy() throws Exception {
        new RegisterStrategyProcessor().postProcessAfterInitialization(new ErrorTypeStrategy(), "s");
    }

    @Test(expected = ExistsStrategyException.class)
    public void registerRepeatedKeyStrategy() throws Exception {
        RegisterStrategyProcessor processor = new RegisterStrategyProcessor();
        processor.postProcessAfterInitialization(new RepeatedKeyStrategy(), "s");
        processor.postProcessAfterInitialization(new RepeatedKeyStrategy(), "s");
    }

    @Test
    public void registerRepeatedKeyStrategyButDifferentType() throws Exception {
        new RegisterStrategyProcessor().postProcessAfterInitialization(new RepeatedKeyStrategy(), "s");
        new RegisterStrategyProcessor().postProcessAfterInitialization(new AnotherRepeatedKeyStrategy(), "s");
        FooStrategy s1 = StrategyFactories.get(FooStrategy.class, "RepeatedKeyStrategy");
        BarStrategy s2 = StrategyFactories.get(BarStrategy.class, "RepeatedKeyStrategy");
        assertThat(s1).isNotNull();
        assertThat(s2).isNotNull();
    }

    @Test
    public void registerWhenNoStrategy() throws Exception {
        new RegisterStrategyProcessor().postProcessAfterInitialization(new NoStrategy(), "s");
        FooStrategy strategy = StrategyFactories.get(FooStrategy.class, "NoStrategy");
        assertThat(strategy).isNull();
    }

    @Test
    public void withoutRegisterStrategy() throws Exception {
        RegisterStrategyProcessor processor = new RegisterStrategyProcessor();
        processor.postProcessAfterInitialization(new WithoutRegisterStrategy(), "s");
        processor.postProcessAfterInitialization(new WithoutRegisterStrategy1(), "s");
        FooStrategy s1 = StrategyFactories.get(FooStrategy.class, "WithoutRegisterStrategy");
        BarStrategy s2 = StrategyFactories.get(BarStrategy.class, "WithoutRegisterStrategy1");
        assertThat(s1).isNull();
        assertThat(s2).isNull();
    }

    private interface FooStrategy extends Strategy {
        String greeting();
    }

    private interface BarStrategy extends Strategy {
    }

    @RegisterStrategy(type = FooStrategy.class, key = "SayHelloWorldStrategy")
    private static class SayHelloWorldStrategy implements FooStrategy {
        @Override
        public String greeting() {
            return "hello world";
        }
    }

    @RegisterStrategy(type = BarStrategy.class, key = "ErrorTypeStrategy")
    private static class ErrorTypeStrategy implements FooStrategy {
        @Override
        public String greeting() {
            return "hello world";
        }
    }

    @RegisterStrategy(type = FooStrategy.class, key = "RepeatedKeyStrategy")
    private static class RepeatedKeyStrategy implements FooStrategy {
        @Override
        public String greeting() {
            return "hello world";
        }
    }

    @RegisterStrategy(type = BarStrategy.class, key = "RepeatedKeyStrategy")
    private static class AnotherRepeatedKeyStrategy implements BarStrategy {
    }

    @RegisterStrategy(type = FooStrategy.class, key = "NoStrategy")
    private static class NoStrategy {
    }

    @RegisterStrategy(type = BarStrategy.class, key = "WithoutRegisterStrategy", register = false)
    private static class WithoutRegisterStrategy implements BarStrategy {
    }

    private static class WithoutRegisterStrategy1 implements BarStrategy {
    }
}
