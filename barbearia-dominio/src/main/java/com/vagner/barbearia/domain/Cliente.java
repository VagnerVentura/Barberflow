package com.vagner.barbearia.domain;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Entity
@Table(name = "TB_CLIENTE")
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Cliente {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID_CLIENTE")
    private Long id;

    @OneToOne
    @JoinColumn(name = "ID_USUARIO", unique = true)
    private Usuario usuario;

    @Column(name = "NM_CLIENTE", length = 100)
    private String nome;

    @Column(name = "NR_CPF", length = 11, unique = true)
    private String cpf;

    @Column(name = "NR_TELEFONE", length = 20)
    private String telefone;

    @Column(name = "FL_ATIVO", length = 1)
    private String ativo;

    @Column(name = "DT_CADASTRO")
    private LocalDateTime dataCadastro;
}
