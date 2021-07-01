package com.basic.maisFitness.services;


import com.basic.maisFitness.domain.Client;
import com.basic.maisFitness.mapper.ClientMappers;
import com.basic.maisFitness.repositories.ClientRepository;
import com.basic.maisFitness.requests.ClientPostRequestBody;
import com.basic.maisFitness.requests.ClientPutRequestBody;
import com.basic.maisFitness.services.exceptions.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.validation.Valid;
import java.util.List;

@Service
public class ClientService {

@Autowired
    private ClientRepository clientRepository;

    @Transactional
    public Client save(ClientPostRequestBody clientPostRequestBody) {
        return clientRepository.save(ClientMappers.INSTANCE.toClient(clientPostRequestBody));
    }

    public Client findById(long id){
        return clientRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("cliente", id));
    }

    public List<Client> findAll(){
        return clientRepository.findAll();

    }
    @Transactional
    public void delete(Long id) {

        Client client = findById(id);
        try{
            clientRepository.delete(client);
        }catch(EmptyResultDataAccessException emptyResultDataAccessException){
            throw new ResourceNotFoundException("cliente", id);
        }

    }

    @Transactional // VER EXCEPTION DEPOIS
    public Client replace(ClientPutRequestBody clientPutRequestBody) {
        Client client = ClientMappers.INSTANCE.toClient(clientPutRequestBody);
        delete(client.getId());
        return clientRepository.save(client);
    }
}
