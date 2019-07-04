package com.services.login.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.services.login.modelo.Usuarios;
@Repository
public interface UsuarioRepository extends JpaRepository<Usuarios, String>{
   
}
