package co.udea.gestionproyectos.api.model;

import javax.persistence.*;
import javax.validation.constraints.NotNull;


@Entity
@Table(name = "objetivos")
public class ObjetivoEspecifico {


    @Id
    @Column(name = "id")
    @GeneratedValue
    private Integer id;

    @NotNull
    @ManyToOne
    @JoinColumn(name = "idProyecto")
    private Proyecto idProyecto;

    @NotNull
    @Column(name = "name")
    private String name;


    @NotNull
    @Column(name = "porcentaje")
    private float porcenteje;

    public ObjetivoEspecifico() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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


