package com.ddi.requestObjects;

import com.ddi.models.Reserva;

/**
 * Class that contains the request object to create a Reserva.
 *
 * @author Antonio
 */
public class RequestReserva {

    /**
     * Reserva to be created.
     */
    private Reserva reserva;

    /**
     * Id of the instalacion associated with the reserva.
     */
    private Long instalacionId;

    public RequestReserva() {}

    public RequestReserva(Reserva reserva, Long instalacionId) {
        this.reserva = reserva;
        this.instalacionId = instalacionId;
    }

    /**
     * Pre: -
     * Post: returns the reserva of the request.
     */
    public Reserva getReserva() {
        return this.reserva;
    }

    /**
     * Pre: reserva not null.
     * Post: the reserva of the request is updated.
     */
    public void setReserva(Reserva reserva) {
        this.reserva = reserva;
    }

    /**
     * Pre: -
     * Post: returns the instalacion id of the request.
     */
    public Long getInstalacionId() {
        return this.instalacionId;
    }

    /**
     * Pre: instalacionId not null.
     * Post: the instalacion id of the request is updated.
     */
    public void setInstalacionId(Long instalacionId) {
        this.instalacionId = instalacionId;
    }
}