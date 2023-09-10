package com.ricky.desafio_spring;

import com.ricky.desafio_spring.dto.ModeloDto;
import com.ricky.desafio_spring.entity.Modelo;

import java.util.List;
import java.util.stream.Collectors;

public class Utils {
    public static List<ModeloDto> modeloToModeloDto(List<Modelo> modelos) {
        return modelos.stream().map(modelo -> {
            return ModeloDto.builder()
                    .id(modelo.getId())
                    .ano(modelo.getAno())
                    .nome(modelo.getNome())
                    .ativo(modelo.getAtivo())
                    .build();
        }).collect(Collectors.toList());
    }
}
