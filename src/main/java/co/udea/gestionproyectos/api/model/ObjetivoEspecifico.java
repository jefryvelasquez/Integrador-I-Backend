package co.udea.gestionproyectos.api.model;

import javax.persistence.*;
import javax.validation.constraints.NotNull;


@Entity
@Table(name = "objetivos")
public class ObjetivoEspecifico {


    @Id
    @Column(name = "id")
    @GeneratedValue (strategy=GenerationType.IDENTITY)
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
    private float porcentaje;

    @NotNull
    @Column(name = "entregable")
    private String entregable;

    @NotNull
    @Column(name = "estadoObjetivo")
    private float estadoObjetivo;

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

    public float getPorcentaje() {
        return porcentaje;
    }

    public void setPorcentaje(float porcenteje) {
        this.porcentaje = porcenteje;
    }

    public String getEntregable() {
        return entregable;
    }

    public void setEntregable(String entregable) {
        this.entregable = entregable;
    }

    public float getEstadoObjetivo() {
        return estadoObjetivo;
    }

    public void setEstadoObjetivo(float estadoObjetivo) {
        this.estadoObjetivo = estadoObjetivo;
    }
}


