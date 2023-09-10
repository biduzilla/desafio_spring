package com.ricky.desafio_spring.service;

import com.ricky.desafio_spring.dto.ModeloDto;

import java.util.List;

public interface ModeloService {

    void cadastrarModelo(ModeloDto modelo, String idMarca);

    List<ModeloDto> getAllModelos();

    List<ModeloDto> getAllModelosByMarca(String idMarca);

    ModeloDto getModeloById(String id);

    void updateModelo(ModeloDto modelo, String id);

    void deleteModeloById(String id);


}
