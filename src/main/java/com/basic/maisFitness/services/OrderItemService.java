package com.basic.maisFitness.services;

import com.basic.maisFitness.domain.OrderItem;
import com.basic.maisFitness.repositories.OrderItemRepository;
import com.basic.maisFitness.services.exceptions.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class OrderItemService {

    @Autowired
    OrderItemRepository repository;

    @Transactional
    public OrderItem save(OrderItem orderItem){
        return repository.save(orderItem);
    }


    public void delete(OrderItem orderItem) {
        repository.delete(orderItem);
    }
}
