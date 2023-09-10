package com.ricky.desafio_spring.service;

import com.ricky.desafio_spring.dto.MarcaDto;
import com.ricky.desafio_spring.dto.ModeloDto;

import java.util.List;

public interface MarcaService {

    void cadastrarMarca(MarcaDto marcaDto);

    List<MarcaDto> getAllMarca();

    MarcaDto getMarcaById(String id);

    void updateMarca(MarcaDto marcaDto, String id);

    void deleteMarcaById(String id);


}
