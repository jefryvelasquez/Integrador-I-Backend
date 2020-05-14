package co.udea.gestionproyectos.api.model;

import javax.persistence.*;
import javax.validation.constraints.NotNull;


@Entity
@Table(name = "entregables")
public class EntregablesObjetivo {

    @Id
    @Column(name = "id")
    @GeneratedValue
    private Integer id;

    @NotNull
    @ManyToOne
    @JoinColumn(name = "idObjetivoEspecifico")
    private ObjetivoEspecifico idObjetivoEspecifico;

    @NotNull
    @Column(name = "name")
    private String name;

    @NotNull
    @Column(name = "porcentaje")
    private Float porcentaje;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public ObjetivoEspecifico getIdObjetivoEspecifico() {
        return idObjetivoEspecifico;
    }

    public void setIdObjetivoEspecifico(ObjetivoEspecifico idObjetivoEspecifico) {
        this.idObjetivoEspecifico = idObjetivoEspecifico;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Float getPorcentaje() {
        return porcentaje;
    }

    public void setPorcentaje(Float porcentaje) {
        this.porcentaje = porcentaje;
    }
}
