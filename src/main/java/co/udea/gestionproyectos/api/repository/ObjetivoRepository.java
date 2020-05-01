package co.udea.gestionproyectos.api.repository;

import co.udea.gestionproyectos.api.model.ObjetivoEspecifico;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ObjetivoRepository extends JpaRepository<ObjetivoEspecifico, Integer> {

    Optional<ObjetivoEspecifico> findByName(String name);
    Optional<ObjetivoEspecifico> findById(Integer id);
    List<ObjetivoEspecifico> findByIdProyecto_id(Integer idProyecto);

}

