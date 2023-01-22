package com.starwars.spring;

import com.starwars.generator.StarwarsCacheCustomKeyGenerator;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cache.interceptor.KeyGenerator;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableCaching
public class CacheConfiguration {

    public static final String CUSTOM_KEY_GENERATOR_BEAN_NAME = "StarwarsCacheCustomKeyGenerator";

    @Bean(CUSTOM_KEY_GENERATOR_BEAN_NAME)
    public KeyGenerator providesStarWarsKeyGenerator() {
        return new StarwarsCacheCustomKeyGenerator();
    }
}
