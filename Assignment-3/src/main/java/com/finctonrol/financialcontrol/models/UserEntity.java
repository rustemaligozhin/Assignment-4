package com.finctonrol.financialcontrol.models;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.*;


@Entity
@Data
@Table(name = "users")
@AllArgsConstructor
@NoArgsConstructor

public class UserEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;
    @Column(name = "username")
    @NotBlank(message = "username is required")

    private String username;
    @Column(name = "password")
    @NotBlank(message = "password is required")
    private String password;
    @Column(name = "name")
    @NotBlank(message = "name is required")
    private String name;
    @Column(name = "surname")
    @NotBlank(message = "surname is required")
    private String surname;
    @Column(name = "email")
    @NotBlank(message = "Email is required")
    private String email;

}
