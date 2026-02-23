package com.ddi.exceptions;

/**
 * Class that represents the exception thrown when a Reserva is not found.
 *
 * @author Antonio
 */
public class ReservaNotFoundException extends Exception {

    /**
     * Pre: msg not null.
     * Post: creates the exception with the given message.
     */
    public ReservaNotFoundException(String msg) {
        super(msg);
    }
}