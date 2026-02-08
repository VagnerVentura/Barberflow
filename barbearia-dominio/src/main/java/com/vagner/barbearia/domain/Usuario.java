package com.vagner.barbearia.domain;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Entity
@Table(name = "TB_USUARIO")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID_USUARIO")
    private Long id;

    @Column(name = "DS_EMAIL", nullable = false, unique = true, length = 100)
    private String email;

    @Column(name = "DS_SENHA", nullable = false, length = 255)
    private String senha;

    @Column(name= "TP_USUARIO", nullable = false, length = 30)
    private String tipoUsuario;

    @Column(name = "FL_ATIVO", length = 1)
    private String ativo;

    @Column(name = "DT_CADASTRO" )
    private LocalDateTime dataCadastro;
}
