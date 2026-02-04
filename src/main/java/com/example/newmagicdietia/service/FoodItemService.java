package com.example.newmagicdietia.service;

import com.example.newmagicdietia.dto.FoodItemRequestDTO;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class FoodItemService {

    ArrayList<FoodItemRequestDTO> foodItems;

    public FoodItemService(){
        foodItems = new ArrayList<>();
    }

    public ArrayList<FoodItemRequestDTO> getFoodItems(){
        return foodItems;
    }

    public ArrayList<FoodItemRequestDTO> addFoodItem(FoodItemRequestDTO foodItem){
        foodItems.add(foodItem);
        return foodItems;
    }

    public void deleteFoodItem(){
        foodItems.clear();
    }

}
