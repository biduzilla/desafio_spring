package com.ricky.desafio_spring.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotEmpty;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class ModeloDto {
    @NotEmpty(message = "{campo.nome.obrigatorio}")
    private String nome;
    @NotEmpty(message = "{campo.ano.obrigatorio}")
    private Integer ano;
    @NotEmpty(message = "{campo.ativo.obrigatorio}")
    private Boolean ativo;
    @NotEmpty(message = "{campo.marca.obrigatorio}")
    private String marca;
}
