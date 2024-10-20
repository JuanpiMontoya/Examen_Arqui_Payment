package com.example.Payment.Service.model;

import com.example.Payment.Service.Tarjeta;

public class PagoDto {
    private Tarjeta tarjeta;
    private double monto;

    public PagoDto() {
    }

    public PagoDto(Tarjeta tarjeta, double monto) {
        this.tarjeta = tarjeta;
        this.monto = monto;
    }

    public Tarjeta getTarjeta() {
        return tarjeta;
    }

    public void setTarjeta(Tarjeta tarjeta) {
        this.tarjeta = tarjeta;
    }

    public double getMonto() {
        return monto;
    }

    public void setMonto(double monto) {
        this.monto = monto;
    }
}