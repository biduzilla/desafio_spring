package com.ricky.desafio_spring.repository;

import com.ricky.desafio_spring.entity.Marca;
import com.ricky.desafio_spring.entity.Modelo;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface ModeloRepository extends JpaRepository<Modelo, String> {
    Optional<List<Modelo>> findByAtivo(Boolean ativo);

    Optional<List<Modelo>> findByAno(Integer ano);

    Boolean existsByNome(String nome);
    Boolean existsByNomeAndId(String nome, String id);
}
