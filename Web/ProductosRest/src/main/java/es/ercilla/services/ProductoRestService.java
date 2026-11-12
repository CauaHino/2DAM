package es.ercilla.services;

import java.util.ArrayList;
import java.util.List;

import es.ercilla.modelos.Producto;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;

@Path("/productos")
public class ProductoRestService {
    public static List<Producto> productos = new ArrayList<Producto>();
    
    @POST
    @Path("/insertar")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.TEXT_PLAIN)
    public String insertar(Producto producto) {
        String resultado = "";
        if (!productos.contains(producto)) {
            productos.add(producto);
            resultado = "Se ha insertado el producto: "+ producto.toString() + "\nActualmente tenemos lo siguientes Productos: "
                    + "\n" +productos.toString();
        } else {
            resultado = "El producto: " + producto.toString() + " ya existe en el sistema";
        }
        return resultado;
    }
    
    @POST
    @Path("/eliminar")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.TEXT_PLAIN)
    public String eliminar(Producto producto) {
        for (int i = 0; i< productos.size(); i++) {
            if (productos.get(i) == producto) {
                productos.remove(i);
                return"Se ha eliminado el producto: "+producto.toString();
            }
        }
        return "El producto " + producto.toString() + " no se ha podido eliminar";
    }
    
    @POST
    @Path("/actualizar/{nuevoNombre}/{nuevaFamilia}/{nuevoPrecio}")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.TEXT_PLAIN)
    public String actualizar(Producto p, @PathParam("nuevoNombre") String nuevoNombre, 
    		@PathParam("nuevoNombre") String nuevaFamilia, 
    		@PathParam("nuevoPrecio") double nuevoPrecio) {
    	String resultado = "";
    	if(productos.contains(p)) {
    		int i = productos.indexOf(p);
    		if(!nuevoNombre.equals("") && !nuevoNombre.equals(productos.get(i).getNombre())) {
    			resultado = "Nombre Actualizado!\n";
    			productos.get(i).setNombre(nuevoNombre);
    		}
    		if(!nuevaFamilia.equals("") && !nuevoNombre.equals(productos.get(i).getFamilia())) {
    			resultado = "Familia Actualizada!\n";
    			productos.get(i).setNombre(nuevaFamilia);
    		}
    		if(nuevoPrecio != 0 && nuevoPrecio != productos.get(i).getPrecio()) {
    			resultado = "Precio Actualizado!\n";
    			productos.get(i).setNombre(nuevoNombre);
    		}    		
    	}
    	return resultado;
        
    }

}
