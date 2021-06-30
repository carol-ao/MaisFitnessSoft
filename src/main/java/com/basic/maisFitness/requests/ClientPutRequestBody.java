package com.basic.maisFitness.requests;

import com.basic.maisFitness.enums.ProductSizeEnum;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ClientPutRequestBody {

    private Long id;
    private String name;
    private String cpf;
    private ProductSizeEnum bust;
    private ProductSizeEnum hips;
}
