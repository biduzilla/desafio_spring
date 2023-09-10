package com.ricky.desafio_spring.dto;

import com.ricky.desafio_spring.entity.Modelo;
import lombok.*;

import javax.persistence.Column;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotEmpty;
import java.util.List;

@Setter
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class MarcaDto {
    @NotEmpty(message = "{campo.nome.obrigatorio}")
    private String nome;

    @NotEmpty(message = "{campo.codDenatran.obrigatorio}")
    private String codDenatran;

    @NotEmpty(message = "{campo.ativo.obrigatorio}")
    private Boolean ativo;

    private List<Modelo> modelos;
}
