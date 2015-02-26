/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package py.com.palermo.proyectosgob.persistencia;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.Size;

/**
 *
 * @author cromero
 */
@Entity
@Table(name = "proyectossubtemas")
@NamedQueries({
    @NamedQuery(name = "Proyectossubtemas.findAll", query = "SELECT p FROM Proyectossubtemas p")})
public class Proyectossubtemas implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected ProyectossubtemasPK proyectossubtemasPK;
    @Size(max = 20)
    @Column(name = "proyectosl5usuario")
    private String proyectosl5usuario;
    @JoinColumn(name = "subtemasid", referencedColumnName = "subtemasid")
    @ManyToOne
    private Subtemas subtemasid;
    @JoinColumn(name = "proyectosid", referencedColumnName = "proyectosid", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Proyectos proyectos;

    public Proyectossubtemas() {
    }

    public Proyectossubtemas(ProyectossubtemasPK proyectossubtemasPK) {
        this.proyectossubtemasPK = proyectossubtemasPK;
    }

    public Proyectossubtemas(short proyectosid, short proyectosl5linea) {
        this.proyectossubtemasPK = new ProyectossubtemasPK(proyectosid, proyectosl5linea);
    }

    public ProyectossubtemasPK getProyectossubtemasPK() {
        return proyectossubtemasPK;
    }

    public void setProyectossubtemasPK(ProyectossubtemasPK proyectossubtemasPK) {
        this.proyectossubtemasPK = proyectossubtemasPK;
    }

    public String getProyectosl5usuario() {
        return proyectosl5usuario;
    }

    public void setProyectosl5usuario(String proyectosl5usuario) {
        this.proyectosl5usuario = proyectosl5usuario;
    }

    public Subtemas getSubtemasid() {
        return subtemasid;
    }

    public void setSubtemasid(Subtemas subtemasid) {
        this.subtemasid = subtemasid;
    }

    public Proyectos getProyectos() {
        return proyectos;
    }

    public void setProyectos(Proyectos proyectos) {
        this.proyectos = proyectos;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (proyectossubtemasPK != null ? proyectossubtemasPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Proyectossubtemas)) {
            return false;
        }
        Proyectossubtemas other = (Proyectossubtemas) object;
        if ((this.proyectossubtemasPK == null && other.proyectossubtemasPK != null) || (this.proyectossubtemasPK != null && !this.proyectossubtemasPK.equals(other.proyectossubtemasPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "py.com.palermo.proyectosgob.persistencia.Proyectossubtemas[ proyectossubtemasPK=" + proyectossubtemasPK + " ]";
    }
    
}
