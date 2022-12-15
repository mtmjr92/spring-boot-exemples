package com.example.demorollback.domain;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
public class Erro {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private Long id;

    @Column(name = "ERRO")
    private String erro;

}
