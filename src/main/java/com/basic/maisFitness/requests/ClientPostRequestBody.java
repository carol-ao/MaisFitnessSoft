package com.basic.maisFitness.requests;

import com.basic.maisFitness.enums.ProductSizeEnum;
import lombok.Builder;
import lombok.Data;
import org.hibernate.validator.constraints.br.CPF;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;

@Data
@Builder
public class ClientPostRequestBody {

    @NotEmpty
    private String name;
    @NotEmpty
    @Pattern(regexp = "(^\\d{3}\\x2E\\d{3}\\x2E\\d{3}\\x2D\\d{2}$)")
   // @CPF
    private String cpf;
    private ProductSizeEnum bust;
    private ProductSizeEnum hips;

}
