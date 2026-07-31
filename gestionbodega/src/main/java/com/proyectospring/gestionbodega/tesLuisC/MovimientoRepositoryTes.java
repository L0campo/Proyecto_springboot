package com.proyectospring.gestionbodega.tesLuisC;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;


import com.proyectospring.gestionbodega.entities.Movimiento;

import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface MovimientoRepositoryTes extends JpaRepository<Movimiento, Long>, JpaSpecificationExecutor<Movimiento> {

    @Query("SELECT m FROM Movimiento m WHERE m.fechaHora BETWEEN :fechaInicio AND :fechaFin")
List<Movimiento> buscarPorRangoDeFechas(
    @Param("fechaInicio") LocalDateTime fechaInicio, 
    @Param("fechaFin") LocalDateTime fechaFin
);

    List<Movimiento> findByFechaHoraBetween(LocalDateTime fechaInicio, LocalDateTime fechaFin);

    List<Movimiento> findByProductoId(Long productoId);
}