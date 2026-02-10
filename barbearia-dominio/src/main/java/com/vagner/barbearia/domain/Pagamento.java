package com.vagner.barbearia.domain;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@Table(name = "TB_PAGAMENTO")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Pagamento {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID_PAGAMENTO")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "ID_VENDA")
    private Venda venda;

    @Column(name = "TP_PAGAMENTO", length = 30)
    private String tipoPagamento;

    @Column(name = "ST_PAGAMENTO", length = 30)
    private String statusPagamento;

    @Column(name = "VL_PAGO", precision = 10, scale = 2)
    private BigDecimal valorPago;

    @Column(name = "DT_PAGAMENTO")
    private LocalDateTime dataPagamento;
}

