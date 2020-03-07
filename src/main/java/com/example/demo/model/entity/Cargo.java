package com.example.demo.model.entity;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "cargo")
public class Cargo {

    @Id
    @SequenceGenerator(name = "cargo_generator", sequenceName = "cargo_id_seq", allocationSize = 1, initialValue = 2)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "cargo_generator")
    private Long id;

    @Column(length = 100, nullable = false, unique = true)
    private String descricao;

}