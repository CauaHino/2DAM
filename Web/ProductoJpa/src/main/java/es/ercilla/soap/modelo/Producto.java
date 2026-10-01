package es.ercilla.soap.modelo;

import java.util.Objects;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;

@Entity
@Table(name = "Producto")
public class Producto {
	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator = "producto_seq")
	@SequenceGenerator(name = "producto_seq", sequenceName = "PRODUCTO_SEQ", allocationSize = 1)
	@Column(name = "ID_PRODUCTO", nullable = false)
	private int idProducto;
	@Column(name = "FAMILIA", nullable = false)
	private String familia;
	@Column(name = "NOMBRE", nullable = false)
	private String nombre;
	
	
	public Producto() {
		
	}
	
	public Producto(int idProducto, String familia, String nombre) {
		super();
		this.idProducto = idProducto;
		this.familia = familia;
		this.nombre = nombre;
	}
	
	@Override
	public int hashCode() {
		return Objects.hash(familia, Integer.valueOf(idProducto), nombre);
	}
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Producto other = (Producto) obj;
		return Objects.equals(familia, other.familia) && idProducto == other.idProducto
				&& Objects.equals(nombre, other.nombre);
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
		return "Producto [idProducto=" + idProducto + ", familia=" + familia + ", nombre=" + nombre + "]";
	}	

}
