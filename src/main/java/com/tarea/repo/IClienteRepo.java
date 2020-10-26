package com.tarea.repo;

import com.tarea.model.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IClienteRepo extends JpaRepository<Cliente, Integer> {

}
