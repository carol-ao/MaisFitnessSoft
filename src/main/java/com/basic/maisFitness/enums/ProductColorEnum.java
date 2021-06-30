package com.basic.maisFitness.enums;

public enum ProductColorEnum {
    VERDE(0),
    PRETO(1),
    AZUL(2),
    ROSA(3),
    VERMELHO(4),
    AMARELO(5),
    BRANCO(6),
    ESTAMPADO(7),
    LARANJA(8),
    CINZA(9),
    ROXO(10);

    private int code;

    ProductColorEnum(int code) {
        this.code = code;
    }

    public int getCode() {
        return code;
    }

    public static ProductColorEnum valueOf(int code) {
        for (ProductColorEnum value : ProductColorEnum.values()) {
            if (value.getCode() == code) {
                return value;
            }
        }
        throw new IllegalArgumentException("Código da cor do produto inválida");
    }
}
