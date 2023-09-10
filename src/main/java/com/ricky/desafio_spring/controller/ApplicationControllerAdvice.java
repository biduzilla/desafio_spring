package com.ricky.desafio_spring.controller;

import com.ricky.desafio_spring.error.ApiError;
import com.ricky.desafio_spring.exception.MarcaJaExiste;
import com.ricky.desafio_spring.exception.MarcaNaoEncontrada;
import org.springframework.context.support.DefaultMessageSourceResolvable;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.List;
import java.util.stream.Collectors;

@RestControllerAdvice
public class ApplicationControllerAdvice {

    @ExceptionHandler(MarcaJaExiste.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ApiError handleEmailJaCadastrado(MarcaJaExiste ex) {
        return new ApiError(ex.getMessage());
    }

    @ExceptionHandler(MarcaNaoEncontrada.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ApiError handleMarcaNaoEncontrada(MarcaNaoEncontrada ex) {
        return new ApiError(ex.getMessage());
    }

    @ExceptionHandler
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ApiError handleMethodNotValidException(MethodArgumentNotValidException ex) {
        List<String> erros = ex.getBindingResult().getAllErrors()
                .stream()
                .map(DefaultMessageSourceResolvable::getDefaultMessage).collect(Collectors.toList());

        return new ApiError(erros);
    }
}
