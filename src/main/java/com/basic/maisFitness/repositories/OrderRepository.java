package com.basic.maisFitness.repositories;

import com.basic.maisFitness.domain.Order;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;


public interface OrderRepository extends JpaRepository<Order,Long> {

    List<Order> findByRegistrationDateBetween(LocalDateTime start, LocalDateTime end);
}
