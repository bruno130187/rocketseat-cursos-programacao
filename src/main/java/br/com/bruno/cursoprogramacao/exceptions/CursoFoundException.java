package br.com.bruno.cursoprogramacao.exceptions;

public class CursoFoundException extends RuntimeException{
    public CursoFoundException() {
        super("Curso já existe.");
    }
}
