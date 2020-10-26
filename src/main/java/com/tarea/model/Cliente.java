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

	public Integer getId_cliente() {
		return id_cliente;
	}

	public void setId_cliente(Integer id_cliente) {
		this.id_cliente = id_cliente;
	}

	public String getNombre_cliente() {
		return nombre_cliente;
	}

	public void setNombre_cliente(String nombre_cliente) {
		this.nombre_cliente = nombre_cliente;
	}

	public String getDir_cliente() {
		return dir_cliente;
	}

	public void setDir_cliente(String dir_cliente) {
		this.dir_cliente = dir_cliente;
	}

	public String getTel_cliente() {
		return tel_cliente;
	}

	public void setTel_cliente(String tel_cliente) {
		this.tel_cliente = tel_cliente;
	}
	
}
