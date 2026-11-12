package es.ercilla.modelo;
import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;


@Entity
@Table(name = "Factura")
public class Factura {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idFactura;
	
	@Column(name = "fecha")
	private String fecha;
	
	@Column(name = "importeTotal")
	private double importeTotal;
	@ManyToOne
	@JoinColumn(name = "id_cliente")
	private Cliente cliente;
	
	@ManyToMany
	@JoinTable(name = "Factura_Detalle",
	joinColumns = @JoinColumn(name = "idFactura"),
	inverseJoinColumns = @JoinColumn(name= "idProducto"))
	private List<Producto>productos;

	public Factura(int idFactura, String fecha, Cliente cliente, List<Producto> productos) {
		super();
		this.idFactura = idFactura;
		this.fecha = fecha;
		this.cliente = cliente;
		this.productos = productos;
	}

	public Factura() {
		super();
	}

	public double getImporteTotal() {
		return importeTotal;
	}

	public void setImporteTotal(double importeTotal) {
		this.importeTotal = importeTotal;
	}

	public int getIdFactura() {
		return idFactura;
	}

	public void setIdFactura(int idFactura) {
		this.idFactura = idFactura;
	}

	public String getFecha() {
		return fecha;
	}

	public void setFecha(String fecha) {
		this.fecha = fecha;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public List<Producto> getProductos() {
		return productos;
	}

	public void setProductos(List<Producto> productos) {
		this.productos = productos;
	}

	@Override
	public String toString() {
		return "Factura [idFactura=" + idFactura + ", fecha=" + fecha + ", cliente=" + cliente + ", productos="
				+ productos + "]";
	}
	
	
}
