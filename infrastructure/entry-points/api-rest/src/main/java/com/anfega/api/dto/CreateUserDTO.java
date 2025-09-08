package com.anfega.api.dto;

public record CreateUserDTO(
        Long id,
        String name,
        String email,
        String identification
) {
}
