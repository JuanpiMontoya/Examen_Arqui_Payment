package com.example.Payment.Service;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
public class PagoServiceTest {

    @InjectMocks
    private PagoService pagoService;

    @Test
    void testPagoExitoso() {
        // Arrange
        Tarjeta tarjeta = new Tarjeta("1234567812345678", "123", "12/25");
        double monto = 100.0;

        // Act
        boolean resultado = pagoService.procesarPago(tarjeta, monto);

        // Assert
        assertTrue(resultado);
    }

    @Test
    void testPagoFallidoPorTarjetaInvalida() {
        // Arrange
        Tarjeta tarjeta = new Tarjeta("1234567812345678", "12", "12/25");
        double monto = 100.0;

        // Act
        boolean resultado = pagoService.procesarPago(tarjeta, monto);

        // Assert
        assertFalse(resultado);
    }

    @Test
    void testPagoFallidoPorMontoNegativo() {
        // Arrange
        Tarjeta tarjeta = new Tarjeta("1234567812345678", "123", "12/25");
        double monto = -50.0;

        // Act
        boolean resultado = pagoService.procesarPago(tarjeta, monto);

        // Assert
        assertFalse(resultado);
    }
}