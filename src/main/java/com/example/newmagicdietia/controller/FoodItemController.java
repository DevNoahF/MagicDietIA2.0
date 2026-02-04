package com.example.newmagicdietia.controller;

import com.example.newmagicdietia.dto.FoodItemRequestDTO;
import com.example.newmagicdietia.service.FoodItemService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/food")
@RequiredArgsConstructor
public class FoodItemController {

    private final FoodItemService service;

    @GetMapping
    public ResponseEntity<List<FoodItemRequestDTO>> getFoodItem(){
        return ResponseEntity.ok(service.getFoodItems());
    }

    @PostMapping
    public ResponseEntity<FoodItemRequestDTO> saveFoodItem(@RequestBody FoodItemRequestDTO dto){
        service.addFoodItem(dto);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @DeleteMapping
    public ResponseEntity<Void> deleteFoodItem(){
        service.deleteFoodItem();
        return ResponseEntity.noContent().build();
    }


}
