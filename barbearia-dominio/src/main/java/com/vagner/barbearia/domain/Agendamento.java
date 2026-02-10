package com.vagner.barbearia.domain;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@Table(name = "TB_AGENDAMENTO")
@Getter @Setter
@AllArgsConstructor
@NoArgsConstructor
public class Agendamento {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID_AGENDAMENTO")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "ID_CLIENTE")
    private Cliente cliente;

    @ManyToOne
    @JoinColumn(name = "ID_PROFISSIONAL")
    private Profissional profissional;

    @ManyToOne
    @JoinColumn(name = "ID_SERVICO")
    private Servico servico;

    @Column(name = "DT_INICIO")
    private LocalDateTime dataInicio;

    @Column(name = "DT_FIM")
    private LocalDateTime dataFim;

    @Column(name = "VL_SERVICO", precision = 10, scale = 2)
    private BigDecimal valorServico;

    @Column(name = "ST_AGENDAMENTO", length = 30)
    private String status;

    @Column(name = "DT_CRIACAO")
    private LocalDateTime dataCriacao;
}