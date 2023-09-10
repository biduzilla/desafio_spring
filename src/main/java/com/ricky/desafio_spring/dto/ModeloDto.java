package com.ricky.desafio_spring.dto;

import javax.validation.constraints.NotEmpty;

public class ModeloDto {
    @NotEmpty(message = "{campo.nome.obrigatorio}")
    private String nome;
    @NotEmpty(message = "{campo.ano.obrigatorio}")
    private Integer ano;
    @NotEmpty(message = "{campo.ativo.obrigatorio}")
    private Boolean ativo;
}
