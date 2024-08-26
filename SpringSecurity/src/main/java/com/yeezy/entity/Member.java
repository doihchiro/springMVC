package com.yeezy.entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class Member {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String username;
    private String password;
    private String name;

    @Enumerated(EnumType.STRING)
    private Role role;

    private boolean enabled; // true, false
}
