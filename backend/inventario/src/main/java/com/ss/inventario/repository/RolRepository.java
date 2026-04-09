package com.ss.inventario.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.ss.inventario.model.Rol;

public interface RolRepository extends JpaRepository<Rol, Integer> {

}