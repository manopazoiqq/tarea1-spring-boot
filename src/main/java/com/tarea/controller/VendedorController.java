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
import com.tarea.model.Vendedor;
import com.tarea.service.IVendedorService;


@RestController
@RequestMapping("/Vendedor")
public class VendedorController {
	
	@Autowired
	private IVendedorService service;
	
	@GetMapping
	public ResponseEntity<List<Vendedor>> listar(){
		List<Vendedor> listado = service.listar();
		return new ResponseEntity<List<Vendedor>>(listado,HttpStatus.OK);		
	}	
	@GetMapping("/{id}")
	public ResponseEntity<Vendedor> leerPorId(@PathVariable("idVendedor") Integer idVendedor){
		Vendedor vendedor = service.leerPorId(idVendedor);
		if (vendedor.getId_vendedor() == null) {
			throw new ModeloNotFoundException("ID: "+idVendedor+" NO encontrado");
		}		
		return new ResponseEntity<Vendedor>(vendedor,HttpStatus.OK);
	}
	@PostMapping
	public ResponseEntity<Vendedor> registrar(@Valid @RequestBody Vendedor vendedor){
		Vendedor ven = service.registrar(vendedor);
		return new ResponseEntity<Vendedor>(ven,HttpStatus.OK);
	} 
	@PutMapping
	public ResponseEntity<Vendedor> modificar(@Valid @RequestBody Vendedor vendedor){
		Vendedor ven = service.modificar(vendedor);
		return new ResponseEntity<Vendedor>(ven,HttpStatus.OK);
	}
	@DeleteMapping("/{id}")
	public ResponseEntity<Object> eliminar(@PathVariable("idVendedor") Integer idVendedor){
		Vendedor ven = service.leerPorId(idVendedor);
		if (ven.getId_vendedor() == null) {
			throw new ModeloNotFoundException("ID: "+idVendedor+" NO encontrado");
		}
		service.eliminar(idVendedor);
		return new ResponseEntity<Object>(HttpStatus.OK);		
	}

}
