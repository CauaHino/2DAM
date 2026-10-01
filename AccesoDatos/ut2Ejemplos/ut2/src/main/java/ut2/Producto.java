package ut2;

import java.sql.Date;
import java.util.UUID;

public class Producto {
    private UUID id;
    private String nombre;
    private double precio;
    private int stock;
    private Integer garantia;
    private boolean dispobile;
    private Date fechaAlta;

    public Producto(UUID id, String nombre, double precio, int stock, Integer garantia, boolean dispobile,
            Date fechaAlta) {
        this.id = id;
        this.nombre = nombre;
        this.precio = precio;
        this.stock = stock;
        this.garantia = garantia;
        this.dispobile = dispobile;
        this.fechaAlta = fechaAlta;
    }
    public UUID getId() {
        return id;
    }
    public void setId(UUID id) {
        this.id = id;
    }
    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public double getPrecio() {
        return precio;
    }
    public void setPrecio(double precio) {
        this.precio = precio;
    }
    public int getStock() {
        return stock;
    }
    public void setStock(int stock) {
        this.stock = stock;
    }
    public Integer getGarantia() {
        return garantia;
    }
    public void setGarantia(Integer garantia) {
        this.garantia = garantia;
    }
    public boolean isDispobile() {
        return dispobile;
    }
    public void setDispobile(boolean dispobile) {
        this.dispobile = dispobile;
    }
    public Date getFechaAlta() {
        return fechaAlta;
    }
    public void setFechaAlta(Date fechaAlta) {
        this.fechaAlta = fechaAlta;
    }


}
