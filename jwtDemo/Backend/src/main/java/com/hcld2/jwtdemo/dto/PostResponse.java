package com.hcld2.jwtdemo.dto;

import jakarta.validation.constraints.NotBlank;

public record PostResponse(@NotBlank String title, @NotBlank String content, @NotBlank String name) {
}
