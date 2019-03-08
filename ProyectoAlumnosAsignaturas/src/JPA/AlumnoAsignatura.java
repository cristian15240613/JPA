package JPA;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class AlumnoAsignatura implements Serializable {

    @EmbeddedId
    protected AlumnoAsignaturaPK alumnoAsignaturaPK;
    @Basic (optional = false)
    @Column(name = "cursada")
    private Character cursada;
    
    @JoinColumn(name = "id_alumno", referencedColumnName = "id_alumno", insertable = false, updatable = false)
    @ManyToOne (optional = false)
    private Alumno alumno;
    
    @JoinColumn(name = "id_asignatura", referencedColumnName = "id_asignatura", insertable = false, updatable = false)
    @ManyToOne (optional = false)
    private Asignatura asignatura;

    public AlumnoAsignatura() {
    }

    public AlumnoAsignatura(int idAlumno, int idAsignatura) {
        alumnoAsignaturaPK = new AlumnoAsignaturaPK(idAlumno, idAsignatura);
    }
    
    public Character getCursada() {
        return cursada;
    }

    public void setCursada(Character cursada) {
        this.cursada = cursada;
    }

    public Alumno getAlumno() {
        return alumno;
    }

    public void setAlumno(Alumno alumno) {
        this.alumno = alumno;
    }

    public Asignatura getAsignatura() {
        return asignatura;
    }

    public void setAsignatura(Asignatura asignatura) {
        this.asignatura = asignatura;
    }
}
