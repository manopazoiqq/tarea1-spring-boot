// CLASE TERMINADA
package com.tarea.model;
import javax.persistence.Entity;
import javax.persistence.GenerationType;
import javax.persistence.Table;
import javax.validation.constraints.Size;
import javax.persistence.Id;
import javax.persistence.GeneratedValue;
import javax.persistence.Column;

@Entity
@Table(name = "supervisor")
public class Supervisor {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id_supervisor;
	
	@Size(max = 50, message = "Valor ingresado no puede superar los 50 caracteres")
	@Column(name = "nombre_supervisor", length = 50)
	private String nombre_supervisor;
	
	
	@Size(max = 50, message = "Valor ingresado no puede superar los 50 caracteres")
	@Column(name = "dir_supervisor", length=50)
	private String dir_supervisor;
	
	@Size(max = 50, message="Valor ingresado no puede superar los 50 caracteres")
	@Column(name ="tel_supervisor", length=50)
	private String tel_supervisor;

	public Integer getId_supervisor() {
		return id_supervisor;
	}

	public void setId_supervisor(Integer id_supervisor) {
		this.id_supervisor = id_supervisor;
	}

	public String getNombre_supervisor() {
		return nombre_supervisor;
	}

	public void setNombre_supervisor(String nombre_supervisor) {
		this.nombre_supervisor = nombre_supervisor;
	}

	public String getDir_supervisor() {
		return dir_supervisor;
	}

	public void setDir_supervisor(String dir_supervisor) {
		this.dir_supervisor = dir_supervisor;
	}

	public String getTel_supervisor() {
		return tel_supervisor;
	}

	public void setTel_supervisor(String tel_supervisor) {
		this.tel_supervisor = tel_supervisor;
	}

}
