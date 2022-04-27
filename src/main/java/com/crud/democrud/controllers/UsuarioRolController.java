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

}
