package com.basic.maisFitness.mapper;

import com.basic.maisFitness.domain.Client;
import com.basic.maisFitness.domain.Order;
import com.basic.maisFitness.requests.OrderPostRequestBody;
import com.basic.maisFitness.services.ClientService;
import com.basic.maisFitness.services.OrderService;
import org.mapstruct.factory.Mappers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrderMappers {

    @Autowired
   ClientService clientService;

    public Order toOrder(OrderPostRequestBody orderPostRequestBody){
        Client client = clientService.findById(orderPostRequestBody.getClientId());
        return Order.builder().client(client)
                .paymentMethod(orderPostRequestBody.getPaymentMethod())
                .value(orderPostRequestBody.getValue()).build();
    };
}
