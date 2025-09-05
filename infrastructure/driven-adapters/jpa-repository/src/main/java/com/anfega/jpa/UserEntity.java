package com.anfega.jpa;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "`users`")
@Data
public class UserEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long  id;
    private String name;
    private String email;
    private String identification;
}
