package com.example.Payment.Service;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class PagoService {
    private final List<Tarjeta> tarjetas = new ArrayList<>();

    public boolean procesarPago(Tarjeta tarjeta, double monto) {
        if (validarTarjeta(tarjeta) && monto > 0) {
            System.out.println("Pago exitoso de: " + monto);
            return true;
        } else {
            System.out.println("Pago fallido.");
            return false;
        }
    }

    private boolean validarTarjeta(Tarjeta tarjeta) {
        return tarjeta.getNumeroTarjeta().length() == 16 && tarjeta.getCvv().length() == 3;
    }

    public void agregarTarjeta(Tarjeta tarjeta) {
        tarjetas.add(tarjeta);
    }

    public List<Tarjeta> obtenerTarjetas() {
        return tarjetas;
    }
}