package com.example.newmagicdietia.dto;

import com.example.newmagicdietia.dto.Enums.Category;

import java.time.LocalDate;

public record FoodItemRequestDTO(String nameFood,
                                 LocalDate validity,
                                 Integer amount,
                                 Category category) {
}
