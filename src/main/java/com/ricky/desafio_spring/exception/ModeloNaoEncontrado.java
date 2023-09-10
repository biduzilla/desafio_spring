package com.ricky.desafio_spring.exception;

public class ModeloNaoEncontrado extends RuntimeException{
    public ModeloNaoEncontrado(){
        super("Modelo não encontrado");
    }
}
