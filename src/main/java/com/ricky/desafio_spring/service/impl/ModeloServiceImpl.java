package com.ricky.desafio_spring.service.impl;

import com.ricky.desafio_spring.dto.ModeloDto;
import com.ricky.desafio_spring.entity.Marca;
import com.ricky.desafio_spring.entity.Modelo;
import com.ricky.desafio_spring.exception.MarcaNaoEncontrada;
import com.ricky.desafio_spring.exception.ModeloJaExiste;
import com.ricky.desafio_spring.exception.ModeloNaoEncontrado;
import com.ricky.desafio_spring.repository.MarcaRepository;
import com.ricky.desafio_spring.repository.ModeloRepository;
import com.ricky.desafio_spring.service.ModeloService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ModeloServiceImpl implements ModeloService {

    private final ModeloRepository modeloRepository;
    private final MarcaRepository marcaRepository;

    @Override
    public void cadastrarModelo(ModeloDto modelo, String idMarca) {
        if (modeloRepository.existsByNome(modelo.getNome())) {
            throw new ModeloJaExiste();
        }
        Marca marca = marcaRepository.findById(idMarca).orElseThrow(MarcaNaoEncontrada::new);

        Modelo novoModelo = Modelo.builder()
                .id(UUID.randomUUID().toString())
                .nome(modelo.getNome())
                .ativo(modelo.getAtivo())
                .ano(modelo.getAno())
                .marca(marca)
                .build();

        modeloRepository.save(novoModelo);
    }

    @Override
    public List<ModeloDto> getAllModelos() {
        return modeloToModeloDto(modeloRepository.findAll());
    }

    @Override
    public List<ModeloDto> getAllModelosByMarca(String idMarca) {
        Marca marca = marcaRepository.findById(idMarca).orElseThrow(MarcaNaoEncontrada::new);
        return modeloToModeloDto(marca.getModelos());
    }

    @Override
    public ModeloDto getModeloById(String id) {
        Modelo modelo = modeloRepository.findById(id).orElseThrow(ModeloNaoEncontrado::new);
        return ModeloDto.builder()
                .id(modelo.getId())
                .nome(modelo.getNome())
                .ano(modelo.getAno())
                .ativo(modelo.getAtivo())
                .build();
    }

    @Override
    public void updateModelo(ModeloDto modelo, String id) {
        if (modeloRepository.existsByNome(modelo.getNome())) {
            throw new ModeloJaExiste();
        }

        Modelo modeloRecuperado = modeloRepository.findById(id).orElseThrow(ModeloNaoEncontrado::new);

        modeloRecuperado.setAno(modelo.getAno());
        modeloRecuperado.setAtivo(modelo.getAtivo());
        modeloRecuperado.setNome(modelo.getNome());

        modeloRepository.save(modeloRecuperado);
    }

    @Override
    public void deleteModeloById(String id) {
        try {
            modeloRepository.deleteById(id);
        } catch (Exception e) {
            throw new ModeloNaoEncontrado();
        }
    }

    private List<ModeloDto> modeloToModeloDto(List<Modelo> modelos) {
        return modelos.stream().map(modelo -> {
            return ModeloDto.builder()
                    .id(modelo.getId())
                    .ano(modelo.getAno())
                    .nome(modelo.getNome())
                    .build();
        }).collect(Collectors.toList());
    }
}
