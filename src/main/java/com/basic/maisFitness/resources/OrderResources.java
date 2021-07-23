package com.basic.maisFitness.resources;


import com.basic.maisFitness.domain.Order;
import com.basic.maisFitness.mapper.Mappers;
import com.basic.maisFitness.requests.OrderPostRequestBody;
import com.basic.maisFitness.services.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping(value = "/orders")
public class OrderResources {

    @Autowired
    OrderService orderService;
    @Autowired // mudar para colocar IoC pelo construtor
    Mappers mappers;

    @GetMapping
    ResponseEntity<Page<Order>> findAll(Pageable pageable){
        return ResponseEntity.ok().body(orderService.findAll(pageable));
    }

    @GetMapping(path = "/{id}")
    ResponseEntity<Order> findById(@PathVariable Long id){
        return ResponseEntity.ok().body(orderService.findById(id));
    }

    @GetMapping(path = "/find")
    ResponseEntity<List<Order>> findByDate( @RequestParam @DateTimeFormat(pattern = "dd.MM.yyyy") LocalDate registrationDate){
        return ResponseEntity.ok().body(orderService.findByDate(registrationDate));
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

}
