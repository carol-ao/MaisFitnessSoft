package com.basic.maisFitness.services.exceptions;

public class ResourceNotFoundException extends RuntimeException{
    public ResourceNotFoundException(String msg, Long id) {
        super("Recurso não encontrado: " + msg + " id: "+ id );
    }
}
