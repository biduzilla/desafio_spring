package com.ricky.desafio_spring.exception;

public class MarcaNaoEncontrada extends RuntimeException{
    public MarcaNaoEncontrada(){
        super("Marca não encontrada");
    }
}
