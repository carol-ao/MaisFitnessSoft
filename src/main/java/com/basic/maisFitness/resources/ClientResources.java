package com.basic.maisFitness.resources;

import com.basic.maisFitness.domain.Client;
import com.basic.maisFitness.enums.PaymentMethodEnum;
import com.basic.maisFitness.enums.ProductSizeEnum;
import com.basic.maisFitness.requests.ClientPostRequestBody;
import com.basic.maisFitness.requests.ClientPutRequestBody;
import com.basic.maisFitness.services.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping(value = "/clients")
public class ClientResources {
@Autowired
    private ClientService clientService;

    @PostMapping
    public ResponseEntity<Client> save(@RequestBody ClientPostRequestBody clientPostRequestBody){
        return new ResponseEntity<>(clientService.save(clientPostRequestBody), HttpStatus.CREATED);
}

    @GetMapping
    public ResponseEntity<List<Client>> findAll() {
        return ResponseEntity.ok().body(clientService.findAll());
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<Client> findById(@PathVariable long id) {
        return ResponseEntity.ok().body(clientService.findById(id));
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Client> delete(@PathVariable long id) {
        clientService.delete(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @PutMapping
    public ResponseEntity<Client> replace(@RequestBody ClientPutRequestBody clientPutRequestBody) {
        return new ResponseEntity<>(clientService.replace(clientPutRequestBody),HttpStatus.ACCEPTED);
    }


}
