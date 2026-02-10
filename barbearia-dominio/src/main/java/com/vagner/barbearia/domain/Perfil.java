package com.vagner.barbearia.domain;

import com.vagner.barbearia.enums.PerfilEnum;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "TB_PERFIL")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Perfil {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID_PERFIL")
    private Long id;

    @Enumerated(EnumType.STRING)
    @Column(name = "NM_PERFIL", nullable = false, unique = true)
    private PerfilEnum nome;

    @Column(name = "DS_PERFIL")
    private String descricao;
}