package com.example.newmagicdietia.controller;

import com.example.newmagicdietia.dto.DietRequestDTO;
import com.example.newmagicdietia.dto.FoodItemRequestDTO;
import com.example.newmagicdietia.service.DietService;
import com.example.newmagicdietia.service.FoodItemService;
import com.example.newmagicdietia.service.RecipeService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

import java.util.List;

@RestController
@RequestMapping("/recipe")
@RequiredArgsConstructor
public class RecipeController {

    private final RecipeService recipeService;
    private final DietService dietService;
    private final FoodItemService foodItemService;

    @GetMapping("/generate")
    public Mono<ResponseEntity<String>> generateRecipe() {
        List<FoodItemRequestDTO> foodItems = foodItemService.getFoodItems();
        List<DietRequestDTO> users = dietService.getDiets();
        return recipeService.generateRecipe(foodItems, users)
                .map(org.springframework.http.ResponseEntity::ok)
                .defaultIfEmpty(org.springframework.http.ResponseEntity.notFound().build());
    }
}
