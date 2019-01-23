package com.cheegu.framework.toolkit.strategy;


import com.cheegu.framework.toolkit.strategy.exception.ExistsStrategyException;
import com.cheegu.framework.toolkit.strategy.pojo.KeyCarrier;

import java.util.HashMap;
import java.util.Map;

/**
 * @author tac - liaojf@cheegu.com
 * @since 2019/1/23
 */
public abstract class StrategyFactories {
    /**
     * 策略注册表
     */
    static Map<Class<? extends Strategy>, Map<String, Strategy>> registry = new HashMap<>();

    public static <T extends Strategy> T get(Class<T> type, KeyCarrier keyCarrier) {
        return get(type, keyCarrier.key());
    }

    public static <T extends Strategy> T get(Class<T> type, String key) {
        Map<String, Strategy> map = registry.get(type);
        if (map == null) {
            return null;
        }
        return (T) map.get(key);
    }

    /**
     * @throws ExistsStrategyException 已存在的策略key
     */
    public static <T extends Strategy> void register(Class<? extends T> type, KeyCarrier keyCarrier, T strategy) throws ExistsStrategyException {
        register(type, keyCarrier.key(), strategy);
    }

    /**
     * @throws ExistsStrategyException 已存在的策略key
     */
    public static <T extends Strategy> void register(Class<? extends T> type, String key, T strategy) throws ExistsStrategyException {
        Map<String, Strategy> map = registry.get(type);
        if (map == null) {
            map = new HashMap<>();
            registry.put(type, map);
        } else {
            if (map.containsKey(key)) {
                throw new ExistsStrategyException(key, strategy.getClass());
            }
        }
        map.put(key, strategy);
    }

    public static void clear() {
        registry.clear();
    }
}
