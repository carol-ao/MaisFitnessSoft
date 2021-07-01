package com.basic.maisFitness.requests;

import com.basic.maisFitness.domain.Product;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class OrderItemPostRequestBody {

    private ProductPostRequestBody product;
    private Integer quantity;
}
