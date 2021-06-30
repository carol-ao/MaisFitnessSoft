package com.basic.maisFitness.enums;

public enum ProductSizeEnum {
    P(0),
    M(1),
    G(2),
    GG(3),
    PLUS(4);

    private int code;

    ProductSizeEnum(int code) {
        this.code = code;
    }

    public int getCode() {
        return code;
    }

    public static ProductSizeEnum valueOf(int code) {
        for (ProductSizeEnum value : ProductSizeEnum.values()) {
            if (value.getCode() == code) {
                return value;
            }
        }
        throw new IllegalArgumentException("Código do tamanho do produto inválido");
    }
}
