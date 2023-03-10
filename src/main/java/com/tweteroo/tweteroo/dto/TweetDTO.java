package com.tweteroo.tweteroo.dto;

import jakarta.validation.constraints.NotBlank;

public record TweetDTO(
    @NotBlank String username,
    String avatar,
    @NotBlank String tweet) {
    
        
}
