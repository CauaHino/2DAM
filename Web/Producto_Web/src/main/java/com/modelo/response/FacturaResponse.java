package com.modelo.response;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import com.modelo.Cliente;
import com.modelo.Producto;

public class FacturaResponse {
	private int idFactura;
	private double total;
	private Cliente cliente;
	private List<Producto> listaProductos = new ArrayList<Producto>();
	
	public FacturaResponse() {
		
	}

	public FacturaResponse(int idFactura, double total, Cliente cliente, List<Producto> listaProductos) {
		super();
		this.idFactura = idFactura;
		this.total = total;
		this.cliente = cliente;
		this.listaProductos = listaProductos;
	}

	public int getIdFactura() {
		return idFactura;
	}

	public void setIdFactura(int idFactura) {
		this.idFactura = idFactura;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public List<Producto> getListaProductos() {
		return listaProductos;
	}

	public void setListaProductos(List<Producto> listaProductos) {
		this.listaProductos = listaProductos;
	}

	@Override
	public String toString() {
		return "FacturaResponse [idFactura=" + idFactura + ", total=" + total + ", cliente=" + cliente
				+ ", listaProductos=" + listaProductos + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(cliente, Integer.valueOf(idFactura), listaProductos, Double.valueOf(total));
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		FacturaResponse other = (FacturaResponse) obj;
		return Objects.equals(cliente, other.cliente) && idFactura == other.idFactura
				&& Objects.equals(listaProductos, other.listaProductos)
				&& Double.doubleToLongBits(total) == Double.doubleToLongBits(other.total);
	}
	
}
