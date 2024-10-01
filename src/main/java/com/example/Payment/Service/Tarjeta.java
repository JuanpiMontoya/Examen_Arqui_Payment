package com.example.Payment.Service;

public class Tarjeta {
    private String numeroTarjeta;
    private String cvv;
    private String fechaExpiracion;

    public String getNumeroTarjeta() {
        return numeroTarjeta;
    }

    public void setNumeroTarjeta(String numeroTarjeta) {
        this.numeroTarjeta = numeroTarjeta;
    }

    public String getCvv() {
        return cvv;
    }

    public void setCvv(String cvv) {
        this.cvv = cvv;
    }

    public String getFechaExpiracion() {
        return fechaExpiracion;
    }

    public void setFechaExpiracion(String fechaExpiracion) {
        this.fechaExpiracion = fechaExpiracion;
    }

    // Constructor
    public Tarjeta(String numeroTarjeta, String cvv, String fechaExpiracion) {
        this.numeroTarjeta = numeroTarjeta;
        this.cvv = cvv;
        this.fechaExpiracion = fechaExpiracion;
    }
}
