package com.modelo;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import jakarta.xml.bind.annotation.XmlTransient;

@Entity
@Table(name = "CLIENTE")
public class Cliente {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "cliente_seq")
	@SequenceGenerator(name = "cliente_seq",sequenceName = "CLIENTE_SEQ", allocationSize = 1)
	@Column(name = "ID_CLIENTE", nullable = false)
	private int idCliente;
	@Column(name = "DOCUMENTO", nullable = false)
	private String documento;
	@Column(name = "NOMBRE", nullable = false)
	private String nombre;
	@Column(name = "APELLIDOS", nullable = false)
	private String apellidos;
	
	@OneToMany(mappedBy = "cliente")
	private List<Factura> facturas = new ArrayList<Factura>();
	//@JoinTable(name = "CLIENTE_PRODUCTO", joinColumns = @JoinColumn(name = "idCliente"), inverseJoinColumns = @JoinColumn(name = "idProducto", unique = true))

	//private List<Producto> productos = new ArrayList<Producto>();
	
	public Cliente() {
		
	}

	public Cliente(int idCliente, String documento, String nombre, String apellido, List<Factura> facturas) {
		super();
		this.idCliente = idCliente;
		this.documento = documento;
		this.nombre = nombre;
		this.apellidos = apellido;
		this.facturas = facturas;
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

	public void setApellidos(String apellido) {
		this.apellidos = apellido;
	}

	// Para decir que no se serialice la lista de facturas al generar el XML
	@XmlTransient 
	public List<Factura> getFacturas() {
		return facturas;
	}

	public void setFacturas(List<Factura> factura) {
		this.facturas = factura;
	}

	@Override
	public String toString() {
		return "Cliente [idCliente=" + idCliente + ", documento=" + documento + ", nombre=" + nombre + ", apellidos="
				+ apellidos + ", facturas=" + facturas + "]";
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Cliente other = (Cliente) obj;
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
		if (facturas == null) {
			if (other.facturas != null)
				return false;
		} else if (!facturas.equals(other.facturas))
			return false;
		return true;
	}
	

}
