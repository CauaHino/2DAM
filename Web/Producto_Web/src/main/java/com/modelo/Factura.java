package com.modelo;

import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;

@Entity
@Table(name = "FACTURA")
public class Factura {
    @Id 
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "factura_seq")
	@SequenceGenerator(name = "factura_seq",sequenceName = "FACTURA_SEQ", allocationSize = 1)
    @Column (name = "ID_FACTURA", nullable = false)
    private int idFactura;
    @Column(name = "TOTAL", nullable = false)
    private double total;

    @ManyToOne
    @JoinColumn(name = "ID_CLIENTE", nullable = false)
    private Cliente cliente;

    @ManyToMany
    @JoinTable(name = "FACTURA_PRODUCTO", 
                joinColumns = @JoinColumn(name = "idFactura"),  
                inverseJoinColumns = @JoinColumn(name = "idProducto"))
    private List<Producto> productos;

    public Factura() {
    }

    public Factura(int idFactura, String fecha, double total, Cliente cliente, List<Producto> productos) {
        this.idFactura = idFactura;
        this.total = total;
        this.cliente = cliente;
        this.productos = productos;
    }

    public int getIdFactura() {
        return idFactura;
    }

    public void setIdFactura(int idFactura) {
        this.idFactura = idFactura;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public List<Producto> getProductos() {
        return productos;
    }

    public void setProductos(List<Producto> productos) {
        this.productos = productos;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Factura other = (Factura) obj;
        if (idFactura != other.idFactura)
            return false;
        if (Double.doubleToLongBits(total) != Double.doubleToLongBits(other.total))
            return false;
        if (cliente == null) {
            if (other.cliente != null)
                return false;
        } else if (!cliente.equals(other.cliente))
            return false;
        if (productos == null) {
            if (other.productos != null)
                return false;
        } else if (!productos.equals(other.productos))
            return false;
        return true;
    }

    @Override
    public String toString() {
        return "Factura [idFactura=" + idFactura + ", total=" + total + ", cliente=" + cliente + ", productos="
                + productos + "]";
    }

}
