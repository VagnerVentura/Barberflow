package com.vagner.barbearia.domain;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Entity
@Table(name = "TB_NOTIFICACAO")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Notificacao {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID_NOTIFICACAO")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "ID_USUARIO")
    private Usuario usuario;

    @Column(name = "TP_NOTIFICACAO", length = 30)
    private String tipoNotificacao;

    @Column(name = "DS_MENSAGEM", length = 500)
    private String mensagem;

    @Column(name = "ST_ENVIO", length = 30)
    private String statusEnvio;

    @Column(name = "DT_ENVIO")
    private LocalDateTime dataEnvio;
}

