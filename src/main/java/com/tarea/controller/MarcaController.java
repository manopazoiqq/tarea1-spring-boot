package com.tarea.controller;

import java.util.List;

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
import com.tarea.model.Marca;
import com.tarea.service.IMarcaService;

@RestController
@RequestMapping("/marca")
public class MarcaController {
	
	@Autowired 
	private IMarcaService service;
	
	@GetMapping
	public ResponseEntity<List<Marca>> listar(){
		List<Marca> listado = service.listar();
		return new ResponseEntity<List<Marca>>(listado,HttpStatus.OK);
	}
	@GetMapping("/{idMarca}")
	public ResponseEntity<Marca> leerPorId(@PathVariable("idMarca") Integer idMarca){
		Marca marca = service.leerPorId(idMarca);
		if (marca.getId_marca() == null) {
			throw new ModeloNotFoundException("ID: "+idMarca+" NO encontrado: ");
		}
		return new ResponseEntity<Marca>(marca,HttpStatus.OK);
	}
	@PostMapping
	public ResponseEntity<Marca> registrar(@PathVariable @RequestBody Marca marca){
		Marca mar = service.registrar(marca);
		return new ResponseEntity<Marca>(mar,HttpStatus.OK);
	}
	@PutMapping
	public ResponseEntity<Marca> modificar(@PathVariable @RequestBody Marca marca){
		Marca mar = service.modificar(marca);
		return new ResponseEntity<Marca>(mar,HttpStatus.OK);
	}
	@DeleteMapping("/{idMarca}")
	public ResponseEntity<Object> eliminar(@PathVariable("idMarca") Integer idMarca){		
		Marca marca = service.leerPorId(idMarca);
		if (marca.getId_marca() == null){
			throw new ModeloNotFoundException("ID: "+idMarca+" NO encontrado: ");
		}
		service.eliminar(idMarca);
		return new ResponseEntity<Object>(HttpStatus.OK);
	}
	
}
