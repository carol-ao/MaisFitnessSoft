package com.basic.maisFitness.services;

import com.basic.maisFitness.domain.Order;
import com.basic.maisFitness.mapper.OrderMappers;
import com.basic.maisFitness.repositories.OrderRepository;
import com.basic.maisFitness.requests.OrderPostRequestBody;
import com.basic.maisFitness.services.exceptions.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class OrderService {

    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private OrderMappers orderMappers;

    @Transactional
    public Order save(OrderPostRequestBody orderPostRequestBody) {
        return orderRepository.save(orderMappers.toOrder(orderPostRequestBody));
    }

    public Order findById(long id){
        return orderRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("venda", id));
    }

    public List<Order> findAll(){
        return orderRepository.findAll();

    }
    @Transactional
    public void delete(Long id) {

        Order order = findById(id);
        try{
            orderRepository.delete(order);
        }catch(EmptyResultDataAccessException emptyResultDataAccessException){
            throw new ResourceNotFoundException("venda", id);
        }

    }

    /*
    @Transactional // VER EXCEPTION DEPOIS
    public Order replace(OrderPutRequestBody OrderPutRequestBody) {
        Order Order = OrderMappers.INSTANCE.toOrder(OrderPutRequestBody);
        delete(Order.getId());
        return OrderRepository.save(Order);
    }

     */
}
