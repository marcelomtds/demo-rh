package com.example.demo.model.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UsuarioDTO {

    private Long id;
    private String nomeCompleto;
    private String perfilDescricao;
    private String cpf;
    private String imagem;
    private String senha;
    private Long sexoId;
    private String sexoDescricao;

}
