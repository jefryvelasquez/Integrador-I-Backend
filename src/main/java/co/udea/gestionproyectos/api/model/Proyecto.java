package co.udea.gestionproyectos.api.model;


import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Date;

@Entity
@Table(name = "proyectos")
public class Proyecto {

    @Id
    @Column(name = "id")
    @GeneratedValue
    private Integer id;

    @NotNull
    @Column(name = "nombre")
    private String name;

    @NotNull
    @Column(name = "responsable")
    private String responsable;

    @Column(name = "modalidad")
    private String modalidad;

    @NotNull
    @Column(name = "asesor")
    private String asesor;


    @NotNull
    @Column(name = "fecha_Creacion")
    private Date fecha_Creacion;

    @Column(name = "fecha_Inicial")
    private Date fecha_Inicial;

    @Column(name = "fecha_Final")
    private Date fecha_Final;

    @NotNull
    @Column(name = "objetivos")
    private String objetivos;

    public Proyecto() {
    }

    public Proyecto(int id, String name, String responsable, String modalidad, String asesor, Date fecha_Creacion,
                    Date fecha_Inicial, Date fecha_Final, String objetivos) {

        this.name = name;
        this.asesor = asesor;
        this.responsable = responsable;
        this.modalidad = modalidad;
        this.objetivos = objetivos;
        this.fecha_Creacion = fecha_Creacion;
        this.fecha_Inicial = fecha_Inicial;
        this.fecha_Final = fecha_Final;


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

    public String getResponsable() {
        return responsable;
    }

    public void setResponsable(String responsable) {
        this.responsable = responsable;
    }

    public String getModalidad() {
        return modalidad;
    }

    public void setModalidad(String modalidad) {
        this.modalidad = modalidad;
    }

    public String getAsesor() {
        return asesor;
    }

    public void setAsesor(String asesor) {
        this.asesor = asesor;
    }

    public Date getFecha_Creacion() {
        return fecha_Creacion;
    }

    public void setFecha_Creacion(Date fecha_Creacion) {
        this.fecha_Creacion = fecha_Creacion;
    }

    public Date getFecha_Inicial() {
        return fecha_Inicial;
    }

    public void setFecha_Inicial(Date fecha_Inicial) {
        this.fecha_Inicial = fecha_Inicial;
    }

    public Date getFecha_Final() {
        return fecha_Final;
    }

    public void setFecha_Final(Date fecha_Final) {
        this.fecha_Final = fecha_Final;
    }

    public String getObjetivos() {
        return objetivos;
    }

    public void setObjetivos(String objetivos) {
        this.objetivos = objetivos;
    }

    @Override
    public String toString() {
        return "Proyecto{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", responsable='" + responsable + '\'' +
                ", modalidad='" + modalidad + '\'' +
                ", asesor='" + asesor + '\'' +
                ", fecha_Creacion=" + fecha_Creacion +
                ", fecha_Inicial=" + fecha_Inicial +
                ", fecha_Final=" + fecha_Final +
                ", objetivos='" + objetivos + '\'' +
                '}';
    }
}


