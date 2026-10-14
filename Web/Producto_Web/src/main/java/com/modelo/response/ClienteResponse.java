package com.modelo.response;

public class ClienteResponse {
	private int idCliente;
	private String documento;
	private String nombre;
	private String apellidos;
	
	public ClienteResponse() {
	}

	public ClienteResponse(int idCliente, String documento, String nombre, String apellidos) {
		super();
		this.idCliente = idCliente;
		this.documento = documento;
		this.nombre = nombre;
		this.apellidos = apellidos;
	}

	public int getIdCliente() {
		return idCliente;
	}

	public void setIdCliente(int idCliente) {
		this.idCliente = idCliente;
	}

	public String getDocumento() {
		return documento;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public void setDocumento(String documento) {
		this.documento = documento;
	}

	public String getApellidos() {
		return apellidos;
	}

	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ClienteResponse other = (ClienteResponse) obj;
		if (idCliente != other.idCliente)
			return false;
		if (documento == null) {
			if (other.documento != null)
				return false;
		} else if (!documento.equals(other.documento))
			return false;
		if (nombre == null) {
			if (other.nombre != null)
				return false;
		} else if (!nombre.equals(other.nombre))
			return false;
		if (apellidos == null) {
			if (other.apellidos != null)
				return false;
		} else if (!apellidos.equals(other.apellidos))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "ClienteResponse [idCliente=" + idCliente + ", documento=" + documento + ", nombre=" + nombre
				+ ", apellidos=" + apellidos + "]";
	}
	
}
