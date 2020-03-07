package com.example.demo.model.entity;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Data
@Entity
@Table(name = "sexo")
public class Sexo {

    @Id
    private Long id;

    @Column(length = 10, nullable = false, unique = true)
    private String descricao;

}
