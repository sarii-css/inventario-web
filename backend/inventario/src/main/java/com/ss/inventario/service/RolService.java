package com.ss.inventario.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ss.inventario.model.Rol;
import com.ss.inventario.repository.RolRepository;

@Service
public class RolService {
    
    @Autowired
    private RolRepository repository;

    public List<Rol> obtenerTodos() {
        return repository.findAll();
    }

    public Rol guardar(Rol rol) {
        return repository.save(rol);
    }

    public void eliminar(Integer id) {
        if (!repository.existsById(id)) {
            throw new RuntimeException("Rol no existe");
        }
        repository.deleteById(id);
    }

    public Rol obtenerPorId(Integer id) {
        return repository.findById(id).orElse(null);
    }
}
