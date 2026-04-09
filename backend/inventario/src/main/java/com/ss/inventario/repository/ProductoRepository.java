package com.ss.inventario.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.ss.inventario.model.Producto;

public interface ProductoRepository extends JpaRepository<Producto, Integer> {

}