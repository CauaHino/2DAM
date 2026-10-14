package com.modelo.response;

public class ProductoResponse {
	private int idProducto;
	private String familia;
	private String nombre;
	
	public ProductoResponse() {
	}

	public ProductoResponse(int idProducto, String familia, String nombre) {
		super();
		this.idProducto = idProducto;
		this.familia = familia;
		this.nombre = nombre;
	}

	public int getIdProducto() {
		return idProducto;
	}

	public void setIdProducto(int idProducto) {
		this.idProducto = idProducto;
	}

	public String getFamilia() {
		return familia;
	}

	public void setFamilia(String familia) {
		this.familia = familia;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	@Override
	public String toString() {
		return "ProductoResponse [idProducto=" + idProducto + ", familia=" + familia + ", nombre=" + nombre + "]";
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ProductoResponse other = (ProductoResponse) obj;
		if (idProducto != other.idProducto)
			return false;
		if (familia == null) {
			if (other.familia != null)
				return false;
		} else if (!familia.equals(other.familia))
			return false;
		if (nombre == null) {
			if (other.nombre != null)
				return false;
		} else if (!nombre.equals(other.nombre))
			return false;
		return true;
	}
	
	
}
