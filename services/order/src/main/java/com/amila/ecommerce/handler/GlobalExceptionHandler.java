package com.amila.ecommerce.handler;

import com.amila.ecommerce.exception.BusinessException;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.HashMap;

import static org.springframework.http.HttpStatus.BAD_REQUEST;

@RestControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(BusinessException.class)
    public ResponseEntity<String> handler(BusinessException exp){
        return ResponseEntity
                .status(BAD_REQUEST)
                .body(exp.getMsg());
    }

    @ExceptionHandler(EntityNotFoundException.class)
    public ResponseEntity<String> handler(EntityNotFoundException exp){
        return ResponseEntity
                .status(BAD_REQUEST)
                .body(exp.getMessage());
    }



    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ErrorResponse> handler(MethodArgumentNotValidException exp){
        var erros = new HashMap<String, String>();
        exp.getBindingResult().getAllErrors()
                .forEach(error->{
                    var fieldname = ((FieldError)error).getField();
                    var errorMessage = error.getDefaultMessage();
                    erros.put(fieldname , errorMessage);
                } );
        return ResponseEntity
                .status(BAD_REQUEST)
                .body(new ErrorResponse(erros));
    }
}
