package com.basic.maisFitness.domain;

import com.basic.maisFitness.enums.ProductBrandEnum;
import com.basic.maisFitness.enums.ProductColorEnum;
import com.basic.maisFitness.enums.ProductSizeEnum;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Objects;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private ProductSizeEnum size;
    private ProductBrandEnum brand;
    private ProductColorEnum color;
    
}
