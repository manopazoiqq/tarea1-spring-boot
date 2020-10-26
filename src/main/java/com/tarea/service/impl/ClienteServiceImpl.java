package com.tarea.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tarea.model.Cliente;
import com.tarea.repo.IClienteRepo;
import com.tarea.service.IClienteService;

@Service
public class ClienteServiceImpl implements IClienteService {
	
	@Autowired
	private IClienteRepo repo;
	
	@Override
	public Cliente registrar(Cliente cliente) {
		return repo.save(cliente);
	}
	
	@Override
	public Cliente modificar(Cliente cliente) {
		return repo.save(cliente);
	}
	
	@Override
	public List<Cliente> listar() {
		return repo.findAll();
	}
	
	@Override
	public Cliente leerPorId(Integer idCliente) {
		Optional<Cliente> op = repo.findById(idCliente);
		return op.isPresent() ? op.get() : new Cliente();
	}
	
	@Override
	public boolean eliminar(Integer idCliente) {
		repo.deleteById(idCliente);
		return true;
	}

}
