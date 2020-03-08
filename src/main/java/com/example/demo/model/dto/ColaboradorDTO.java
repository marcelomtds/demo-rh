package com.example.demo.model.dto;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
public class ColaboradorDTO {

    private Long id;
    private String nomeCompleto;
    private LocalDate dataNascimento;
    private String cpf;
    private String imagem;
    private String nomeImagem;
    private Long sexoId;
    private String sexoDescricao;
    private Long cargoId;
    private String cargoDescricao;

}
