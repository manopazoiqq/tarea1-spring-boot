// CLASE TERMINADA
package com.tarea.model;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Column;
import javax.validation.constraints.Size;

@Entity
@Table(name = "marca")
public class Marca {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id_marca;
	
	@Size(max = 150, message = "Valor ingresado no puede superar los 150 caracteres")
	@Column(name = "descripcion", nullable = false, length = 150 )
	private String descripcion;
	
	@Size(max = 50, message = "Valor ingresado no puede superar los 50 caracteres")
	@Column(name = "direccion", length = 50)
	private String direccion;
	
	@Size(max = 50, message = "Valor ingresado no puede superar los 50 caracteres")
	@Column(name = "ciudad", length = 50)
	private String ciudad;
}
