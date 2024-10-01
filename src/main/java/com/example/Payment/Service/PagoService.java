package com.example.Payment.Service;

public class PagoService {

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
}
