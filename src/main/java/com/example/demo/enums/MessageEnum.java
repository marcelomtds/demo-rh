package com.example.demo.enums;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public enum MessageEnum {

    MSG0001("Operação realizada com sucesso."),
    MSG0002("Colaborador não encontrado."),
    MSG0003("CPF já cadastrado no sistema."),
    MSG0004("Sexo não encontrado."),
    MSG0005("Cargo não encontrado."),
    MSG0006("Cargo já cadastrado no sistema."),
    MSG0007("CPF e/ou senha não coincidem.");

    private final String message;

    public String getMessage() {
        return message;
    }
}
