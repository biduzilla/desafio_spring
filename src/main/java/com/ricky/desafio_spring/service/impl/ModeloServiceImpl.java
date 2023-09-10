package com.ricky.desafio_spring.service.impl;

import com.ricky.desafio_spring.dto.ModeloDto;
import com.ricky.desafio_spring.repository.ModeloRepository;
import com.ricky.desafio_spring.service.ModeloService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ModeloServiceImpl implements ModeloService {

    private final ModeloRepository modeloRepository;

    public ModeloServiceImpl(ModeloRepository modeloRepository) {
        this.modeloRepository = modeloRepository;
    }


    @Override
    public void cadastrarModelo(ModeloDto modelo) {

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
