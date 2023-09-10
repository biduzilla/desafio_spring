package com.ricky.desafio_spring.service.impl;

import com.ricky.desafio_spring.dto.ModeloDto;
import com.ricky.desafio_spring.entity.Modelo;
import com.ricky.desafio_spring.repository.ModeloRepository;
import com.ricky.desafio_spring.service.ModeloService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class ModeloServiceImpl implements ModeloService {

    private final ModeloRepository modeloRepository;

    @Override
    public void cadastrarModelo(ModeloDto modelo, String idMarca) {

    }

    @Override
    public List<ModeloDto> getAllModelos() {
        return null;
    }

    @Override
    public List<ModeloDto> getAllModelosByMarca(String marca) {
        return null;
    }

    @Override
    public ModeloDto getModeloById(String id) {
        return null;
    }

    @Override
    public void updateModelo(ModeloDto modelo, String id) {

    }

    @Override
    public void deleteModeloById(String id) {

    }
}
