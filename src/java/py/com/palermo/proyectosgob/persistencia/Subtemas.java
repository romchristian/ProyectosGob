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
@Table(name = "subtemas")
@NamedQueries({
    @NamedQuery(name = "Subtemas.findAll", query = "SELECT s FROM Subtemas s")})
public class Subtemas implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "subtemasid")
    private Short subtemasid;
    @Size(max = 85)
    @Column(name = "subtemasnombre")
    private String subtemasnombre;
    @Column(name = "subtemasestado")
    private Short subtemasestado;
    @OneToMany(mappedBy = "subtemasid")
    private List<Proyectossubtemas> proyectossubtemasList;

    public Subtemas() {
    }

    public Subtemas(Short subtemasid) {
        this.subtemasid = subtemasid;
    }

    public Short getSubtemasid() {
        return subtemasid;
    }

    public void setSubtemasid(Short subtemasid) {
        this.subtemasid = subtemasid;
    }

    public String getSubtemasnombre() {
        return subtemasnombre;
    }

    public void setSubtemasnombre(String subtemasnombre) {
        this.subtemasnombre = subtemasnombre;
    }

    public Short getSubtemasestado() {
        return subtemasestado;
    }

    public void setSubtemasestado(Short subtemasestado) {
        this.subtemasestado = subtemasestado;
    }

    public List<Proyectossubtemas> getProyectossubtemasList() {
        return proyectossubtemasList;
    }

    public void setProyectossubtemasList(List<Proyectossubtemas> proyectossubtemasList) {
        this.proyectossubtemasList = proyectossubtemasList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (subtemasid != null ? subtemasid.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Subtemas)) {
            return false;
        }
        Subtemas other = (Subtemas) object;
        if ((this.subtemasid == null && other.subtemasid != null) || (this.subtemasid != null && !this.subtemasid.equals(other.subtemasid))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "py.com.palermo.proyectosgob.persistencia.Subtemas[ subtemasid=" + subtemasid + " ]";
    }
    
}
