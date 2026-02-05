package com.example.newmagicdietia.service;

import com.example.newmagicdietia.dto.DietRequestDTO;
import com.example.newmagicdietia.dto.FoodItemRequestDTO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatusCode;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
@Slf4j
public class RecipeService {

    private final WebClient webClient;

    public RecipeService(WebClient genimiWebClient) {
        this.webClient = genimiWebClient;
    }

    private final String apiKey = System.getenv("API_KEY");


    public Mono<String> generateRecipe(List<FoodItemRequestDTO> foodItems, List<DietRequestDTO> diets) {
        String foods = foodItems.stream()
                .map(item -> String.format("%s (%s): %d quantidade(s)",
                        item.nameFood(),
                        item.category(),
                        item.amount()))
                .collect(Collectors.joining("\n"));

        String diet = diets.stream()
                .map(userInfo -> "Dieta: " + userInfo.diet())
                .collect(Collectors.joining("\n"));

        String prompt = "Baseado na diet do usuário: " + diet +
                " ,faça uma receita com os seguintes itens: " + foods;
        log.info("prompt: " + prompt);

        Map<String, Object> requestBody =
                Map.of(
                        "system_instruction", Map.of(
                                "parts", List.of(Map.of("text", "Você é um chefe de cozinha." +
                                        "E preciso que voce crie receitas deliciosas com os ingredientes fornecidos pelo usuário e que se adeque a dieta " +
                                        "Retorne apenas a receita + modo de preparo."))
                        ),
                        "contents", List.of(
                                Map.of(
                                        "role", "user",
                                        "parts", List.of(Map.of("text", prompt))
                                )
                        )
                );


        return webClient.post()
                .uri("/v1beta/models/gemini-3-flash-preview:generateContent")
                .bodyValue(requestBody)
                .retrieve()
                .onStatus(HttpStatusCode::is4xxClientError, response ->
                        response.bodyToMono(String.class).flatMap(errorBody -> {
                            System.out.println("O gemini rejeitou o pedido porque: " + errorBody);
                            return Mono.error(new RuntimeException(errorBody));
                        })
                )
                .bodyToMono(String.class);


    }
}


