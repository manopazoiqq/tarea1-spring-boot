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
import com.tarea.model.Producto;
import com.tarea.service.IProductoService;

@RestController
@RequestMapping("/Producto")
public class ProductoController {

	@Autowired
	private IProductoService service;
	
	@GetMapping
	public ResponseEntity<List<Producto>> listar(){
		List<Producto> listado = service.listar();
		return new ResponseEntity<List<Producto>>(listado,HttpStatus.OK);		
	}	
	@GetMapping("/{id}")
	public ResponseEntity<Producto> leerPorId(@PathVariable("idProducto") Integer idProducto){
		Producto producto = service.leerPorId(idProducto);
		if (producto.getId_producto() == null) {
			throw new ModeloNotFoundException("ID: "+idProducto+" NO encontrado");
		}		
		return new ResponseEntity<Producto>(producto,HttpStatus.OK);
	}
	@PostMapping
	public ResponseEntity<Producto> registrar(@Valid @RequestBody Producto producto){
		Producto prod = service.registrar(producto);
		return new ResponseEntity<Producto>(prod,HttpStatus.OK);
	} 
	@PutMapping
	public ResponseEntity<Producto> modificar(@Valid @RequestBody Producto producto){
		Producto prod = service.modificar(producto);
		return new ResponseEntity<Producto>(prod,HttpStatus.OK);
	}
	@DeleteMapping("/{id}")
	public ResponseEntity<Object> eliminar(@PathVariable("idProducto") Integer idProducto){
		Producto prod = service.leerPorId(idProducto);
		if (prod.getId_producto() == null) {
			throw new ModeloNotFoundException("ID: "+idProducto+" NO encontrado");
		}
		service.eliminar(idProducto);
		return new ResponseEntity<Object>(HttpStatus.OK);
		
	}
	
	
}
