package com.tarea.model;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Id;
import javax.persistence.IdClass;

@Entity
@Table(name = "compra_producto")
@IdClass(Compra_ProductoPK.class)
public class Compra_Producto {
	// en esta clase solamente se declaran los campos y se apunta a la clase que manejará la relación.
	@Id
	private Producto producto;
	
	@Id
	private Venta venta;
	 
}
