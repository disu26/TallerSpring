package com.crud.democrud.repositories;

import com.crud.democrud.models.UsuarioRolModel;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 * Repositorio para la tabla usuarioRol
 *
 * @author Dímar Andrey Suárez Hidalgo <dimar260212@gmail.com>
 */
@Repository
public interface UsuarioRolRepository extends CrudRepository<UsuarioRolModel, Long> {
}
