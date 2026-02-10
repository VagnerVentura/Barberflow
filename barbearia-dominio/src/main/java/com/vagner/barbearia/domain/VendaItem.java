package com.vagner.barbearia.domain;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Entity
@Table(name = "TB_VENDA_ITEM")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class VendaItem {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID_ITEM")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "ID_VENDA")
    private Venda venda;

    @Column(name = "TP_ITEM", length = 20)
    private String tipoItem;

    @Column(name = "ID_REFERENCIA")
    private Long idReferencia;

    @Column(name = "VL_UNITARIO", precision = 10, scale = 2)
    private BigDecimal valorUnitario;

    @Column(name = "QT_ITEM")
    private Integer quantidade;

    @Column(name = "VL_TOTAL", precision = 10, scale = 2)
    private BigDecimal valorTotal;
}