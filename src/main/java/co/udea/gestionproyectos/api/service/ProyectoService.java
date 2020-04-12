package co.udea.gestionproyectos.api.service;

import co.udea.gestionproyectos.api.exception.BusinessException;
import co.udea.gestionproyectos.api.exception.DataDuplicatedException;
import co.udea.gestionproyectos.api.model.Proyecto;
import co.udea.gestionproyectos.api.repository.ProyectoRepository;
import org.springframework.stereotype.Service;
import co.udea.gestionproyectos.api.util.Messages;

import java.util.List;
import java.util.Optional;

@Service
public class ProyectoService {

    private Messages messages;
    private ProyectoRepository proyectoRepository;

    public ProyectoService(ProyectoRepository proyectoRepository, Messages messages){
        this.proyectoRepository = proyectoRepository;
        this.messages = messages;
    }

    public Proyecto addProyecto(Proyecto proyecto){
        Optional<Proyecto> optionalProyecto = proyectoRepository.findByName(proyecto.getName());
        if(optionalProyecto.isPresent()){
            throw new DataDuplicatedException(messages.get("exception.data_duplicate_name.proyecto"));
        }

        return proyectoRepository.save(proyecto);
    }

    public List<Proyecto> getProyectos(){

        if (proyectoRepository.findAll().size() == 0){
            throw new BusinessException(messages.get("exception.data_not_found.proyecto"));
        }
        return proyectoRepository.findAll();
    }
}
