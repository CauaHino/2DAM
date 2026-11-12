package es.ercilla.modelo;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "Cliente")
public class Cliente {
	
	@Id 
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idCliente;
	
	@Column(name = "nombre")
	private String nombre;
	
	@Column(name = "email", unique = true)
	private String email;
	
	@OneToMany(mappedBy = "cliente", cascade = CascadeType.ALL)
	@JsonIgnore
	private List<Factura>facturas = new ArrayList<>();

	public Cliente(int idCliente, String nombre, String email, List<Factura> facturas) {
		super();
		this.idCliente = idCliente;
		this.nombre = nombre;
		this.email = email;
		this.facturas = facturas;
	}

	public Cliente() {
		super();
	}

	public int getIdCliente() {
		return idCliente;
	}

	public void setIdCliente(int idCliente) {
		this.idCliente = idCliente;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public List<Factura> getFacturas() {
		return facturas;
	}

	public void setFacturas(List<Factura> facturas) {
		this.facturas = facturas;
	}

	@Override
	public String toString() {
		return "Cliente [idCliente=" + idCliente + ", nombre=" + nombre + ", email=" + email + "]";
	}
	
	
	
}
