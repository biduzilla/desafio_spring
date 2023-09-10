package com.ricky.desafio_spring.dto;

import lombok.*;

import javax.validation.constraints.NotEmpty;

@Setter
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ModeloDto {
    private String id;
    @NotEmpty(message = "{campo.nome.obrigatorio}")
    private String nome;
    @NotEmpty(message = "{campo.ano.obrigatorio}")
    private Integer ano;
    @NotEmpty(message = "{campo.ativo.obrigatorio}")
    private Boolean ativo;
}
