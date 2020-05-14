package co.udea.gestionproyectos.api.repository;

import co.udea.gestionproyectos.api.model.EntregablesObjetivo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface EntregableRepository extends JpaRepository<EntregablesObjetivo, Integer> {

    Optional<EntregablesObjetivo> findByName(String name);
    Optional<EntregablesObjetivo> findById(Integer id);
    List<EntregablesObjetivo> findByIdObjetivoEspecifico_Id(Integer idObjetivoEspecifico);
}
