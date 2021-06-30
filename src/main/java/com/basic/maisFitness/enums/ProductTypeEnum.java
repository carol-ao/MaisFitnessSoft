package com.basic.maisFitness.enums;

public enum ProductTypeEnum {
    MACACAO(0, "Macacão"),
    MACAQUITO(1, "Macaquito"),
    SHORT_MEIA_COXA(2, "Short meia coxa"),
    SHORT_CURTO(3, "Short curto"),
    SHORT_CORREDOR(4, "Short corredor"),
    SHORT_SAIA(5, "Short saia"),
    LEGGING(6, "Legging"),
    JOGGER(7, "Jogger"),
    TOP_ABERTO(8, "Top aberto"),
    TOP_BASICO(9, "Top basico"),
    CROPETE(10, "Cropete"),
    T_SHIRT(11, "T-shirt"),
    REGATA(12, "Regata"),
    CASACO(13, "Casaco"),
    COLETE(14, "Colete"),
    ACESSORIOS(15, "Acessorios"),
    SAPATOS(16, "Sapatos"),
    MODA_PRAIA(17, "Moda praia");

    private int code;
    private String description;

    ProductTypeEnum(int code, String description) {
        this.code = code;
        this.description = description;
    }

    public int getCode() {
        return code;
    }

    public String getDescription() {
        return description;
    }

    public static ProductTypeEnum valueOf(int code) {
        for (ProductTypeEnum value : ProductTypeEnum.values()) {
            if (value.getCode() == code) {
                return value;
            }
        }
        throw new IllegalArgumentException("Código do tipo do produto inválido");
    }
}
