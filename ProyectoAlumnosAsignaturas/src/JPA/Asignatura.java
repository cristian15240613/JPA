/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
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
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 *
 * @author crist
 */
@Entity
@Table (name = "asignaturas")
public class Asignatura implements Serializable {

    public Asignatura(){
        
    }

    public Asignatura(Integer id_asignatura, String tipo, String nombre, float creditos) {
        this.id_asignatura = id_asignatura;
        this.tipo = tipo;
        this.nombre = nombre;
        this.creditos = creditos;
    }
    
    @Id
    @Basic (optional = false)
    @Column (name = "id_asignatura")
    private Integer id_asignatura;
    
    @Basic(optional = false)
    @Column(name = "tipo")
    private String tipo;
    
    @Basic(optional = false)
    @Column(name = "nombre")
    private String nombre;
    
    @Basic(optional = false)
    @Column(name = "creditos")
    private float creditos;
    
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "asignatura")
    private Collection<AlumnoAsignatura> alumnoAsignaturaCollection;
    
    public Integer getIdAsignatura() {
        return id_asignatura;
    }

    public void setIdAsignatura(Integer id) {
        this.id_asignatura = id;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public float getCreditos() {
        return creditos;
    }

    public void setCreditos(float creditos) {
        this.creditos = creditos;
    }
    
    

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id_asignatura != null ? id_asignatura.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Asignatura)) {
            return false;
        }
        Asignatura other = (Asignatura) object;
        if ((this.id_asignatura == null && other.id_asignatura != null) || (this.id_asignatura != null && !this.id_asignatura.equals(other.id_asignatura))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "JPA.Asignatura[ id=" + id_asignatura + " ]";
    }
    
}
