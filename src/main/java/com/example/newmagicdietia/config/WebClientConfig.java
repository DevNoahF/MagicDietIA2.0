package com.example.newmagicdietia.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.web.reactive.function.client.WebClient;

@Configuration
public class WebClientConfig {

    String apiKey = System.getenv("API_KEY");



    @Bean
    public WebClient geminiWebClient(WebClient.Builder builder){
        return builder
                .baseUrl("https://generativelanguage.googleapis.com")
                .defaultHeader("x-goog-api-key", apiKey)
                .defaultHeader(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE)
                .build();
    }

}
