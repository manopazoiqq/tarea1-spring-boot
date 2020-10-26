package com.tarea.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.tarea.exception.ModeloNotFoundException;
import com.tarea.model.Supervisor;
import com.tarea.service.ISupervisorService;
@RestController
@RequestMapping("/Supervisor")
public class SupervisorController {
	@Autowired
	private ISupervisorService service;
	
	@GetMapping
	public ResponseEntity<List<Supervisor>> listar(){
		List<Supervisor> listado = service.listar();
		return new ResponseEntity<List<Supervisor>>(listado,HttpStatus.OK);		
	}	
	@GetMapping("/{id}")
	public ResponseEntity<Supervisor> leerPorId(@PathVariable("idSupervisor") Integer idSupervisor){
		Supervisor supervisor = service.leerPorId(idSupervisor);
		if (supervisor.getId_supervisor() == null) {
			throw new ModeloNotFoundException("ID: "+idSupervisor+" NO encontrado");
		}		
		return new ResponseEntity<Supervisor>(supervisor,HttpStatus.OK);
	}
	@PostMapping
	public ResponseEntity<Supervisor> registrar(@Valid @RequestBody Supervisor supervisor){
		Supervisor sup = service.registrar(supervisor);
		return new ResponseEntity<Supervisor>(sup,HttpStatus.OK);
	} 
	@PutMapping
	public ResponseEntity<Supervisor> modificar(@Valid @RequestBody Supervisor supervisor){
		Supervisor sup = service.modificar(supervisor);
		return new ResponseEntity<Supervisor>(sup,HttpStatus.OK);
	}
	@DeleteMapping("/{id}")
	public ResponseEntity<Object> eliminar(@PathVariable("idSupervisor") Integer idSupervisor){
		Supervisor sup = service.leerPorId(idSupervisor);
		if (sup.getId_supervisor() == null) {
			throw new ModeloNotFoundException("ID: "+idSupervisor+" NO encontrado");
		}
		service.eliminar(idSupervisor);
		return new ResponseEntity<Object>(HttpStatus.OK);		
	}
}
