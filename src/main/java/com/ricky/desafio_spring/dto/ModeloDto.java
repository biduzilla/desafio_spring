package com.ricky.desafio_spring.dto;

import lombok.*;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Setter
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ModeloDto {
    private String id;
    @NotEmpty(message = "{campo.nome.obrigatorio}")
    private String nome;
    @NotNull(message = "{campo.ano.obrigatorio}")
    private Integer ano;
    @NotNull(message = "{campo.ativo.obrigatorio}")
    private Boolean ativo;
}
