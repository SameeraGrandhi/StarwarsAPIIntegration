package com.starwars.rest;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.web.client.RestTemplate;

@ExtendWith(SpringExtension.class)
public class SwapAPIClientTest {

    @Mock
    RestTemplate restTemplate;

    @InjectMocks
    SwapAPIClient apiClient;

    @Test
    public void when(){

    }
}
