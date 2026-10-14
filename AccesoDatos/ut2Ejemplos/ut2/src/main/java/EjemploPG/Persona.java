package EjemploPG;

import java.math.BigDecimal;
import java.sql.Date;

/**
 * Persona
 */
public class Persona {
    private String nombre;
    private Date fechaNacimiento;
    private BigDecimal ingresoAnual;
    private String telefono;
    private boolean tieneCarnet;
    private double alturaMetros;

    public Persona(String nombre, Date fechaNacimiento, BigDecimal ingresoAnual, String telefono, boolean tieneCarnet, double alturaMetros) {
        this.nombre = nombre;
        this.fechaNacimiento = fechaNacimiento;
        this.ingresoAnual = ingresoAnual;
        this.telefono = telefono;
        this.tieneCarnet = tieneCarnet;
        this.alturaMetros = alturaMetros;
    }

    // Getters and setters
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Date getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(Date fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public BigDecimal getIngresoAnual() {
        return ingresoAnual;
    }

    public void setIngresoAnual(BigDecimal ingresoAnual) {
        this.ingresoAnual = ingresoAnual;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public boolean tieneCarnet() {
        return tieneCarnet;
    }

    public void setTieneCarnet(boolean tieneCarnet) {
        this.tieneCarnet = tieneCarnet;
    }

    public double getAlturaMetros() {
        return alturaMetros;
    }

    public void setAlturaMetros(double alturaMetros) {
        this.alturaMetros = alturaMetros;
    }

    @Override 
    public String toString() {
        return "Persona [nombre=" + nombre + ", fechaNacimiento=" + fechaNacimiento + ", ingresoAnual=" + ingresoAnual
                + ", telefono=" + telefono + ", tieneCarnet=" + tieneCarnet + ", alturaMetros=" + alturaMetros + "]";
    }
}
