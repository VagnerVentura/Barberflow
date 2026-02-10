package com.vagner.barbearia.domain;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Entity
@Table(name = "TB_PRODUTO")
@Getter
@Setter
public class Produto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID_PRODUTO")
    private Long id;

    @Column(name = "DS_PRODUTO", length = 100)
    private String descricao;

    @Column(name = "VL_CUSTO", precision = 10, scale = 2)
    private BigDecimal valorCusto;

    @Column(name = "VL_VENDA", precision = 10, scale = 2)
    private BigDecimal valorVenda;

    @Column(name = "QT_ESTOQUE")
    private Integer quantidadeEstoque;

    @Column(name = "FL_ATIVO", length = 1)
    private String ativo;
}