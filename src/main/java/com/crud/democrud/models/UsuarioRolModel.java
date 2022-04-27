package com.crud.democrud.models;

import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Id;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Column;
import javax.persistence.ManyToOne;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;

/**
 * Modelo de la tabla usuario_rol.
 *
 * @author Dímar Andrey Suárez Hidalgo <dimar260212@gmail.com>
 */
@Entity
@Table(name = "usuario_rol")
public class UsuarioRolModel {

    /**
     * Clave principal de la tabla, este es autoincrementable.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(unique = true, nullable = false)
    private Long id;

    /**
     * Punto de enlace entre la entidad Usuario y Usuario_rol (un usuario puede tener uno o varios roles)
     */
    @ManyToOne(
            fetch = FetchType.LAZY,
            targetEntity = UsuarioModel.class,
            optional = false
    )
    @JoinColumn(name = "usurol_usuario_id", nullable = false)
    @JsonBackReference
    private UsuarioModel usuario;

    private String rol;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getRol() {
        return rol;
    }

    public void setRol(String rol) {
        this.rol = rol;
    }

    public UsuarioRolModel(String rol, UsuarioModel usuario) {
        this.rol = rol;
        this.usuario = usuario;
    }

    public UsuarioRolModel() {
    }


}
