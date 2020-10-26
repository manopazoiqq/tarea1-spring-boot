package com.tarea.service.impl;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tarea.model.Supervisor;
import com.tarea.repo.ISupervisorRepo;
import com.tarea.service.ISupervisorService;

@Service
public class SupervisorServiceImpl implements ISupervisorService {
	
	@Autowired
	private ISupervisorRepo repo;
	
	@Override
	public Supervisor registrar(Supervisor sup) {
		return repo.save(sup);
	}
	@Override
	public Supervisor modificar(Supervisor sup) {
		return repo.save(sup);
	}
	@Override
	public List<Supervisor> listar(){
		return repo.findAll();
	}
	@Override
	public boolean eliminar(Integer idSupervisor) {
		repo.deleteById(idSupervisor);
		return true;
	} 	
	@Override
	public Supervisor leerPorId(Integer idSupervisor) {
		Optional<Supervisor> op = repo.findById(idSupervisor);
		return op.isPresent() ? op.get() : new Supervisor();
	}
}
