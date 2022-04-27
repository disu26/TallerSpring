package com.crud.democrud.services;

import com.crud.democrud.models.UsuarioModel;
import com.crud.democrud.models.UsuarioRolModel;
import com.crud.democrud.repositories.UsuarioRepository;
import com.crud.democrud.repositories.UsuarioRolRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public final class UsuarioRolService {
    @Autowired
    UsuarioRolRepository usuarioRolRepository;

    public List<UsuarioRolModel> obtenerRoles(){
        return (List<UsuarioRolModel>) usuarioRolRepository.findAll();
    }

    public UsuarioRolModel guardarRol(UsuarioRolModel usuarioRolModel){
        return usuarioRolRepository.save(usuarioRolModel);
    }

    public Optional<UsuarioRolModel> obtenerPorId(Long id){
        return usuarioRolRepository.findById(id);
    }

    public UsuarioRolModel eliminar(Long id){
        var usuarioRolModel = usuarioRolRepository.findById(id);
        if(usuarioRolModel.isPresent()){
            usuarioRolRepository.delete(usuarioRolModel.get());
            return usuarioRolModel.get();
        }
        return null;
    }

    public UsuarioRolModel actualizarRol(Long id, UsuarioRolModel rol){
        rol.setId(id);
        return usuarioRolRepository.save(rol);
    }

}
