package com.vagner.barbearia.domain;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Entity
@Table(name = "TB_SERVICO")
@Getter
@Setter
public class Servico {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID_SERVICO")
    private Long id;

    @Column(name = "DS_SERVICO", length = 100)
    private String descricao;

    @Column(name = "NR_DURACAO_MIN")
    private Integer duracaoMinutos;

    @Column(name = "VL_PRECO", precision = 10, scale = 2)
    private BigDecimal preco;

    @Column(name = "FL_ATIVO", length = 1)
    private String ativo;
}