package com.proyectospring.gestionbodega.tesLuisC;

import org.springframework.data.jpa.domain.Specification;

import com.proyectospring.gestionbodega.entities.Auditoria;
import com.proyectospring.gestionbodega.entities.Movimiento;

import jakarta.persistence.criteria.Predicate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class ReporteSpecifications {

  
    public static Specification<Movimiento> filtroMovimientos(Long bodegaId, Long productoId, String tipoMovimiento, LocalDateTime fechaInicio, LocalDateTime fechaFin) {
        return (root, query, cb) -> {
            List<Predicate> predicados = new ArrayList<>();

  
            if (bodegaId != null) {
                predicados.add(cb.equal(root.get("bodega").get("id"), bodegaId)); 
            }
            if (productoId != null) {
                predicados.add(cb.equal(root.get("producto").get("id"), productoId));
            }
            if (tipoMovimiento != null && !tipoMovimiento.isEmpty()) {
                predicados.add(cb.equal(root.get("tipoMovimiento"), tipoMovimiento)); 
            }
            if (fechaInicio != null) {
                predicados.add(cb.greaterThanOrEqualTo(root.get("fecha"), fechaInicio));
            }
            if (fechaFin != null) {
                predicados.add(cb.lessThanOrEqualTo(root.get("fecha"), fechaFin));
            }

            return cb.and(predicados.toArray(new Predicate[0]));
        };
    }


    public static Specification<Auditoria> filtroAuditoria(Long productoId, LocalDateTime fechaInicio, LocalDateTime fechaFin, String campoModificado) {
        return (root, query, cb) -> {
            List<Predicate> predicados = new ArrayList<>();

            if (productoId != null) {
                predicados.add(cb.equal(root.get("producto").get("id"), productoId));
            }
            if (fechaInicio != null) {
                predicados.add(cb.greaterThanOrEqualTo(root.get("fechaCambio"), fechaInicio));
            }
            if (fechaFin != null) {
                predicados.add(cb.lessThanOrEqualTo(root.get("fechaCambio"), fechaFin));
            }
            if (campoModificado != null && !campoModificado.isEmpty()) {
                predicados.add(cb.equal(root.get("campoModificado"), campoModificado));
            }

            return cb.and(predicados.toArray(new Predicate[0]));
        };
    }
}