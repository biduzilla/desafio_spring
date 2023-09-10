package com.ricky.desafio_spring.exception;

public class ModeloJaExiste extends RuntimeException{
    public ModeloJaExiste(){
        super("Modelo já existe");
    }
}
