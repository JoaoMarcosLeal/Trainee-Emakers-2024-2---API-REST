package com.api.br.api_emakers.infra;

import com.api.br.api_emakers.exceptions.ApiError;
import com.api.br.api_emakers.exceptions.LivroNotFoundException;
import com.api.br.api_emakers.exceptions.UserNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.time.LocalDateTime;
import java.util.List;

@RestControllerAdvice
public class RestExceptionHandler{

    @ExceptionHandler(UserNotFoundException.class)
    private ResponseEntity<ApiError> userNotFoundHandler(UserNotFoundException exception) {
        ApiError apiError = new ApiError.Builder(LocalDateTime.now(), HttpStatus.NOT_FOUND.value(),
                HttpStatus.NOT_FOUND.name(), List.of(exception.getMessage())).build();
        return new ResponseEntity<>(apiError, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ApiError> argumentNotValidException(MethodArgumentNotValidException exception) {
        List<String> errorList = exception.getBindingResult()
                .getFieldErrors()
                .stream()
                .map(error -> error.getField() + ": " + error.getDefaultMessage())
                .toList();
        ApiError apiError = new ApiError.Builder(LocalDateTime.now(), HttpStatus.BAD_REQUEST.value(),
                HttpStatus.BAD_REQUEST.name(), errorList).build();
        return new ResponseEntity<>(apiError, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(LivroNotFoundException.class)
    private ResponseEntity<ApiError> livroNotFoundHandler(LivroNotFoundException exception) {
        ApiError apiError = new ApiError.Builder(LocalDateTime.now(), HttpStatus.NOT_FOUND.value(),
                HttpStatus.NOT_FOUND.name(), List.of(exception.getMessage())).build();
        return new ResponseEntity<>(apiError, HttpStatus.NOT_FOUND);
    }
}
    

