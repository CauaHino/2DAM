package com.modelo.request;

public class ProductoRequest {
	private String familia;
	private String nombre;
	
	public ProductoRequest() {
	}

	public ProductoRequest(String familia, String nombre) {
		super();
		this.familia = familia;
		this.nombre = nombre;
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
	
}
