package com.example.newmagicdietia.dto;

import com.example.newmagicdietia.dto.Enums.Category;


public record FoodItemRequestDTO(String nameFood,
                                 Integer amount,
                                 Category category) {
}
