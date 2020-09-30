package com.tarea.model;

import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import java.time.LocalDateTime;
import javax.persistence.Column;
import javax.persistence.ForeignKey;
import javax.persistence.JoinColumn;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "venta")
public class Venta {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id_venta; // pk
	
	@JsonIgnore // sirve para obviar redundancia
	@ManyToOne
	@JoinColumn(name = "id_vendedor", nullable = false, foreignKey=@ForeignKey(name = "fk_vendedor_venta") )
	private Vendedor vendedor; // fk
	
	@ManyToOne
	@JoinColumn(name = "id_cliente", nullable = false, foreignKey = @ForeignKey(name = "fk_cliente_venta"))
	private Cliente cliente; // fk
	
	@Column(name = "costo", length = 9)
	private Integer costo;
	
	private LocalDateTime fecha_venta; // el localdatetime no lleva notación porque la gestiona directamente JAVA...
	

}
