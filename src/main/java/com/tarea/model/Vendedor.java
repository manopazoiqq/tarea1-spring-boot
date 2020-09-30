// CLASE TERMINADA
package com.tarea.model;
import javax.persistence.Entity;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.GenerationType;
import javax.validation.constraints.Size;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.JoinColumn;
import javax.persistence.Table;

@Entity
@Table(name = "vendedor")
public class Vendedor {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id_vendedor;
	
	@ManyToOne
	@JoinColumn(name = "id_supervisor", nullable = false, foreignKey = @ForeignKey(name = "FK_supervisor_vendedor"))
	private Supervisor supervisor;
	
	@Size(max = 50, message = "Valor ingresado no puede superar los 50 caracteres")
	@Column(name = "nombre_vendedor", length = 50)
	private String nombre_vendedor;
	
	
	@Size(max = 50, message = "Valor ingresado no puede superar los 50 caracteres")
	@Column(name = "dir_vendedor", length = 50)
	private String dir_vendedor;
	
	//MAESTRODETALLE CON VENTA...
	@OneToMany(mappedBy = "vendedor", cascade = { CascadeType.ALL }, orphanRemoval = true)
	private List<Venta> venta;

}
