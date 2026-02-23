package com.ddi.requestObjects;

/**
 * Class that contains the login request credentials.
 *
 * @author Antonio
 */
public class AuthRequest {

    /**
     * Email of the user.
     */
    private String correoElectronico;

    /**
     * Password of the user.
     */
    private String password;

    public AuthRequest() {}

    public AuthRequest(String correoElectronico, String password) {
        this.correoElectronico = correoElectronico;
        this.password = password;
    }

    /**
     * Pre: -
     * Post: returns the email of the request.
     */
    public String getCorreoElectronico() {
        return this.correoElectronico;
    }

    /**
     * Pre: correoElectronico not null.
     * Post: the email of the request is updated.
     */
    public void setCorreoElectronico(String correoElectronico) {
        this.correoElectronico = correoElectronico;
    }

    /**
     * Pre: -
     * Post: returns the password of the request.
     */
    public String getPassword() {
        return this.password;
    }

    /**
     * Pre: password not null.
     * Post: the password of the request is updated.
     */
    public void setPassword(String password) {
        this.password = password;
    }
}