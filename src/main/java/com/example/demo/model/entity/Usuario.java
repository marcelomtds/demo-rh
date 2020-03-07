package com.example.demo.model.entity;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "usuario")
public class Usuario {

    @Id
    @SequenceGenerator(name = "usuario_generator", sequenceName = "usuario_generator_id_seq", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "usuario_generator")
    private Long id;

    @Column(length = 200, nullable = false)
    private String nomeCompleto;

    @Column(length = 100, nullable = false)
    private String perfilDescricao;

    @Column(length = 11, unique = true)
    private String cpf;

    @Column(length = 10485760)
    private String imagem;

    @Column(length = 10, nullable = false)
    private String senha;

    @ManyToOne
    @JoinColumn(name = "id_sexo", nullable = false)
    private Sexo sexo;

}
