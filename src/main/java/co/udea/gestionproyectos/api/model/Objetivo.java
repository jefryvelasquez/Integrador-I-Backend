package co.udea.gestionproyectos.api.model;

import com.sun.istack.NotNull;

import javax.persistence.*;

@Entity
@Table(name = "objetivos")
public class Objetivo {


    @Id
    @Column(name = "idProyecto")
    @GeneratedValue
    private Integer id;

    @NotNull
    @Column(name = "especifico")
    private String especifico;

    @NotNull
    @Column(name = "general")
    private String general;

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
}

