package com.example.demo.Exceptions;


public class ResourceNotFoundException extends RuntimeException {

    public ResourceNotFoundException(final String message)
    {
        super(message);
    }

}
