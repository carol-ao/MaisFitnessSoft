package com.basic.maisFitness.services;

import com.basic.maisFitness.domain.Client;
import com.basic.maisFitness.domain.WantedItem;
import com.basic.maisFitness.mapper.Mappers;
import com.basic.maisFitness.repositories.WantedItemRepository;
import com.basic.maisFitness.requests.WantedItemPostRequestBody;
import com.basic.maisFitness.services.exceptions.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class WantedItemService {

    @Autowired
    WantedItemRepository wantedItemRepository;

    @Autowired
    ClientService clientService;

    @Autowired
    Mappers mappers;

    public List<WantedItem> findAll(){
        return wantedItemRepository.findAll();
    }

    public WantedItem findById(long id){
        return wantedItemRepository.findById(id).orElseThrow(()-> new ResourceNotFoundException("wanted item",id));
    }

    public List<WantedItem> findByClient(long clientId){
        Client client = clientService.findById(clientId);
        return wantedItemRepository.findByClient(client);
    }

    public WantedItem save(WantedItemPostRequestBody wantedItemPostRequestBody){
        WantedItem wantedItem = mappers.toWantedItem(wantedItemPostRequestBody);
        return wantedItemRepository.save(wantedItem);
    }

    public void deleteById(long id){
        WantedItem wantedItem = findById(id);
        wantedItemRepository.delete(wantedItem);
    }

    public void deleteByClient(long clientId){
        List<WantedItem> wantedItemList = findByClient(clientId);
        for(WantedItem wi : wantedItemList){
            wantedItemRepository.delete(wi);
        }
    }
}
