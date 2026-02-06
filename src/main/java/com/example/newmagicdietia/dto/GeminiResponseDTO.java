package com.example.newmagicdietia.dto;

import java.util.List;

public record GeminiResponseDTO(List<Candidate> candidates) {
    public record Candidate(Content content){ }

    public record Content(List<Part> parts){}

    public record Part(String text){}
}
