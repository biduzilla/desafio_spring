package com.ricky.desafio_spring.repository;

import com.ricky.desafio_spring.entity.Marca;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface MarcaRepository extends JpaRepository<Marca, String> {
    Optional<List<Marca>> findByAtivo(Boolean ativo);

    Optional<List<Marca>> findByCodDenatran(String cod);
}
