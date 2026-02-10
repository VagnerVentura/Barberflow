package com.vagner.barbearia.domain;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@Table(name = "TB_COMISSAO")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Comissao {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID_COMISSAO")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "ID_PROFISSIONAL")
    private Profissional profissional;

    @ManyToOne
    @JoinColumn(name = "ID_VENDA")
    private Venda venda;

    @Column(name = "VL_COMISSAO", precision = 10, scale = 2)
    private BigDecimal valorComissao;

    @Column(name = "DT_CALCULO")
    private LocalDateTime dataCalculo;
}
