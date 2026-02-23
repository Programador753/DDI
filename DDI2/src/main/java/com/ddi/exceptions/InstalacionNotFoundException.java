package com.ddi.exceptions;

/**
 * Class that represents the exception thrown when an InstalacionDeportiva is not found.
 *
 * @author Antonio
 */
public class InstalacionNotFoundException extends Exception {

    /**
     * Pre: msg not null.
     * Post: creates the exception with the given message.
     */
    public InstalacionNotFoundException(String msg) {
        super(msg);
    }
}