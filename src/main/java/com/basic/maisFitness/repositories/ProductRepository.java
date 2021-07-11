package com.basic.maisFitness.repositories;
import com.basic.maisFitness.domain.Product;

import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product,Long> {

}
