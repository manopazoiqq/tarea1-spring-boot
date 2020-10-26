package com.tarea.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tarea.model.Vendedor;
import com.tarea.repo.IVendedorRepo;
import com.tarea.service.IVendedorService;

@Service
public class VendedorServiceImpl implements IVendedorService {
	
	@Autowired
	private IVendedorRepo repo;
	
	@Override
	public Vendedor registrar(Vendedor vendedor) {
		return repo.save(vendedor);
	}
	@Override
	public Vendedor modificar(Vendedor vendedor) {
		return repo.save(vendedor);
	}
	@Override
	public List<Vendedor> listar(){
		return repo.findAll();
	}
	@Override
	public Vendedor leerPorId(Integer idVendedor) {
		Optional<Vendedor> op = repo.findById(idVendedor);
		return op.isPresent() ? op.get() : new Vendedor();
	}
	@Override
	public boolean eliminar(Integer idVendedor) {
		repo.deleteById(idVendedor);
		return true;
	}

}
