/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package py.com.palermo.proyectosgob.persistencia;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 *
 * @author cromero
 */
@Entity
@Table(name = "materias")
@NamedQueries({
    @NamedQuery(name = "Materias.findAll", query = "SELECT m FROM Materias m")})
public class Materias implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "materiasid")
    private Short materiasid;
    @Size(max = 85)
    @Column(name = "materiasnombre")
    private String materiasnombre;
    @Column(name = "materiasestado")
    private Short materiasestado;
    @OneToMany(mappedBy = "materiasid")
    private List<Proyectos> proyectosList;

    public Materias() {
    }

    public Materias(Short materiasid) {
        this.materiasid = materiasid;
    }

    public Short getMateriasid() {
        return materiasid;
    }

    public void setMateriasid(Short materiasid) {
        this.materiasid = materiasid;
    }

    public String getMateriasnombre() {
        return materiasnombre;
    }

    public void setMateriasnombre(String materiasnombre) {
        this.materiasnombre = materiasnombre;
    }

    public Short getMateriasestado() {
        return materiasestado;
    }

    public void setMateriasestado(Short materiasestado) {
        this.materiasestado = materiasestado;
    }

    public List<Proyectos> getProyectosList() {
        return proyectosList;
    }

    public void setProyectosList(List<Proyectos> proyectosList) {
        this.proyectosList = proyectosList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (materiasid != null ? materiasid.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Materias)) {
            return false;
        }
        Materias other = (Materias) object;
        if ((this.materiasid == null && other.materiasid != null) || (this.materiasid != null && !this.materiasid.equals(other.materiasid))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "py.com.palermo.proyectosgob.persistencia.Materias[ materiasid=" + materiasid + " ]";
    }
    
}
