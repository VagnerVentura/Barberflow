package com.vagner.barbearia.domain;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.Length;

import java.math.BigDecimal;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "TB_PROFISSIONAL")
public class Profissional {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID_PROFISSIONAL")
    private Long id;

    @OneToOne
    @JoinColumn(name = "ID_USUARIO", nullable = false, unique = true)
    private Usuario usuario;

    @Column(name = "NM_PROFISSIONAL", length = 100)
    private String nome;

    @Column(name = "NR_CPF", length = 11, unique = true)
    private String cpf;

    @Column(name = "VL_COMISSAO", precision = 5, scale = 2)
    private BigDecimal percentualComissao;

    @Column(name = "FL_ATIVO", length = 1)
    private String ativo;
}
