package com.ricky.desafio_spring.entity;

import lombok.*;

import javax.persistence.*;
import java.util.List;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Builder
@Entity
@Table(name = "tab_marca")
public class Marca {
    @Id
    @Column(name = "marca_id")
    private String id;

    @Column(name = "marca_nome")
    private String nome;

    @Column(name = "marca_cod_denatran")
    private String codDenatran;

    @Column(name = "marca_ativo")
    private Boolean ativo;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "marca", cascade = CascadeType.ALL)
    private List<Modelo> modelos;
}
