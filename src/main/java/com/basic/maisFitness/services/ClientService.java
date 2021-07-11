package com.basic.maisFitness.services;


import com.basic.maisFitness.domain.Client;
import com.basic.maisFitness.domain.WantedItem;
import com.basic.maisFitness.mapper.Mappers;
import com.basic.maisFitness.repositories.ClientRepository;
import com.basic.maisFitness.requests.ClientPostRequestBody;
import com.basic.maisFitness.requests.ClientPutRequestBody;
import com.basic.maisFitness.services.exceptions.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class ClientService {

@Autowired
    private ClientRepository clientRepository;
@Autowired
    private Mappers mappers;
@Autowired
    private WantedItemService wantedItemService;
@Autowired
    private OrderService orderService;

    @Transactional
    public Client save(ClientPostRequestBody clientPostRequestBody) {
        return clientRepository.save(mappers.toClient(clientPostRequestBody));
    }

    public Client findById(long id){
        return clientRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("cliente", id));
    }

    public List<Client> findAll(){
        return clientRepository.findAll();

    }
    @Transactional
    public void delete(Long id) {

        //TODO
        //orderService.deleteByClient(id);
        wantedItemService.deleteByClient(id);
        Client client = findById(id);
        try{
            clientRepository.delete(client);
        }catch(EmptyResultDataAccessException emptyResultDataAccessException){
            throw new ResourceNotFoundException("cliente", id);
        }

    }

    @Transactional
    public Client update(long id, ClientPutRequestBody clientPutRequestBody) {
        Client client = findById(id);
        client.setName(clientPutRequestBody.getName());
        client.setCpf(clientPutRequestBody.getCpf());
        client.setBust(clientPutRequestBody.getBust());
        client.setHips(clientPutRequestBody.getHips());
        return clientRepository.save(client);
    }
}
