package com.crud.democrud.controllers;

import com.crud.democrud.models.UsuarioRolModel;
import com.crud.democrud.services.UsuarioRolService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Controlador de la tabla usuarioRol con sus diferentes endpoints.
 *
 * @author Dímar Andrey Suárez Hidalgo <dimar260212@gmail.com>
 */
@CrossOrigin
@RestController
@RequestMapping("/usuarioRol")
public class UsuarioRolController {
    @Autowired
    UsuarioRolService usuarioRolService;

    /**
     * Método para obtener roles.
     *
     * @return List<UsuarioRolModel> con los roles que encuentre en la bd.
     *
     * @author Dímar Andrey Suárez Hidalgo <dimar260212@gmail.com>
     */
    @GetMapping()
    public List<UsuarioRolModel> obtenerRoles(){
        return usuarioRolService.obtenerRoles();
    }

    /**
     * Método para guardar un rol.
     *
     * @param rol con la información que se desea guardar.
     * @return UsuarioRolModel con la información que ha sido guardada.
     *
     * @author Dímar Andrey Suárez Hidalgo <dimar260212@gmail.com>
     */
    @PostMapping()
    public UsuarioRolModel guardarRol(@RequestBody UsuarioRolModel rol){
        return usuarioRolService.guardarRol(rol);
    }

    /**
     * Método para obtener un rol por su id.
     *
     * @param id del rol a buscar.
     * @return UsuarioRolModel con el rol buscado, si se retorna un null es porque no lo encontró.
     *
     * @author Dímar Andrey Suárez Hidalgo <dimar260212@gmail.com>
     */
    @GetMapping(path = "/{id}")
    public UsuarioRolModel obtenerRolPorId(@PathVariable("id") Long id){
        var rol = usuarioRolService.obtenerPorId(id);
        if(rol.isPresent()){
            return rol.get();
        }
        return null;
    }

    /**
     * Método para una actualización total del rol.
     *
     * @param id del rol a actualizar
     * @param rol con la nueva información del rol
     * @return UsuarioRolModel con la información que ha sido modificada
     *
     * @author Dímar Andrey Suárez Hidalgo <dimar260212@gmail.com>
     */
    @PutMapping(path = "/{id}")
    public UsuarioRolModel actualizarRol(@PathVariable("id") Long id, @RequestBody UsuarioRolModel rol){
        return usuarioRolService.actualizarRol(id, rol);
    }

    /**
     * Método para eliminar un rol.
     *
     * @param id del rol que se desea eliminar
     * @return String con un mensaje que indica si fue exitoso o no la eliminación.
     *
     * @author Dímar Andrey Suárez Hidalgo <dimar260212@gmail.com>
     */
    @DeleteMapping(path = "/{id}")
    public  String eliminarRol(@PathVariable("id") Long id){
        if (usuarioRolService.eliminar(id) != null){
            return "Rol eliminado exitosamente";
        }
        return "Rol no encontrado";
    }

}
