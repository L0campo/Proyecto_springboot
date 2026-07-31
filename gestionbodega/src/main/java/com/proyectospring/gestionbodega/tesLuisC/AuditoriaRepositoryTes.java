package com.proyectospring.gestionbodega.tesLuisC;

import com.proyectospring.gestionbodega.entities.Auditoria;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AuditoriaRepositoryTes extends JpaRepository<Auditoria, Long> {
    
    List<Auditoria> findByUsuario(String usuario);
    List<Auditoria> findByOperacion(String operacion);
}
