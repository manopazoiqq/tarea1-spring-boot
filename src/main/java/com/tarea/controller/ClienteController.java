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
import com.tarea.model.Cliente;
import com.tarea.service.IClienteService;

@RestController
@RequestMapping("/Clientes") // RUTA PADRE
public class ClienteController {
	
	@Autowired
	private IClienteService service;
	
	@GetMapping
	public ResponseEntity<List<Cliente>> listar(){
		List<Cliente> listado = service.listar();
		return new ResponseEntity<List<Cliente>>(listado,HttpStatus.OK);		
	}
	@GetMapping("/{idCliente}") // acá se toma la ruta padre más esta ruta..ejemplo /Clientes/id
	public ResponseEntity<Cliente> leerPorId(@PathVariable("idCliente") Integer idCliente){
		Cliente cliente = service.leerPorId(idCliente);
		if (cliente.getId_cliente() == null) {
			throw new ModeloNotFoundException("ID: "+idCliente+" NO encontrado: ");
		}
		return new ResponseEntity<Cliente>(cliente,HttpStatus.OK);
		
	}	
	@PostMapping
	public ResponseEntity<Cliente> registrar(@Valid @RequestBody Cliente cliente) {
		Cliente cli = service.registrar(cliente);
		return new ResponseEntity<Cliente>(cliente, HttpStatus.OK);	
	}
	
	@PutMapping
	public ResponseEntity<Cliente> modificar(@Valid @RequestBody Cliente cliente){
		Cliente cli = service.modificar(cliente);
		return new ResponseEntity<Cliente>(cliente,HttpStatus.OK);
	}
	@DeleteMapping("/{id}")
	public ResponseEntity<Object> eliminar(@PathVariable("idCliente") Integer idCliente){
		Cliente cli = service.leerPorId(idCliente);
		if (cli.getId_cliente() == null) {
			throw new ModeloNotFoundException("ID: "+idCliente+" NO encontrado: ");
		}
		service.eliminar(idCliente);
		return new ResponseEntity<Object>(HttpStatus.OK);
	}
	
}
