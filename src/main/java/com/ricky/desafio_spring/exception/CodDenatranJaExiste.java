package com.ricky.desafio_spring.exception;

public class CodDenatranJaExiste extends RuntimeException{
    public CodDenatranJaExiste(){
        super("Código Denatran já cadastrado");
    }
}
