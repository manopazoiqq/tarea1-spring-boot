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
import com.tarea.model.Venta;
import com.tarea.service.IVentaService;

@RestController
@RequestMapping("/Venta")
public class VentaController {
	@Autowired
	private IVentaService service;
	
	@GetMapping
	public ResponseEntity<List<Venta>> listar(){
		List<Venta> listado = service.listar();
		return new ResponseEntity<List<Venta>>(listado,HttpStatus.OK);		
	}	
	@GetMapping("/{id}")
	public ResponseEntity<Venta> leerPorId(@PathVariable("idVenta") Integer idVenta){
		Venta venta = service.leerPorId(idVenta);
		if (venta.getId_venta() == null) {
			throw new ModeloNotFoundException("ID: "+idVenta+" NO encontrado");
		}		
		return new ResponseEntity<Venta>(venta,HttpStatus.OK);
	}
	@PostMapping
	public ResponseEntity<Venta> registrar(@Valid @RequestBody Venta venta){
		Venta ven = service.registrar(venta);
		return new ResponseEntity<Venta>(ven,HttpStatus.OK);
	} 
	@PutMapping
	public ResponseEntity<Venta> modificar(@Valid @RequestBody Venta venta){
		Venta ven = service.modificar(venta);
		return new ResponseEntity<Venta>(ven,HttpStatus.OK);
	}
	@DeleteMapping("/{id}")
	public ResponseEntity<Object> eliminar(@PathVariable("idVenta") Integer idVenta){
		Venta ven = service.leerPorId(idVenta);
		if (ven.getId_venta() == null) {
			throw new ModeloNotFoundException("ID: "+idVenta+" NO encontrado");
		}
		service.eliminar(idVenta);
		return new ResponseEntity<Object>(HttpStatus.OK);		
	}

}
