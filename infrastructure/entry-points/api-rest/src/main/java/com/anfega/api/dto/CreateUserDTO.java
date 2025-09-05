package com.anfega.api.dto;

public record CreateUserDTO(
        String name,
        String email,
        String identification
) {
}
