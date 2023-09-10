package com.ricky.desafio_spring.exception;

public class MarcaJaExiste extends RuntimeException{
    public MarcaJaExiste(){
        super("Marca já existe");
    }
}
