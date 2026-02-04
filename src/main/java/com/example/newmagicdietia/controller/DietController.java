package com.example.newmagicdietia.controller;

import com.example.newmagicdietia.dto.DietRequestDTO;
import com.example.newmagicdietia.service.DietService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/diet")
@RequiredArgsConstructor
public class DietController {

    private final DietService dietService;

    @GetMapping
    public ResponseEntity<List<DietRequestDTO>> getAllDiets(){
        return ResponseEntity.ok(dietService.getDiets());
    }

    @PostMapping
    public ResponseEntity<DietRequestDTO> saveDiet(@RequestBody DietRequestDTO dietRequestDTO){
        dietService.addDiet(dietRequestDTO);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @DeleteMapping
    public ResponseEntity<Void> deleteDiet(){
        dietService.removeDiet();
        return ResponseEntity.noContent().build();
    }



}
