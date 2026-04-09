package com.ss.inventario.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.ss.inventario.model.Movimiento;

public interface MovimientoRepository extends JpaRepository<Movimiento, Integer> {

}