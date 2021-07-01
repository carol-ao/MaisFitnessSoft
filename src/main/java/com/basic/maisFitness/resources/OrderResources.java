package com.basic.maisFitness.resources;


import com.basic.maisFitness.domain.Client;
import com.basic.maisFitness.domain.Order;
import com.basic.maisFitness.mapper.OrderMappers;
import com.basic.maisFitness.requests.ClientPutRequestBody;
import com.basic.maisFitness.requests.OrderPostRequestBody;
import com.basic.maisFitness.services.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping(value = "/orders")
public class OrderResources {

    @Autowired
    OrderService orderService;
    @Autowired
    OrderMappers orderMappers;

    @GetMapping
    ResponseEntity<List<Order>> findAll(){
        return ResponseEntity.ok().body(orderService.findAll());
    }

    @GetMapping(path = "/{id}")
    ResponseEntity<Order> findById(@PathVariable Long id){
        return ResponseEntity.ok().body(orderService.findById(id));
    }

    @PostMapping
    ResponseEntity<Order> saveOrder(@RequestBody OrderPostRequestBody orderPostRequestBody){
        return new ResponseEntity<>(orderService.save(orderPostRequestBody),HttpStatus.CREATED);
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Order> delete(@PathVariable long id) {
        orderService.delete(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

//    @PutMapping
//    public ResponseEntity<Order> replace(@RequestBody @Valid OrderPutRequestBody clientOrderRequestBody) {
//        return new ResponseEntity<>(clientService.replace(orderPutRequestBody),HttpStatus.ACCEPTED);
//    }
}
