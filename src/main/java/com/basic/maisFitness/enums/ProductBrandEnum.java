package com.basic.maisFitness.enums;

public enum ProductBrandEnum {
    CAJU_BRASIL(0, "Cajú Brasil"),
    CCM(1, "CCM"),
    COLCCI(2, "Colcci"),
    LIVE(3, "Live!"),
    ALTO_GIRO(4, "Alto Giro"),
    OBBIA(5, "Obbia");

    private int code;
    private String description;

    ProductBrandEnum(int code, String description) {
        this.code = code;
        this.description = description;
    }

    public int getCode() {
        return code;
    }

    public String getDescription() {
        return description;
    }

    public static ProductBrandEnum valueOf(int code) {
        for (ProductBrandEnum value : ProductBrandEnum.values()) {
            if (value.getCode() == code) {
                return value;
            }
        }
        throw new IllegalArgumentException("Código da marca do produto inválida");
    }
}
