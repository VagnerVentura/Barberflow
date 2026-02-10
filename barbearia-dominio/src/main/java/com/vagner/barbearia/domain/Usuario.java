package com.vagner.barbearia.domain;

import com.vagner.barbearia.enums.StatusAtivoEnum;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

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

    @Column(name = "NM_USUARIO", nullable = false, unique = true, length = 100)
    private String nomeUsuario;

    @Column(name = "DS_EMAIL", nullable = false, unique = true, length = 100)
    private String email;

    @Column(name = "DS_SENHA", nullable = false, length = 255)
    private String senha;

    @Column(name = "FL_ATIVO", length = 1)
    private StatusAtivoEnum ativo;

    @Column(name = "DT_CRIACAO", updatable = false)
    private LocalDateTime dataCriacao;

    @Column(name = "DT_ATUALIZACAO" )
    private LocalDateTime dataAtualizacao;

    @OneToMany(mappedBy = "usuario", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<UsuarioPerfil> perfis = new ArrayList<>();

    @PrePersist
    public void prePersist() {
        this.dataCriacao = LocalDateTime.now();
        this.ativo = StatusAtivoEnum.S;
    }

    @PreUpdate
    public void preUpdate() {
        this.dataAtualizacao = LocalDateTime.now();
    }

}
