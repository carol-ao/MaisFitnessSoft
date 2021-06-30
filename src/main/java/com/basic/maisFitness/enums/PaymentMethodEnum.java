package com.basic.maisFitness.enums;

public enum PaymentMethodEnum {
    PIX(0, "Pix"),
    TRANSFERENCIA(1, "Transferência"),
    CARTAO_CREDITO(2, "Cartão crédito"),
    CARTAO_DEBITO(3, "Cartão débito"),
    MAQUINETA_MOVEL(4, "Maquineta móvel"),
    DINHEIRO(5, "Dinheiro");

    private int code;
    private String description;

    PaymentMethodEnum(int code, String description) {
        this.code = code;
        this.description = description;
    }

    public int getCode() {
        return code;
    }

    public String getDescription() {
        return description;
    }

    public static PaymentMethodEnum valueOf(int code) {
        for (PaymentMethodEnum value : PaymentMethodEnum.values()) {
            if (value.getCode() == code) {
                return value;
            }
        }
        throw new IllegalArgumentException("Código da marca do produto inválida");
    }
}
