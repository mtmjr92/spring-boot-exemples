package br.com.postgres.listener.domain;

import jakarta.persistence.*;

@Entity
@Table(name = "user_data")
public class UserData {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String username;
    private int randomNumber;

    // Getters and Setters
}
