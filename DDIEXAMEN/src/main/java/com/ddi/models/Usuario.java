package com.ddi.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Objects;

/**
 * Class that contains a Usuario.
 *
 * @author Antonio
 */
@Entity
@Table(name = "usuarios")
@JsonIgnoreProperties({ "authorities", "accountNonLocked", "credentialsNonExpired", "accountNonExpired", "enabled", "username" })
public class Usuario implements UserDetails {

    /**
     * Id of the usuario.
     */
    private @Id @GeneratedValue(strategy = GenerationType.IDENTITY) Long id;

    /**
     * Name of the usuario.
     */
    private @Column(nullable = false) String nombre;

    /**
     * Email of the usuario.
     */
    private @Column(nullable = false, unique = true) String correoElectronico;

    /**
     * Password of the usuario.
     */
    private @Column(nullable = false) String password;

    /**
     * Role of the usuario.
     */
    private @Enumerated(EnumType.STRING) @Column(nullable = false) Role role;

    public Usuario() {}

    public Usuario(String nombre, String correoElectronico, String password, Role role) {
        this.nombre = nombre;
        this.correoElectronico = correoElectronico;
        this.password = password;
        this.role = role;
    }

    /**
     * Pre: -
     * Post: returns the id of the usuario.
     */
    public Long getId() {
        return this.id;
    }

    /**
     * Pre: id not null.
     * Post: the id of the usuario is updated.
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * Pre: -
     * Post: returns the name of the usuario.
     */
    public String getNombre() {
        return this.nombre;
    }

    /**
     * Pre: nombre not null.
     * Post: the name of the usuario is updated.
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * Pre: -
     * Post: returns the email of the usuario.
     */
    public String getCorreoElectronico() {
        return this.correoElectronico;
    }

    /**
     * Pre: correoElectronico not null.
     * Post: the email of the usuario is updated.
     */
    public void setCorreoElectronico(String correoElectronico) {
        this.correoElectronico = correoElectronico;
    }

    /**
     * Pre: -
     * Post: returns the password of the usuario.
     */
    public String getPassword() {
        return this.password;
    }

    /**
     * Pre: password not null.
     * Post: the password of the usuario is updated.
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * Pre: -
     * Post: returns the role of the usuario.
     */
    public Role getRole() {
        return this.role;
    }

    /**
     * Pre: role not null.
     * Post: the role of the usuario is updated.
     */
    public void setRole(Role role) {
        this.role = role;
    }

    /**
     * Pre: -
     * Post: returns the list of authorities of the usuario.
     */
    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return List.of(new SimpleGrantedAuthority(role.name()));
    }

    /**
     * Pre: -
     * Post: returns the username (email) of the usuario.
     */
    @Override
    public String getUsername() {
        return this.correoElectronico;
    }

    /**
     * Pre: -
     * Post: returns true if the account is not expired.
     */
    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    /**
     * Pre: -
     * Post: returns true if the account is not locked.
     */
    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    /**
     * Pre: -
     * Post: returns true if the credentials are not expired.
     */
    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    /**
     * Pre: -
     * Post: returns true if the account is enabled.
     */
    @Override
    public boolean isEnabled() {
        return true;
    }

    /**
     * Pre: o is an Object.
     * Post: returns true if both usuarios have the same id and email.
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Usuario)) return false;
        Usuario usuario = (Usuario) o;
        return Objects.equals(this.id, usuario.id) && Objects.equals(this.correoElectronico, usuario.correoElectronico);
    }

    /**
     * Pre: -
     * Post: returns the hash code of the usuario.
     */
    @Override
    public int hashCode() {
        return Objects.hash(this.id, this.correoElectronico);
    }

    /**
     * Pre: -
     * Post: returns a string representation of the usuario.
     */
    @Override
    public String toString() {
        return "Usuario{" + "id=" + this.id + ", nombre='" + this.nombre + '\'' + ", role='" + this.role + '\'' + '}';
    }
}