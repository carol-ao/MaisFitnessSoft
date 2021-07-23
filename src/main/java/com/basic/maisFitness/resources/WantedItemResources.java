package com.basic.maisFitness.resources;

import com.basic.maisFitness.domain.Client;
import com.basic.maisFitness.domain.WantedItem;
import com.basic.maisFitness.requests.WantedItemPostRequestBody;
import com.basic.maisFitness.services.WantedItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping(value = "/wanted-items")
public class WantedItemResources {
    @Autowired
    WantedItemService wantedItemService;

    @PostMapping
    public ResponseEntity<WantedItem> save(@RequestBody WantedItemPostRequestBody wantedItemPostRequestBody){
        return new ResponseEntity<>(wantedItemService.save(wantedItemPostRequestBody), HttpStatus.CREATED);
    }

    @GetMapping(path = "/byclient/{clientId}")
    public ResponseEntity<List<WantedItem>> findByClientId(@PathVariable long clientId ){
        return ResponseEntity.ok().body(wantedItemService.findByClient(clientId));
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Client> delete(@PathVariable long id) {
        wantedItemService.deleteById(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

}
