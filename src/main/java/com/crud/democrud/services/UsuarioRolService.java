package com.crud.democrud.services;

import com.crud.democrud.models.UsuarioRolModel;
import com.crud.democrud.repositories.UsuarioRolRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/**
 * Servicios para la entidad usuarioRol
 *
 * @author Dímar Andrey Suárez Hidalgo <dimar260212@gmail.com>
 */
@Service
public class UsuarioRolService {
    @Autowired
    UsuarioRolRepository usuarioRolRepository;

    /**
     * Método para obtener los roles.
     *
     * @return List<UsuarioRolModel> que contiene todos los roles creados.
     *
     * @author Dímar Andrey Suárez Hidalgo <dimar260212@gmail.com>
     */
    public List<UsuarioRolModel> obtenerRoles(){
        return (List<UsuarioRolModel>) usuarioRolRepository.findAll();
    }

    /**
     * Método para guardar un rol.
     *
     * @param usuarioRolModel objeto que se desea guardar en la base de datos.
     * @return Objeto de tipo UsuarioRolModel con la información de lo que fue guardado.
     *
     * @author Dímar Andrey Suárez Hidalgo <dimar260212@gmail.com>
     */
    public UsuarioRolModel guardarRol(UsuarioRolModel usuarioRolModel){
        return usuarioRolRepository.save(usuarioRolModel);
    }

    /**
     * Método para obtener un rol por el id.
     *
     * @param id del rol a buscar
     * @return Optional<UsuarioRolModel> que puede devolver un objeto o un null dependiendo de si lo encuentra
     * o no
     *
     * @author Dímar Andrey Suárez Hidalgo <dimar260212@gmail.com>
     */
    public Optional<UsuarioRolModel> obtenerPorId(Long id){
        return usuarioRolRepository.findById(id);
    }

    /**
     * Método para eliminar un rol por su id.
     *
     * @param id del rol a eliminar
     * @return UsuarioRolModel si lo encuentra y lo elimina y null si no lo encuentra
     *
     * @author Dímar Andrey Suárez Hidalgo <dimar260212@gmail.com>
     */
    public UsuarioRolModel eliminar(Long id){
        var usuarioRolModel = usuarioRolRepository.findById(id);
        if(usuarioRolModel.isPresent()){
            usuarioRolRepository.delete(usuarioRolModel.get());
            return usuarioRolModel.get();
        }
        return null;
    }

    /**
     * Método para actualizar un rol.
     *
     * @param id del rol que se va a modificar
     * @param rol con la información que se va a modificar
     * @return UsuarioRolModel con la información actualizada
     *
     * @author Dímar Andrey Suárez Hidalgo <dimar260212@gmail.com>
     */
    public UsuarioRolModel actualizarRol(Long id, UsuarioRolModel rol){
        rol.setId(id);
        return usuarioRolRepository.save(rol);
    }

}
