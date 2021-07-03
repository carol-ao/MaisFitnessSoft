package com.basic.maisFitness.services;

import com.basic.maisFitness.domain.Order;
import com.basic.maisFitness.domain.OrderItem;
import com.basic.maisFitness.mapper.OrderRelatedMappers;
import com.basic.maisFitness.repositories.OrderRepository;
import com.basic.maisFitness.requests.OrderPostRequestBody;
import com.basic.maisFitness.services.exceptions.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.List;
import java.util.Set;

@Service
public class OrderService {

    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private OrderItemService orderItemService;

    @Autowired
    private OrderRelatedMappers orderRelatedMappers;

    @Transactional
    public Order save(OrderPostRequestBody orderPostRequestBody) {
        return orderRepository.save(orderRelatedMappers.toOrder(orderPostRequestBody));
    }

    public Order findById(long id){
        return orderRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("venda", id));
    }

    public List<Order> findByDate(LocalDate localDate){
        LocalDateTime start = localDate.atStartOfDay();
        LocalDateTime end = localDate.atTime(LocalTime.MAX);

        return orderRepository.findByRegistrationDateBetween(start,end);
    }

    public List<Order> findAll(){
        return orderRepository.findAll();

    }
    @Transactional
    public void delete(Long id) {

        Order order = findById(id);

        for(OrderItem orderItem : order.getOrderItems()){
            orderItemService.delete(orderItem);
        }
        try{
            orderRepository.delete(order);
        }catch(EmptyResultDataAccessException emptyResultDataAccessException){
            throw new ResourceNotFoundException("venda", id);
        }

    }

}
