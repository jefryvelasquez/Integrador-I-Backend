package co.udea.gestionproyectos.api.service;

import co.udea.gestionproyectos.api.exception.BusinessException;
import co.udea.gestionproyectos.api.exception.DataDuplicatedException;
import co.udea.gestionproyectos.api.model.ObjetivoEspecifico;
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

    public ObjetivoEspecifico addObjetivo(ObjetivoEspecifico objetivo){
        boolean confirmar = confirmarPorcentaje(objetivo);
        if(confirmar){
        Optional<ObjetivoEspecifico> optionalObjetivo = objetivoRepository.findByName(objetivo.getName());
        if(optionalObjetivo.isPresent()){
            throw new DataDuplicatedException(messages.get("exception.data_duplicate_name.objetivo"));
        }
        return objetivoRepository.save(objetivo);
        }
        else{
            throw new BusinessException(messages.get("exception.data_duplicate_name.objetivoPorcentaje"));
        }
    }

    public List<ObjetivoEspecifico> getObjetivos(){

        if (objetivoRepository.findAll().size() == 0){
            throw new BusinessException(messages.get("exception.data_not_found.objetivo"));
        }
        return objetivoRepository.findAll();
    }

    public ObjetivoEspecifico getObjetivo(Integer id){
        if (objetivoRepository.findAll().size() == 0){
            throw new BusinessException(messages.get("exception.data_not_found.objetivo"));
        }else {
            Optional<ObjetivoEspecifico> optionalObjetivo = objetivoRepository.findById(id);
            return optionalObjetivo.get();
        }
    }

    public void updateObjetivo(ObjetivoEspecifico objetivo){
        Optional<ObjetivoEspecifico> optionalObjetivo = objetivoRepository.findById(objetivo.getId());
        if(!optionalObjetivo.isPresent()){
            throw new BusinessException(messages.get("El objetivo no existe"));
        }//TODO:
        optionalObjetivo.get().setName(objetivo.getName());
        addObjetivo(optionalObjetivo.get());
    }

    public void deleteObjetivo(Integer id){
        objetivoRepository.deleteById(id);
    }

    public List<ObjetivoEspecifico> getObjetivosProyecto(Integer idProyecto){
        if (objetivoRepository.findByIdProyecto_id(idProyecto).size()==0){
            throw new BusinessException(messages.get("exception.data_not_found.objetivo"));
        }
        //preguntar por findByIdProyecto
        return objetivoRepository.findByIdProyecto_id(idProyecto);
    }

    public boolean confirmarPorcentaje(ObjetivoEspecifico objetivoEspecifico){
        float cont=0;
        List<ObjetivoEspecifico> aux = objetivoRepository.findByIdProyecto_id(objetivoEspecifico.getIdProyecto().getId());
        for(int i=0;i<objetivoRepository.findByIdProyecto_id(objetivoEspecifico.getIdProyecto().getId()).size();i++){
                cont += aux.get(i).getPorcenteje();
        }
        cont += objetivoEspecifico.getPorcenteje();
        if(cont<=100){
           return true;
        }else{
            return false;
        }

    }
}

