package com.basic.maisFitness.services;

import com.basic.maisFitness.domain.Client;
import com.basic.maisFitness.domain.Order;
import com.basic.maisFitness.domain.OrderItem;
import com.basic.maisFitness.mapper.Mappers;
import com.basic.maisFitness.repositories.OrderRepository;
import com.basic.maisFitness.requests.OrderPostRequestBody;
import com.basic.maisFitness.services.exceptions.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.List;

@Service
public class OrderService {

    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private OrderItemService orderItemService;

    @Autowired
    private ClientService clientService;

    @Autowired
    private Mappers mappers;

    @Transactional
    public Order save(OrderPostRequestBody orderPostRequestBody) {
        return orderRepository.save(mappers.toOrder(orderPostRequestBody));
    }

    public Order findById(long id){
        return orderRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("venda", id));
    }

    public List<Order> findByDate(LocalDate localDate){
        LocalDateTime start = localDate.atStartOfDay();
        LocalDateTime end = localDate.atTime(LocalTime.MAX);

        return orderRepository.findByRegistrationDateBetween(start,end);
    }

    public List<Order> findByClient(Long clientId){
        Client client = clientService.findById(clientId);
        return orderRepository.findByClient(client);
    }

    public Page<Order> findAll(Pageable pageable){
        return orderRepository.findAll(pageable);

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
    public void deleteByClient(Long clientId){
        List<Order> orderList = findByClient(clientId);
        for( Order order : orderList){
            delete(order.getId());
        }
    }

}
