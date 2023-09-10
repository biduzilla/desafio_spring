package com.ricky.desafio_spring.service.impl;

import com.ricky.desafio_spring.dto.MarcaDto;
import com.ricky.desafio_spring.entity.Marca;
import com.ricky.desafio_spring.exception.MarcaJaExiste;
import com.ricky.desafio_spring.exception.MarcaNaoEncontrada;
import com.ricky.desafio_spring.repository.MarcaRepository;
import com.ricky.desafio_spring.service.MarcaService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class MarcaServiceImpl implements MarcaService {
    private final MarcaRepository marcaRepository;

    @Override
    public void cadastrarMarca(MarcaDto marcaDto) {

        if (marcaRepository.existsByCodDenatran(marcaDto.getCodDenatran()) ||
                marcaRepository.existsByNome(marcaDto.getNome())) {
            throw new MarcaJaExiste();
        }

        Marca marca = Marca.builder()
                .id(UUID.randomUUID().toString())
                .ativo(marcaDto.getAtivo())
                .codDenatran(marcaDto.getCodDenatran())
                .nome(marcaDto.getNome())
                .build();

        marcaRepository.save(marca);
    }

    @Override
    public List<MarcaDto> getAllMarca() {
        return marcaToMarcaDto(marcaRepository.findAll());
    }

    @Override
    public MarcaDto getMarcaById(String id) {
        Marca marca = marcaRepository.findById(id).orElseThrow(MarcaNaoEncontrada::new);
        return MarcaDto.builder()
                .nome(marca.getNome())
                .id(marca.getId())
                .codDenatran(marca.getCodDenatran())
                .ativo(marca.getAtivo())
                .modelos(marca.getModelos())
                .build();
    }

    @Override
    public void updateMarca(MarcaDto marcaDto, String id) {
        if (marcaRepository.existsByNome(marcaDto.getNome())) {
            throw new MarcaJaExiste();
        }

        Marca marca = marcaRepository.findById(id).orElseThrow(MarcaNaoEncontrada::new);
        marca.setAtivo(marcaDto.getAtivo());
        marca.setCodDenatran(marcaDto.getCodDenatran());
        marca.setNome(marcaDto.getNome());

        marcaRepository.save(marca);
    }

    @Override
    public void deleteMarcaById(String id) {
        try {
            marcaRepository.deleteById(id);
        } catch (Exception e) {
            throw new MarcaNaoEncontrada();
        }
    }

    private List<MarcaDto> marcaToMarcaDto(List<Marca> marcas) {
        return marcas.stream().map(
                marca -> {
                    return MarcaDto.builder()
                            .id(marca.getId())
                            .modelos(marca.getModelos())
                            .ativo(marca.getAtivo())
                            .nome(marca.getNome())
                            .codDenatran(marca.getCodDenatran())
                            .build();
                }
        ).collect(Collectors.toList());
    }
}
