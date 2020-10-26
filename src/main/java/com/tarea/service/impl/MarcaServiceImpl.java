package com.tarea.service.impl;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tarea.model.Marca;
import com.tarea.repo.IMarcaRepo;
import com.tarea.service.IMarcaService;

@Service
public class MarcaServiceImpl implements IMarcaService {
	
	@Autowired
	private IMarcaRepo repo;
	
	@Override
	public Marca registrar(Marca marca) {
		return repo.save(marca);
	}
	@Override
	public Marca modificar(Marca marca) {
		return repo.save(marca);
	}	
	@Override
	public List<Marca> listar(){
		return repo.findAll();
	}	
	@Override
	public boolean eliminar(Integer idMarca) {
		repo.deleteById(idMarca);
		return true;
	}
	@Override
	public Marca leerPorId(Integer idMarca) {
		Optional<Marca> op = repo.findById(idMarca);
		return op.isPresent() ? op.get() : new Marca();		
	}

}
