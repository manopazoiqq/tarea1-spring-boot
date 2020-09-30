package com.tarea.model;

import java.io.Serializable;

import javax.persistence.Embeddable;
import javax.persistence.ManyToOne;
import javax.persistence.JoinColumn;

@Embeddable
public class Compra_ProductoPK implements Serializable {

	@ManyToOne
	@JoinColumn(name = "id_producto", nullable = false)
	private Producto producto;
	
	@ManyToOne
	@JoinColumn(name = "id_venta", nullable = false)
	private Venta venta;
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((producto == null) ? 0 : producto.hashCode());
		result = prime * result + ((venta == null) ? 0 : venta.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Compra_ProductoPK other = (Compra_ProductoPK) obj;
		if (producto == null) {
			if (other.producto != null)
				return false;
		} else if (!producto.equals(other.producto))
			return false;
		if (venta == null) {
			if (other.venta != null)
				return false;
		} else if (!venta.equals(other.venta))
			return false;
		return true;
	}
}
