package com.anfega.api.dto;

public record UserDTO(
        Long  id,
        String name,
        String email,
        String identification
) {
}
