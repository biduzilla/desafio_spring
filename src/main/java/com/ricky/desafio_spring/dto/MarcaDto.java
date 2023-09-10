package com.ricky.desafio_spring.dto;

import com.ricky.desafio_spring.entity.Modelo;
import lombok.*;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.List;

@Setter
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class MarcaDto {
    private String id;
    @NotEmpty(message = "{campo.nome.obrigatorio}")
    private String nome;

    @NotEmpty(message = "{campo.codDenatran.obrigatorio}")
    private String codDenatran;

    @NotNull(message = "{campo.ativo.obrigatorio}")
    private Boolean ativo;

    private List<ModeloDto> modelos;
}
