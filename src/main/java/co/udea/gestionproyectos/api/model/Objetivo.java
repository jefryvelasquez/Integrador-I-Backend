package co.udea.gestionproyectos.api.model;

import javax.persistence.*;
import javax.validation.constraints.NotNull;


@Entity
@Table(name = "objetivos")
public class Objetivo {


    @Id
    @Column(name = "id")
    @GeneratedValue
    private Integer id;

    @NotNull
    @ManyToOne
    @JoinColumn(name = "idProyecto")
    private Proyecto idProyecto;

    @NotNull
    @Column(name = "especifico")
    private String especifico;

    @NotNull
    @Column(name = "general")
    private String general;

    @NotNull
    @Column(name = "porcentaje")
    private float porcenteje;

    public Objetivo() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getEspecifico() {
        return especifico;
    }

    public void setEspecifico(String especifico) {
        this.especifico = especifico;
    }

    public String getGeneral() {
        return general;
    }

    public void setGeneral(String general) {
        this.general = general;
    }

    public Proyecto getIdProyecto() {
        return idProyecto;
    }

    public void setIdProyecto(Proyecto idProyecto) {
        this.idProyecto = idProyecto;
    }

    public float getPorcenteje() {
        return porcenteje;
    }

    public void setPorcenteje(float porcenteje) {
        this.porcenteje = porcenteje;
    }
}


