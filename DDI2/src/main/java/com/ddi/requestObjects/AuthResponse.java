package com.ddi.requestObjects;

/**
 * Class that contains the login response.
 *
 * @author Antonio
 */
public class AuthResponse {

    /**
     * JWT token generated.
     */
    private String token;

    public AuthResponse() {}

    public AuthResponse(String token) {
        this.token = token;
    }

    /**
     * Pre: -
     * Post: returns the JWT token of the response.
     */
    public String getToken() {
        return this.token;
    }

    /**
     * Pre: token not null.
     * Post: the JWT token of the response is updated.
     */
    public void setToken(String token) {
        this.token = token;
    }
}