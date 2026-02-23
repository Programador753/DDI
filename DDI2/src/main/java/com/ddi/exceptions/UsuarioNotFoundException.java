package com.ddi.exceptions;

/**
 * Class that represents the exception thrown when a Usuario is not found.
 *
 * @author Antonio
 */
public class UsuarioNotFoundException extends Exception {

    /**
     * Pre: msg not null.
     * Post: creates the exception with the given message.
     */
    public UsuarioNotFoundException(String msg) {
        super(msg);
    }
}