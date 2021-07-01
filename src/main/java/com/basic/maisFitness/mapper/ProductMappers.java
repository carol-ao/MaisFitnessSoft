package com.basic.maisFitness.mapper;

import com.basic.maisFitness.domain.Product;
import com.basic.maisFitness.requests.ProductPostRequestBody;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface ProductMappers {
    ProductMappers INSTANCE = Mappers.getMapper(ProductMappers.class);

    Product toProduct(ProductPostRequestBody productPostRequestBody);
}
