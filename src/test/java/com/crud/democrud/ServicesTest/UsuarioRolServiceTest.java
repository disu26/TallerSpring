package com.crud.democrud.ServicesTest;

import com.crud.democrud.models.UsuarioModel;
import com.crud.democrud.models.UsuarioRolModel;
import com.crud.democrud.repositories.UsuarioRolRepository;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@DataJpaTest
@AutoConfigureTestDatabase(replace= AutoConfigureTestDatabase.Replace.NONE)
public class UsuarioRolServiceTest {
    @Autowired
    UsuarioRolRepository usuarioRolRepository;

    @Test
    public void testGuardarRol(){
        UsuarioModel usuarioModel=new UsuarioModel("juancho","juancho@gmail.com",3);
        UsuarioRolModel rol = new UsuarioRolModel("Profesor", usuarioModel);
        UsuarioRolModel rolRegistrado = usuarioRolRepository.save(rol);
        assertNotNull(rolRegistrado);
    }

    @Test
    public void testBuscarUsuarioRolPorId(){
        Long idBuscado=1L;
        Optional<UsuarioRolModel> rolBuscado = usuarioRolRepository.findById(idBuscado);
        assertThat(rolBuscado.get().getId()).isEqualTo(idBuscado);
    }

    @Test
    public void testListarUsuarios(){
        List<UsuarioRolModel> usuarioRolModelList = (List<UsuarioRolModel>) usuarioRolRepository.findAll();
        assertThat(usuarioRolModelList).size().isPositive();
    }
}
