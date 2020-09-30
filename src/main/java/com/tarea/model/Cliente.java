// CLASE TERMINADA
package com.tarea.model;
import javax.persistence.Table;
// CLASE TERMINADA
import javax.persistence.Id;
import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Entity;
import javax.validation.constraints.Size;	

@Entity
@Table(name = "cliente")
public class Cliente {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id_cliente;
	
	@Size(max = 50, message="Valor ingresado no puede superar los 50 caracteres")
	@Column(name="nombre_cliente",length=50)
	private String nombre_cliente;
	
	@Size(max = 50, message="Valor ingresado no puede superar los 50 caracteres")
	@Column(name="dir_cliente",length=50)
	private String dir_cliente;
	
	@Size(max = 50, message="Valor ingresado no puede superar los 50 caracteres")
	@Column(name="tel_cliente",length=50)
	private String tel_cliente;
	
}
