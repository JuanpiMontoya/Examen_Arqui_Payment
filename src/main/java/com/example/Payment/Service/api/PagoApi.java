package com.example.Payment.Service.api;

import com.example.Payment.Service.model.ErrorResponse;
import com.example.Payment.Service.model.PagoDto;
import com.example.Payment.Service.Tarjeta;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Tag(name = "Pagos", description = "API para procesar pagos y gestionar tarjetas")
@RestController
@RequestMapping("/api/pagos")
public interface PagoApi {

    @Operation(summary = "Procesar un pago",
            description = "Procesa un pago utilizando los datos de la tarjeta y el monto.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Pago procesado exitosamente"),
            @ApiResponse(responseCode = "400", description = "Datos de pago inválidos",
                    content = @Content(mediaType = "application/json", schema = @Schema(implementation = ErrorResponse.class))),
            @ApiResponse(responseCode = "500", description = "Error interno del servidor",
                    content = @Content(mediaType = "application/json", schema = @Schema(implementation = ErrorResponse.class)))
    })
    @PostMapping("/procesar")
    ResponseEntity<String> procesarPago(@RequestBody PagoDto pagoDto);

    @Operation(summary = "Obtener todas las tarjetas",
            description = "Devuelve una lista de todas las tarjetas almacenadas.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Lista de tarjetas obtenida exitosamente",
                    content = @Content(mediaType = "application/json", schema = @Schema(implementation = List.class))),
            @ApiResponse(responseCode = "500", description = "Error interno del servidor",
                    content = @Content(mediaType = "application/json", schema = @Schema(implementation = ErrorResponse.class)))
    })
    @GetMapping("/tarjetas")
    ResponseEntity<List<Tarjeta>> obtenerTarjetas();
}