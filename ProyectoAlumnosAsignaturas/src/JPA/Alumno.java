package JPA;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Transient;

@Entity
@Table(name = "alumnos")
public class Alumno implements Serializable {

    public Alumno(){
        
    }
    
    public Alumno(Integer idAlumno, String apellidos, String nombre, int curso, int titulacion) {
        this.idAlumno = idAlumno;
        this.apellidos = apellidos;
        this.nombre = nombre;
        this.curso = curso;
        this.titulacion = titulacion;
    }
    
    @Transient
    private int edad;

    @Id
    @Basic(optional = false)
    @Column(name = "id_alumno")
    private Integer idAlumno;
    
    @Basic(optional = false)
    @Column(name = "apellidos")
    private String apellidos;
    
    @Basic(optional = false)
    @Column(name = "nombre")
    private String nombre;
    
    @Basic(optional = false)
    @Column(name = "curso")
    private int curso;
    
    @Basic(optional = false)
    @Column(name = "titulacion")
    private int titulacion;
    
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "alumno")
    private Collection<AlumnoAsignatura> alumnoAsignaturaCollection;
    
    @OneToOne(optional = false)
    @JoinColumn(name = "id_dir", referencedColumnName = "id_dir")
    private Direccion direccion;
    
    public Integer getId() {
        return idAlumno;
    }

    public void setId(Integer id) {
        this.idAlumno = id;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getCurso() {
        return curso;
    }

    public void setCurso(int curso) {
        this.curso = curso;
    }

    public int getTitulacion() {
        return titulacion;
    }

    public void setTitulacion(int titulacion) {
        this.titulacion = titulacion;
    }
    
    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idAlumno != null ? idAlumno.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Alumno)) {
            return false;
        }
        Alumno other = (Alumno) object;
        if ((this.idAlumno == null && other.idAlumno != null) || (this.idAlumno != null && !this.idAlumno.equals(other.idAlumno))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "JPA.Alumno[ id=" + idAlumno + " ]";
    }
    
}
