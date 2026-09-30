package es.ercilla.soap.holamundo;

import jakarta.jws.WebMethod;
import jakarta.jws.WebService;

/**
 * Servicio Web SOAP que tiene un única operación para saludar
 */
@WebService(serviceName = "HolaMundoService")
public class HolaMundoService {

	/**
	 * Operación que lanza un saludo
	 * 
	 * @return Cadena de texto con el saludo
	 */
	@WebMethod(operationName = "saludar")
	public String saludar() {
		return "Hola Mundo";
	}
}
