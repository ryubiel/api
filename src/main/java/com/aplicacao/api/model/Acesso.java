package com.aplicacao.api.model;

import com.fasterxml.jackson.annotation.JsonCreator;

public enum Acesso {
    ADMIN,
    BASIC;

    @JsonCreator
    public static Acesso fromString(String value) {
        if (value == null) {
            return null;
        } else {
            return Acesso.valueOf(value.trim().toUpperCase());
        }
    }
}
