package br.com.vininiceto.exceptions;

public class UserFoundException extends RuntimeException {
    public UserFoundException() {

        super("Usuario já existe!");
    }
}
