package com.example.newmagicdietia.dto;

import com.example.newmagicdietia.dto.Enums.Diet;

import java.util.List;

public record DietRequestDTO (Diet diet,
                              List<FoodItemRequestDTO> foodItem) {
}
