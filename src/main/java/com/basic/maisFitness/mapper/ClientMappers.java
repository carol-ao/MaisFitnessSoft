package com.basic.maisFitness.mapper;

import com.basic.maisFitness.domain.Client;
import com.basic.maisFitness.requests.ClientPostRequestBody;
import com.basic.maisFitness.requests.ClientPutRequestBody;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import javax.swing.*;

@Mapper
public interface ClientMappers {

    ClientMappers INSTANCE = Mappers.getMapper(ClientMappers.class);

    Client toClient(ClientPostRequestBody clientPostRequestBody);
    Client toClient(ClientPutRequestBody clientPutRequestBody);

}
