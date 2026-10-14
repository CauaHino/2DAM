package com.service;

import com.dao.FacturaDAO;
import com.modelo.Factura;
import com.modelo.request.FacturaRequest;
import com.modelo.response.FacturaResponse;
import com.utils.Utils;

import jakarta.jws.WebMethod;
import jakarta.jws.WebParam;
import jakarta.jws.WebService;

@WebService(name = "FacturaService", serviceName = "FacturaService")
public class FacturaService {
    private FacturaDAO facturaDAO = new FacturaDAO();

    @WebMethod(operationName = "insertarFactura")
    public String insertarFactura(@WebParam(name = "factura") FacturaRequest facturaRequest) {
        Factura factura = null;
        if (facturaRequest == null) {
            return "La factura no puede ser nula";
        }else{
            factura = new Factura();
            
            factura = Utils.requestFacturaToFactura(facturaRequest);

            facturaDAO.insertarFactura(factura);
            return factura.toString() + "Factura insertada correctamente";
        }

    }

    @WebMethod(operationName = "buscarFactura")
    public FacturaResponse buscarFactura(@WebParam(name = "factura") int idFactura){
        FacturaResponse facturaResponse = null;
        try {
            facturaResponse = Utils.facturaToFacturaResponse(facturaDAO.buscarFacturaPorId(idFactura));
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        return facturaResponse;
    }

    @WebMethod(operationName =  "borrarFactura")
    public String borrarFactura(@WebParam(name = "factura") int idFactura){
        Factura factura = null;

        try {
            factura = facturaDAO.eliminarPorId(idFactura);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return factura.toString() + " ha sido borrada correctamente";
    }
}
