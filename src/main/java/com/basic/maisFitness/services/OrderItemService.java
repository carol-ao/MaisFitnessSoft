package com.basic.maisFitness.services;

import com.basic.maisFitness.domain.OrderItem;
import com.basic.maisFitness.repositories.OrderItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
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

    //public  OrderItem findById()
    // delete
    //TODO
}
