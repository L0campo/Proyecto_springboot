package com.proyectospring.gestionbodega.tesLuisC;

import lombok.RequiredArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.time.LocalDateTime;
import java.util.List;


import com.proyectospring.gestionbodega.entities.Auditoria;
import com.proyectospring.gestionbodega.entities.Movimiento;

import com.proyectospring.gestionbodega.tesLuisC.ReporteServiceTes; 

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/api/reportes")
@RequiredArgsConstructor
public class ReporteControllerTes {

    
    private final ReporteServiceTes reporteService;

    @GetMapping("/movimientos")
    public ResponseEntity<List<Movimiento>> obtenerReporteMovimientos(
            @RequestParam(required = false) Long bodegaId,
            @RequestParam(required = false) Long productoId,
            @RequestParam(required = false) String tipoMovimiento,
            @RequestParam(required = false) @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) LocalDateTime fechaInicio,
            @RequestParam(required = false) @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) LocalDateTime fechaFin) {
            
        List<Movimiento> resultados = reporteService.obtenerMovimientosFiltrados(bodegaId, productoId, tipoMovimiento, fechaInicio, fechaFin);
        return ResponseEntity.ok(resultados);
    }

    @GetMapping("/auditoria")
    public ResponseEntity<List<Auditoria>> obtenerReporteAuditoria(
            @RequestParam(required = false) Long productoId,
            @RequestParam(required = false) @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) LocalDateTime fechaInicio,
            @RequestParam(required = false) @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) LocalDateTime fechaFin,
            @RequestParam(required = false) String campoModificado) {
            
        List<Auditoria> resultados = reporteService.obtenerAuditoriaFiltrada(productoId, fechaInicio, fechaFin, campoModificado);
        return ResponseEntity.ok(resultados);
    }
}
