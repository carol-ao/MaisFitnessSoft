package com.basic.maisFitness.repositories;

import com.basic.maisFitness.domain.Product;
import com.basic.maisFitness.enums.ProductBrandEnum;
import com.basic.maisFitness.enums.ProductColorEnum;
import com.basic.maisFitness.enums.ProductSizeEnum;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product,Long> {

}
