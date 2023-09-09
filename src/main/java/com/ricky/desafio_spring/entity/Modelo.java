package com.ricky.desafio_spring.entity;

import lombok.*;

import javax.persistence.*;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Builder
@Entity
@Table(name = "tab_modelo")
public class Modelo {
    @Id
    @Column(name = "modelo_id")
    private String id;

    @Column(name = "modelo_nome")
    private String nome;

    @Column(name = "modelo_ano")
    private Integer ano;

    @Column(name = "modelo_ativo")
    private Boolean ativo;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ref_marca")
    private Marca marca;
}
