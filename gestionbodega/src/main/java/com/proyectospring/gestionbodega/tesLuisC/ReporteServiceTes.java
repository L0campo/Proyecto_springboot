package com.proyectospring.gestionbodega.tesLuisC;


import lombok.RequiredArgsConstructor;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import com.proyectospring.gestionbodega.entities.Auditoria;
import com.proyectospring.gestionbodega.entities.Movimiento;
import com.proyectospring.gestionbodega.tesLuisC.AuditoriaRepositoryTes;
import com.proyectospring.gestionbodega.tesLuisC.MovimientoRepositoryTes;

import java.time.LocalDateTime;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ReporteServiceTes {

    private final MovimientoRepositoryTes movimientoRepository;
    private final AuditoriaRepositoryTes auditoriaRepository;

    public List<Movimiento> obtenerMovimientosFiltrados(Long bodegaId, Long productoId, String tipoMovimiento, LocalDateTime fechaInicio, LocalDateTime fechaFin) {
        
        Specification<Movimiento> spec = ReporteSpecifications.filtroMovimientos(bodegaId, productoId, tipoMovimiento, fechaInicio, fechaFin);
        
        
        return movimientoRepository.findAll(spec);
    }

    public List<Auditoria> obtenerAuditoriaFiltrada(Long productoId, LocalDateTime fechaInicio, LocalDateTime fechaFin, String campoModificado) {
        
        Specification<Auditoria> spec = ReporteSpecifications.filtroAuditoria(productoId, fechaInicio, fechaFin, campoModificado);
        
       
        return auditoriaRepository.findAll(spec);
    }
}