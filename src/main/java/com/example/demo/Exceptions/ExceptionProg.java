package com.example.demo.Exceptions;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import java.util.Map;

@Getter
@Setter
@AllArgsConstructor
public class ExceptionProg {

    private String message;
    private Map<String, String> errors;

    public ExceptionProg(final String message)
    {
        this.message = message;
    }

}
