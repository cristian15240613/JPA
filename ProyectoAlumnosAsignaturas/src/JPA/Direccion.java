/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package JPA;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

/**
 *
 * @author crist
 */
@Entity
@Table (name = "direcciones")
public class Direccion implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Basic(optional = false)
    @Column(name = "id_dir")
    private Integer id_dir;

    public Integer getId() {
        return id_dir;
    }

    public void setId(Integer id) {
        this.id_dir = id;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id_dir != null ? id_dir.hashCode() : 0);
        return hash;
    }
    
    @OneToOne(cascade = CascadeType.ALL, mappedBy = "direccion")
    private Alumno alumno;

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Direccion)) {
            return false;
        }
        Direccion other = (Direccion) object;
        if ((this.id_dir == null && other.id_dir != null) || (this.id_dir != null && !this.id_dir.equals(other.id_dir))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "JPA.Direccion[ id=" + id_dir + " ]";
    }
    
}
