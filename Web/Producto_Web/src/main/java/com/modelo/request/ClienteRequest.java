package com.modelo.request;

public class ClienteRequest {
	private String documento;
	private String nombre;
	private String apellidos;
	
	public ClienteRequest() {
	}

	public ClienteRequest(String documento, String nombre, String apellidos) {
		super();
		this.documento = documento;
		this.nombre = nombre;
		this.apellidos = apellidos;
	}

	public String getDocumento() {
		return documento;
	}

	public void setDocumento(String documento) {
		this.documento = documento;
	}
	
	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellidos() {
		return apellidos;
	}

	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}
	
}
