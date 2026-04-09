package com.ss.inventario.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.ss.inventario.model.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, Integer> {

}