package com.tarea.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tarea.model.Producto;
import com.tarea.repo.IProductoRepo;
import com.tarea.service.IProductoService;

@Service
public class IProductoServiceImpl implements IProductoService {
	
	@Autowired
	private IProductoRepo repo;
	
	@Override
	public Producto registrar(Producto producto) {
		return repo.save(producto);
	}
	@Override
	public Producto modificar(Producto producto) {
		return repo.save(producto);
	}
	@Override
	public List<Producto> listar(){
		return repo.findAll();
	}	
	@Override
	public Producto leerPorId(Integer idProducto) {
		Optional<Producto> op = repo.findById(idProducto);
		return op.isPresent() ? op.get() : new Producto();
	}
	@Override
	public boolean eliminar(Integer idProducto) {
		repo.deleteById(idProducto);
		return true;
	}

}
