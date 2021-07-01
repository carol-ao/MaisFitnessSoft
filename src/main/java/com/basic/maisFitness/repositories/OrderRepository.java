package com.basic.maisFitness.repositories;

import com.basic.maisFitness.domain.Order;
import org.springframework.data.jpa.repository.JpaRepository;


public interface OrderRepository extends JpaRepository<Order,Long> {
}
