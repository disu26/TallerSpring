package com.crud.democrud.models;

import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.*;

@Entity
@Table(name = "usuario_rol")
public final class UsuarioRolModel {

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

    public UsuarioRolModel(Long id, String rol) {
        this.id = id;
        this.rol = rol;
    }

    public UsuarioRolModel() {
    }


}
