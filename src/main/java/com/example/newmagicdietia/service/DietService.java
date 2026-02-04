package com.example.newmagicdietia.service;

import com.example.newmagicdietia.dto.DietRequestDTO;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class DietService {

    ArrayList<DietRequestDTO> diets;

    public DietService() {
        diets = new ArrayList<>();
    }

    public ArrayList<DietRequestDTO> getDiets() {
        return diets;
    }

    public ArrayList<DietRequestDTO> addDiet(DietRequestDTO  diet) {
        diets.add(diet);
        return diets;
    }

    public void removeDiet(){
        diets.clear();
    }


}
