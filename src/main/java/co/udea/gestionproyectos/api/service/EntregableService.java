package co.udea.gestionproyectos.api.service;

import co.udea.gestionproyectos.api.exception.BusinessException;
import co.udea.gestionproyectos.api.exception.DataDuplicatedException;
import co.udea.gestionproyectos.api.model.EntregablesObjetivo;
import co.udea.gestionproyectos.api.model.ObjetivoEspecifico;
import co.udea.gestionproyectos.api.repository.EntregableRepository;
import co.udea.gestionproyectos.api.repository.ObjetivoRepository;
import co.udea.gestionproyectos.api.util.Messages;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EntregableService {

    private Messages messages;
    private EntregableRepository entregableRepository;
    private ObjetivoRepository objetivoRepository;


    public EntregableService(Messages messages, EntregableRepository entregableRepository, ObjetivoRepository objetivoRepository) {
        this.messages = messages;
        this.entregableRepository = entregableRepository;
        this.objetivoRepository = objetivoRepository;
    }

    public EntregablesObjetivo addEntregable(EntregablesObjetivo entregable){
        Optional<ObjetivoEspecifico> optionalObjetivo = objetivoRepository.findById(entregable.getIdObjetivoEspecifico().getId());
        if (!optionalObjetivo.isPresent()){
            throw new DataDuplicatedException(messages.get("exception.data_id_not_exist.entregable"));
        }
        if(entregable.getPorcentaje() <= 0 ){
            throw new DataDuplicatedException(messages.get("exception.data_duplicate_name.objetivoPorcentajeMenor"));
        }
        boolean confirmar = porcentajeEntregable(entregable);
        if(confirmar){
            Optional<EntregablesObjetivo> optionalEntregable = entregableRepository.findByName(entregable.getName());
            if(optionalEntregable.isPresent()){
                //System.out.println("estoy entrando al else");
                throw new DataDuplicatedException(messages.get("exception.data_duplicate_name.entregable"));
            }
            return entregableRepository.save(entregable);
        }
        else{

            throw new BusinessException(messages.get("exception.data_duplicate_name.entregablePorcentaje"));
        }
    }

    public List<EntregablesObjetivo> getEntregables(){

        if (entregableRepository.findAll().size() == 0){
            throw new BusinessException(messages.get("exception.data_not_found.entregable"));
        }
        return entregableRepository.findAll();
    }

    public EntregablesObjetivo getEntregable(Integer id){
        if (entregableRepository.findAll().size() == 0){
            throw new BusinessException(messages.get("exception.data_not_found.entregable"));
        }else {
            Optional<EntregablesObjetivo> optionalEntregable = entregableRepository.findById(id);
            return optionalEntregable.get();
        }
    }

    public void updateEntregable(EntregablesObjetivo entregable){
        Optional<EntregablesObjetivo> optionalEntregable = entregableRepository.findById(entregable.getId());
        if(!optionalEntregable.isPresent()){
            throw new BusinessException(messages.get("El entregable no existe"));
        }//TODO:
        optionalEntregable.get().setName(entregable.getName());
        optionalEntregable.get().setPorcentaje(entregable.getPorcentaje());
        addEntregable(optionalEntregable.get());
    }

    public void deleteEntregable(Integer id){
        entregableRepository.deleteById(id);
    }

    public List<EntregablesObjetivo> getEntregableObjetivo(Integer idObjetivo){
        if (entregableRepository.findByIdObjetivoEspecifico_id(idObjetivo).size()==0){
            throw new BusinessException(messages.get("exception.data_not_found.objetivo"));
        }

        return entregableRepository.findByIdObjetivoEspecifico_id(idObjetivo);
    }

    public boolean porcentajeEntregable(EntregablesObjetivo entregablesObjetivo){
        float cont=0;
        Optional<ObjetivoEspecifico> estado;
        List<EntregablesObjetivo> aux = entregableRepository.findByIdObjetivoEspecifico_id(entregablesObjetivo.getIdObjetivoEspecifico().getId());
        for(int i=0;i<entregableRepository.findByIdObjetivoEspecifico_id(entregablesObjetivo.getIdObjetivoEspecifico().getId()).size();i++){
            cont += aux.get(i).getPorcentaje();
        }
        cont += entregablesObjetivo.getPorcentaje();
        if(cont<=100){
            /*System.out.println("tamaño: ->   " + aux.size());
            System.out.println("lo que me trae: ->   " + aux.get(0).getPorcentaje());
            System.out.println("lo que me trae: ->   " + aux.get(1).getPorcentaje());
            //System.out.println("lo que me trae: ->   " + aux.get(2).getPorcentaje());
            System.out.println("lo que me trae: ->   " + cont);*/
            estado = objetivoRepository.findById(entregablesObjetivo.getIdObjetivoEspecifico().getId());
            estado.get().setEstadoObjetivo(cont);
            //funcionaba solo con darle set no habia necesidad de guardarlo
            //System.out.println("lo que trae: -> " + estado.get().getEstadoObjetivo());
            return true;
        }else{
            return false;
        }

    }

}
