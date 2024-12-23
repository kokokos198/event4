package com.example.demo.web.controller;

import com.example.demo.Exceptions.ExceptionProg;
import com.example.demo.Exceptions.ResourceNotFoundException;
import jakarta.validation.ConstraintViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.List;
import java.util.stream.Collectors;

@RestControllerAdvice
public class ControllerAdvice {

    @ExceptionHandler(ResourceNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
public ExceptionProg resourcenotfound_exception(final ResourceNotFoundException e)
    {
        return new ExceptionProg(e.getMessage());
    }

 @ExceptionHandler(IllegalStateException.class)
 @ResponseStatus(HttpStatus.BAD_REQUEST)
 public ExceptionProg illegal_exception(final IllegalStateException e)
 {
     return new ExceptionProg(e.getMessage());
 }

 @ExceptionHandler(MethodArgumentNotValidException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ExceptionProg illegalvalid_exception(final MethodArgumentNotValidException e)
 {
     ExceptionProg exceptionProg = new ExceptionProg("Validation Error");
     List<FieldError> errors = e.getBindingResult().getFieldErrors();
     exceptionProg.setErrors(errors.stream().collect(Collectors.toMap(FieldError :: getField, FieldError :: getDefaultMessage, (mes1, mes2) -> mes1 + " " + mes2)));

return exceptionProg;
 }

@ExceptionHandler(ConstraintViolationException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ExceptionProg constval_exception(final ConstraintViolationException e)
{
    ExceptionProg exceptionProg = new ExceptionProg("Validation Error");
    exceptionProg.setErrors(e.getConstraintViolations().stream().
            collect(Collectors.toMap(val -> val.getPropertyPath().toString(),val -> val.getMessage())));
    return exceptionProg;
}

@ExceptionHandler(Exception.class)
@ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
public ExceptionProg exp(Exception e)
{
    return new ExceptionProg(e.getMessage());
}

}
