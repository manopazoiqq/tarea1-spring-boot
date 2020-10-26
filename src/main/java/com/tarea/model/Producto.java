// CLASE TERMINADA
package com.tarea.model;
import javax.persistence.Entity;
import javax.persistence.ForeignKey;
import javax.persistence.GenerationType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Column;
import javax.validation.constraints.Size;
import javax.persistence.ManyToOne;
import javax.persistence.JoinColumn;
import javax.persistence.Table;

@Entity
@Table(name = "producto")
public class Producto {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id_producto;	
	
	@ManyToOne
	@JoinColumn(name = "id_marca", nullable = false, foreignKey = @ForeignKey(name = "FK_marca_producto"))
	private Marca marca; // fk
	
	@Size(max = 50, message = "Valor ingresado no puede superar los 50 caracteres")
	@Column(name = "descripcion", length=50)
	private String descripcion;
	
	@Column(name = "valor_producto", length=9)
	private Integer valor_producto;

	public Integer getId_producto() {
		return id_producto;
	}

	public void setId_producto(Integer id_producto) {
		this.id_producto = id_producto;
	}

	public Marca getMarca() {
		return marca;
	}

	public void setMarca(Marca marca) {
		this.marca = marca;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public Integer getValor_producto() {
		return valor_producto;
	}

	public void setValor_producto(Integer valor_producto) {
		this.valor_producto = valor_producto;
	}

}
