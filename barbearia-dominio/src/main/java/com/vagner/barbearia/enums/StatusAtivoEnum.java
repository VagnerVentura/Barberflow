package com.vagner.barbearia.enums;

public enum StatusAtivoEnum {

    S("Ativo"),
    N("Inativo");

    private final String descricao;

    StatusAtivoEnum(String descricao) {
        this.descricao = descricao;
    }

    public String getDescricao() {
        return descricao;
    }
}
