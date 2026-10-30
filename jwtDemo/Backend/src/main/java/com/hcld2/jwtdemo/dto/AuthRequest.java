package com.hcld2.jwtdemo.dto;

import jakarta.validation.constraints.NotBlank;

public record AuthRequest(@NotBlank String userName,@NotBlank String password) {
}