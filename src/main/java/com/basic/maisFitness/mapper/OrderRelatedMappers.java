package com.basic.maisFitness.mapper;

import com.basic.maisFitness.domain.Client;
import com.basic.maisFitness.domain.Order;
import com.basic.maisFitness.domain.OrderItem;
import com.basic.maisFitness.domain.Product;
import com.basic.maisFitness.repositories.OrderItemRepository;
import com.basic.maisFitness.repositories.OrderRepository;
import com.basic.maisFitness.repositories.ProductRepository;
import com.basic.maisFitness.requests.OrderItemPostRequestBody;
import com.basic.maisFitness.requests.OrderPostRequestBody;
import com.basic.maisFitness.requests.ProductPostRequestBody;
import com.basic.maisFitness.services.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

import static org.springframework.data.domain.ExampleMatcher.GenericPropertyMatchers.ignoreCase;

@Service
public class OrderRelatedMappers {

    @Autowired
    ClientService clientService;
    @Autowired
    ProductRepository productRepository;
    @Autowired
    OrderRepository orderRepository;
    @Autowired
    OrderItemRepository orderItemRepository;

    public Product toProduct(ProductPostRequestBody productPostRequestBody){
        Product noIdProduct= Product.builder().brand(productPostRequestBody.getBrand())
                .color(productPostRequestBody.getColor())
                .size(productPostRequestBody.getSize()).build();
        // building ExampleMatcher to check if product exists in DB
        ExampleMatcher productMatcher = ExampleMatcher.matching()
                .withIgnorePaths("id")
                .withMatcher("type",ignoreCase())
                .withMatcher("color", ignoreCase())
                .withMatcher("brand",ignoreCase());
        Example<Product> registeredProduct = Example.of(noIdProduct, productMatcher);
        boolean exists = productRepository.exists(registeredProduct);
        Product product;
        if(!exists) { // in case product isnt in DB :
            product = productRepository.save(noIdProduct); // save it in DB and get an id
        }
        else{ // in case it is already in DB
            product = productRepository.findOne(registeredProduct).get(); //get product with id
        }
        return product;
    }

    public Order toOrder(OrderPostRequestBody orderPostRequestBody){
        Client client = clientService.findById(orderPostRequestBody.getClientId());

        // save order
        Order order = orderRepository.save(Order.builder().client(client)
                .paymentMethod(orderPostRequestBody.getPaymentMethod())
                .value(orderPostRequestBody.getValue()).build());

        // piece together orderItems
        Set<OrderItemPostRequestBody> orderItemPostRequestBodySet = orderPostRequestBody.getOrderItems();
        Set<OrderItem> orderItems = new HashSet<>();
        for(OrderItemPostRequestBody item : orderItemPostRequestBodySet){
            Product product = toProduct(item.getProduct());
            orderItems.add(new OrderItem(order, product, item.getQuantity()));
        }
        // save orderItems
        for( OrderItem orderItem : orderItems){
            orderItemRepository.save(orderItem);
        }
        // return order with all order items
        return Order.builder().client(client)
                .paymentMethod(orderPostRequestBody.getPaymentMethod())
                .value(orderPostRequestBody.getValue())
                .orderItems(orderItems)
                .build();
    };
}
