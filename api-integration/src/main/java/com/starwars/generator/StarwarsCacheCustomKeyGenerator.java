package com.starwars.generator;

import org.springframework.cache.interceptor.KeyGenerator;
import org.springframework.util.StringUtils;

import java.lang.reflect.Method;

/**
 * Class responsible for generating cachekeys for managing cache at
 * swap api client cache responses.
 */
public class StarwarsCacheCustomKeyGenerator implements KeyGenerator {

    @Override
    public Object generate(Object target, Method method, Object... params) {
        return method.getName() + "_" + StringUtils.arrayToDelimitedString(params,"_");
    }
}
