package com.example.Payment.Service.controller;

import com.example.Payment.Service.PagoService;
import com.example.Payment.Service.api.PagoApi;
import com.example.Payment.Service.model.ErrorResponse;
import com.example.Payment.Service.model.PagoDto;
import com.example.Payment.Service.Tarjeta;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class PagoController implements PagoApi {

    private final PagoService pagoService;

    public PagoController(PagoService pagoService) {
        this.pagoService = pagoService;
    }

    @Override
    public ResponseEntity<String> procesarPago(PagoDto pagoDto) {
        boolean pagoExitoso = pagoService.procesarPago(pagoDto.getTarjeta(), pagoDto.getMonto());

        if (pagoExitoso) {
            return ResponseEntity.ok("Pago procesado exitosamente.");
        } else {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                    .body(new ErrorResponse("Datos de pago inválidos").toString());
        }
    }

    @Override
    public ResponseEntity<List<Tarjeta>> obtenerTarjetas() {
        List<Tarjeta> tarjetas = pagoService.obtenerTarjetas();
        return new ResponseEntity<>(tarjetas, HttpStatus.OK);
    }
}