package com.example.demo.model.entity;

import lombok.Data;

import javax.persistence.*;
import java.time.LocalDate;

@Data
@Entity
@Table(name = "colaborador")
public class Colaborador {

    @Id
    @SequenceGenerator(name = "colaborador_generator", sequenceName = "colaborador_generator_id_seq", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "colaborador_generator")
    private Long id;

    @Column(length = 200, nullable = false)
    private String nomeCompleto;

    @Column(name = "data_nascimento", nullable = false)
    private LocalDate dataNascimento;

    @Column(length = 11, unique = true)
    private String cpf;

    @Column(length = 10485760)
    private String imagem;

    @ManyToOne
    @JoinColumn(name = "id_sexo", nullable = false)
    private Sexo sexo;

    @ManyToOne
    @JoinColumn(name = "id_cargo", nullable = false)
    private Cargo cargo;

}
