package vehiculos;

import java.util.Objects;

public class Vehiculo {
	private String marca;
	private String modelo;
	private int potencia;
	
	public Vehiculo() {
		
	}
	public Vehiculo(String marca, String modelo, int potencia) {
		super();
		this.marca = marca;
		this.modelo = modelo;
		this.potencia = potencia;
	}

	public String getMarca() {
		return marca;
	}

	public void setMarca(String marca) {
		this.marca = marca;
	}

	public String getModelo() {
		return modelo;
	}

	public void setModelo(String modelo) {
		this.modelo = modelo;
	}

	public int getPotencia() {
		return potencia;
	}

	public void setPotencia(int potencia) {
		this.potencia = potencia;
	}
	
	@Override
	public String toString() {
		return "VEHICULO:	\n" + 
					"\tMarca: " + this.marca + "\n" +
					"\tModelo: " + this.modelo + "\n" + 
					"\tPotencia: " + this.potencia + " CV\n";
					
	}

	@Override
	public int hashCode() {
		return Objects.hash(marca, modelo, Integer.valueOf(potencia));
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Vehiculo other = (Vehiculo) obj;
		return Objects.equals(marca, other.marca) && Objects.equals(modelo, other.modelo) && potencia == other.potencia;
	}

//	@Override
//	public boolean equals(Vehiculo v) {
//			if(v.getMarca() == this.marca && 
//				v.getModelo() == this.modelo &&
//				v.getPotencia() == this.potencia) {
//				return true;
//			}
//			return false;
//		}
	
	
	
}
