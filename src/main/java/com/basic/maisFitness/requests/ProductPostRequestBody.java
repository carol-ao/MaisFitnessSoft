package com.basic.maisFitness.requests;

import com.basic.maisFitness.enums.ProductBrandEnum;
import com.basic.maisFitness.enums.ProductColorEnum;
import com.basic.maisFitness.enums.ProductSizeEnum;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ProductPostRequestBody {
    private ProductSizeEnum size;
    private ProductBrandEnum brand;
    private ProductColorEnum color;
}
