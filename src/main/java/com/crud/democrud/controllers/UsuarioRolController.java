package com.crud.democrud.controllers;

import com.crud.democrud.models.UsuarioRolModel;
import com.crud.democrud.services.UsuarioRolService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/usuarioRol")
public class UsuarioRolController {
    @Autowired
    UsuarioRolService usuarioRolService;

    @GetMapping()
    public List<UsuarioRolModel> obtenerRoles(){
        return usuarioRolService.obtenerRoles();
    }

    @PostMapping()
    public UsuarioRolModel guardarRol(@RequestBody UsuarioRolModel rol){
        return usuarioRolService.guardarRol(rol);
    }

    @GetMapping(path = "/{id}")
    public UsuarioRolModel obtenerRolPorId(@PathVariable("id") Long id){
        var rol = usuarioRolService.obtenerPorId(id);
        if(rol.isPresent()){
            return rol.get();
        }
        return null;
    }

    @PutMapping(path = "/{id}")
    public UsuarioRolModel actualizarRol(@PathVariable("id") Long id, @RequestBody UsuarioRolModel rol){
        return usuarioRolService.actualizarRol(id, rol);
    }

    @DeleteMapping(path = "/{id}")
    public  String eliminarRol(@PathVariable("id") Long id){
        if (usuarioRolService.eliminar(id) != null){
            return "Rol eliminado exitosamente";
        }
        return "Rol no encontrado";
    }

}
