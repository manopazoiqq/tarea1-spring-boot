package com.tarea.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tarea.model.Venta;
import com.tarea.repo.IVentaRepo;
import com.tarea.service.IVentaService;

@Service
public class VentaServiceImpl implements IVentaService {
	
	@Autowired
	private IVentaRepo repo;
	
	@Override
	public Venta registrar(Venta venta) {
		return repo.save(venta);
	}
	@Override
	public Venta modificar(Venta venta) {
		return repo.save(venta);
	}
	@Override
	public List<Venta> listar(){
		return repo.findAll();
	}
	@Override
	public Venta leerPorId(Integer idVenta) {
		Optional<Venta> op = repo.findById(idVenta);
		return op.isPresent() ? op.get() : new Venta();
	}
	@Override
	public boolean eliminar(Integer idVenta) {
		repo.deleteById(idVenta);
		return true;
	}

}
