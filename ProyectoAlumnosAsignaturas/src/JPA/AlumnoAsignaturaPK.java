package JPA;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class AlumnoAsignaturaPK implements Serializable{
    
    @Basic(optional = false)
    @Column(name = "id_alumno")
    private int idAlumno;
    
    @Basic(optional = false)
    @Column(name = "id_asignatura")
    private int idAsignatura;

    public AlumnoAsignaturaPK() {
    }

    public AlumnoAsignaturaPK(int idAlumno, int idAsignatura) {
        this.idAlumno = idAlumno;
        this.idAsignatura = idAsignatura;
    }

    public int getIdAlumno() {
        return idAlumno;
    }

    public void setIdAlumno(int idAlumno) {
        this.idAlumno = idAlumno;
    }

    public int getIdAsignatura() {
        return idAsignatura;
    }

    public void setIdAsignatura(int idAsignatura) {
        this.idAsignatura = idAsignatura;
    }
    
    
    
}
