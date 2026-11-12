package es.ercilla.modelos;

import java.util.Objects;

public class Producto {
	private String nombre;
	private String familia;
	private double precio;
	
	public Producto() {
		
	}
	
	public Producto(String nombre, String familia, double precio) {
		super();
		this.nombre = nombre;
		this.familia = familia;
		this.precio = precio;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getFamilia() {
		return familia;
	}

	public void setFamilia(String familia) {
		this.familia = familia;
	}

	public double getPrecio() {
		return precio;
	}

	public void setPrecio(double precio) {
		this.precio = precio;
	}

	@Override
	public int hashCode() {
		return Objects.hash(familia, nombre, Double.valueOf(precio));
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
		return Objects.equals(familia, other.familia) && Objects.equals(nombre, other.nombre)
				&& Double.doubleToLongBits(precio) == Double.doubleToLongBits(other.precio);
	}

	@Override
	public String toString() {
		return "Producto [nombre=" + nombre + ", familia=" + familia + ", precio=" + precio + "]";
	}

}
