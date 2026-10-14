package com.modelo.request;

import java.util.ArrayList;
import java.util.List;

public class FacturaRequest {
    private int idCliente;
    private List<Integer> idsProducto = new ArrayList<Integer>();
    private double total;

    public FacturaRequest() {
    }

    public FacturaRequest(int idCliente, List<Integer> idsProducto, double total) {
        this.idCliente = idCliente;
        this.idsProducto = idsProducto;
        this.total = total;
    }

    public int getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(int idCliente) {
        this.idCliente = idCliente;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }
    

    @Override
    public String toString() {
        return "FacturaRequest [idCliente=" + idCliente + ", idsProducto=" + idsProducto + ", total=" + total + "]";
    }

    public List<Integer> getIdsProducto() {
        return idsProducto;
    }

    public void setIdsProducto(List<Integer> idsProducto) {
        this.idsProducto = idsProducto;
    }

}
