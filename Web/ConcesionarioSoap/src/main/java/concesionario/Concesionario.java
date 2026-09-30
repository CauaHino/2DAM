package concesionario;

import java.util.ArrayList;

import jakarta.jws.WebMethod;
import jakarta.jws.WebParam;
import jakarta.jws.WebService;
import vehiculos.Vehiculo;

@WebService(name = "Concesionario", serviceName = "Concesionario")
public class Concesionario {
	private ArrayList<Vehiculo> vehiculos = new ArrayList<Vehiculo>();
	
	public Concesionario() {
		
	}

	public ArrayList<Vehiculo> getVehiculos() {
		return vehiculos;
	}

	public void setVehiculos(ArrayList<Vehiculo> vehiculos) {
		this.vehiculos = vehiculos;
	}
	
	@WebMethod(operationName = "crearVehiculor")
	public String crearVehiculo(@WebParam(name = "v") Vehiculo v) {
		if(!vehiculos.contains(v)) {
			vehiculos.add(v);
			return v.toString();
		}
		return "¡El vehiculo ya existe!";
	}
	
	@WebMethod(operationName = "borrarVehiculo")
	public boolean borrarVehiculo(@WebParam(name = "v") Vehiculo v) {
		if(vehiculos.contains(v)) {
			vehiculos.remove(vehiculos.indexOf(v));
			System.out.println("Vehiculo borrado con éxito");
			return true;
		}
		System.out.println("No fue posible borrar el vehiculo!");
		return false;
	}
	
	@WebMethod(operationName = "editarVehiculo")
	public boolean editarVehiculo(@WebParam(name = "v") Vehiculo v, @WebParam(name = "marca") String marca, 
									@WebParam(name = "modelo") String modelo, @WebParam(name = "potencia") int potencia) {
		if(vehiculos.contains(v)) {
			int i = vehiculos.indexOf(v);
			vehiculos.get(i).setMarca(marca);
			vehiculos.get(i).setModelo(modelo);
			vehiculos.get(i).setPotencia(potencia);
			System.out.println("Vehiculo editado");
			return true;
		}
		System.out.println("No fue posible editar el vehiculo");
		return false;
	}
	
	@WebMethod(operationName = "buscarVehiculo")
	public String buscarVehiculo(@WebParam(name = "v") Vehiculo v) {
		if(vehiculos.contains(v)) {
			return vehiculos.get(vehiculos.indexOf(v)).toString();
		}
		return "Vehiculo no existe!";
	}
	
	@WebMethod(operationName = "listarVehiculo")
	public void listarVehiculos() {
		if(!vehiculos.isEmpty()) {
			for(Vehiculo v : vehiculos) {
				System.out.println(v.toString());
			}
		}		
	}

}
