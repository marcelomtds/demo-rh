package com.example.demo.model.filter;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ColaboradorFilter {

    private String nomeCompleto;
    private String cpf;
    private Long sexoId;
    private Long cargoId;

}