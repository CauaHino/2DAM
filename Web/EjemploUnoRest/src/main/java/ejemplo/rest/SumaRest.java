package ejemplo.rest;


import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;

	@Path("/suma")
	public class SumaRest {
		@GET
		@Path("/{num1}/{num2}")
		@Produces(MediaType.TEXT_PLAIN)
		public String sumarNumeros(@PathParam("num1") int num1, @PathParam("num2") int num2) {
			
			return "La suma de los numeros es: " + (num1+num2);
		}
	
	}
