package com.proyectospring.gestionbodega.tesLuisC;

import com.proyectospring.gestionbodega.entities.Auditoria;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;


import java.util.List;

@Repository
public interface AuditoriaRepositoryTes extends JpaRepository<Auditoria, Long>, JpaSpecificationExecutor<Auditoria> {
    
    List<Auditoria> findByUsuario(String usuario);
    List<Auditoria> findByOperacion(String operacion);
}
