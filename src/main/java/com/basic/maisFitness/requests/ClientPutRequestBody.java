package com.basic.maisFitness.requests;

import com.basic.maisFitness.enums.ProductSizeEnum;
import lombok.Builder;
import lombok.Data;

import javax.validation.constraints.Pattern;

@Data
@Builder
public class ClientPutRequestBody {

    private String name;
    @Pattern(regexp = "(^\\d{3}\\x2E\\d{3}\\x2E\\d{3}\\x2D\\d{2}$)")
    private String cpf;
    private ProductSizeEnum bust;
    private ProductSizeEnum hips;
}
