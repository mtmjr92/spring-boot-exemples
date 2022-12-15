package com.example.demorollback.domain;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
public class Setor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private Long id;

    @Column(name = "NOME")
    private String nome;

}
