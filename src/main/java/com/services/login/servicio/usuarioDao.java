package com.services.login.servicio;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.services.login.dao.UsuarioRepository;
import com.services.login.modelo.Usuarios;

@Service
public class usuarioDao {
@Autowired
UsuarioRepository usuarioRepository;
public Usuarios findOne(String username) {
	return usuarioRepository.findOne(username);
}

}
