package co.udea.gestionproyectos.api.service;

import co.udea.gestionproyectos.api.exception.BusinessException;
import co.udea.gestionproyectos.api.exception.DataDuplicatedException;
import co.udea.gestionproyectos.api.model.Objetivo;
import co.udea.gestionproyectos.api.repository.ObjetivoRepository;
import co.udea.gestionproyectos.api.util.Messages;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ObjetivoService {

    private Messages messages;
    private ObjetivoRepository objetivoRepository;

    public ObjetivoService(ObjetivoRepository objetivoRepository, Messages messages){
        this.objetivoRepository = objetivoRepository;
        this.messages = messages;
    }

    public Objetivo addObejtivo(Objetivo objetivo){
        Optional<Objetivo> optionalObjetivo = objetivoRepository.findByEspecifico(objetivo.getEspecifico());
        if(optionalObjetivo.isPresent()){
            throw new DataDuplicatedException(messages.get("exception.data_duplicate_name.proyecto"));
        }

        return objetivoRepository.save(objetivo);
    }

    public List<Objetivo> getObjetivos(){

        if (objetivoRepository.findAll().size() == 0){
            throw new BusinessException(messages.get("exception.data_not_found.proyecto"));
        }
        return objetivoRepository.findAll();
    }

    public Objetivo getObjetivo(Integer id){
        if (objetivoRepository.findAll().size() == 0){
            throw new BusinessException(messages.get("exception.data_not_found.objetivo"));
        }else {
            Optional<Objetivo> optionalObjetivo = objetivoRepository.findById(id);
            return optionalObjetivo.get();
        }
    }

    public Objetivo updateObjetivo(Objetivo objetivo){
        Optional<Objetivo> optionalObjetivo = objetivoRepository.findByEspecifico(objetivo.getEspecifico());
        if(!optionalObjetivo.isPresent()){
            throw new BusinessException(messages.get("El objetivo no existe"));
        }//TODO:
        return objetivoRepository.save(objetivo);
    }

    public void deleteObjetivo(Integer id){
        objetivoRepository.deleteById(id);
    }
}

