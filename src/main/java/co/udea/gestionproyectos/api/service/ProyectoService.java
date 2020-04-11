package co.udea.gestionproyectos.api.service;

import co.udea.gestionproyectos.api.repository.ProyectoRepository;
import org.springframework.stereotype.Service;
import co.udea.gestionproyectos.api.util.Messages;

@Service
public class ProyectoService {

    private Messages messages;
    private ProyectoRepository proyectoRepository;

    public ProyectoService(ProyectoRepository proyectoRepository, Messages messages){
        this.proyectoRepository = proyectoRepository;
        this.messages = messages;
    }
}
