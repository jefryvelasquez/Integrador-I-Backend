package co.udea.gestionproyectos.api.repository;

import co.udea.gestionproyectos.api.model.Objetivo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ObjetivoRepository extends JpaRepository<Objetivo, Integer> {

    Optional<Objetivo> findByEspecifico(String especifico);
    Optional<Objetivo> findById(Integer id);
    List<Objetivo> findByIdProyecto(Integer idProyecto);

}

