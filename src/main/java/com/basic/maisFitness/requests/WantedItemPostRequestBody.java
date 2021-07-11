package com.basic.maisFitness.requests;

import com.basic.maisFitness.enums.ProductBrandEnum;
import com.basic.maisFitness.enums.ProductColorEnum;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class WantedItemPostRequestBody {
    private Long clientId;
    private String type;
    private ProductBrandEnum brand;
    private ProductColorEnum color;
}
