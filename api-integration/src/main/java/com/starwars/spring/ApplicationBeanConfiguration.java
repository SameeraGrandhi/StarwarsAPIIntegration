package com.starwars.spring;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.reactive.function.client.WebClient;

@Configuration
public class ApplicationBeanConfiguration {

    @Bean
    public WebClient webclient() {
        WebClient webClient = WebClient
                .builder()
                .baseUrl("https://swapi.dev/api/")
                // .defaultCookie("cookieKey", "cookieValue")
                .defaultHeader(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE)
                .build();
        return webClient;
    }

    @Bean
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }
}
