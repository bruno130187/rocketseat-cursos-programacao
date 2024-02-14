package br.com.bruno.cursoprogramacao.exceptions;

public class CursoNotFoundException extends RuntimeException{
    public CursoNotFoundException() {
        super("Curso não encontrado.");
    }
}
