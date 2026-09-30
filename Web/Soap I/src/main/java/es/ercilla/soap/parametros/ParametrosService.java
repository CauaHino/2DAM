package es.ercilla.soap.parametros;

import jakarta.jws.WebMethod;
import jakarta.jws.WebParam;
import jakarta.jws.WebService;

/**
 * Servicio web SOAP que envía un mensaje usando los parámetro que llegan
 */
@WebService(serviceName = "ParametrosService")
public class ParametrosService {

	/**
	 * Operación que envía un mensaje usando los parámetros que llegan
	 * 
	 * @param nombre
	 * @param familia
	 * @return mensaje completo con los parámetros
	 */
	@WebMethod(operationName = "saludar")
	public String saludar(@WebParam(name = "nombre") String nombre, @WebParam(name = "familia") String familia) {
		String mensaje = "El artículo " + nombre + " pertenece a " + familia;
		System.out.println(mensaje);
		return mensaje;
	}
}