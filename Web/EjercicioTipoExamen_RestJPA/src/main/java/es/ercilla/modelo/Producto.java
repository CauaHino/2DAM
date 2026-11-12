package es.ercilla.modelo;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "Producto")
public class Producto {
		
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idProducto;
	
	@Column(name = "nombre")
	private String nombre;
	
	@Column(name = "categoria")
	private String categoria;
	
	@Column(name = "precio")
	private double precio;
	
	@OneToMany(mappedBy = "productos", cascade = CascadeType.ALL)
	private List<Factura> listaFacturas = new ArrayList<>();

	public Producto(int idProducto, String nombre, String categoria, double precio, List<Factura> listaFacturas) {
		super();
		this.idProducto = idProducto;
		this.nombre = nombre;
		this.categoria = categoria;
		this.precio = precio;
		this.listaFacturas = listaFacturas;
	}

	public Producto() {
		super();
	}

	public int getIdProducto() {
		return idProducto;
	}

	public void setIdProducto(int idProducto) {
		this.idProducto = idProducto;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getCategoria() {
		return categoria;
	}

	public void setCategoria(String categoria) {
		this.categoria = categoria;
	}

	public double getPrecio() {
		return precio;
	}

	public void setPrecio(double precio) {
		this.precio = precio;
	}

	public List<Factura> getListaFacturas() {
		return listaFacturas;
	}

	public void setListaFacturas(List<Factura> listaFacturas) {
		this.listaFacturas = listaFacturas;
	}

	@Override
	public String toString() {
		return "Producto [idProducto=" + idProducto + ", nombre=" + nombre + ", categoria=" + categoria + ", precio="
				+ precio + "]";
	}
	
	
}
