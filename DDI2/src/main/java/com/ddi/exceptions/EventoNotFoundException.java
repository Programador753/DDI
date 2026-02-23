package com.ddi.exceptions;

/**
 * Class that represents the exception thrown when an EventoDeportivo is not found.
 *
 * @author Antonio
 */
public class EventoNotFoundException extends Exception {

    /**
     * Pre: msg not null.
     * Post: creates the exception with the given message.
     */
    public EventoNotFoundException(String msg) {
        super(msg);
    }
}