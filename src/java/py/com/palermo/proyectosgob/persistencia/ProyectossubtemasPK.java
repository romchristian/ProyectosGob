/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package py.com.palermo.proyectosgob.persistencia;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.validation.constraints.NotNull;

/**
 *
 * @author cromero
 */
@Embeddable
public class ProyectossubtemasPK implements Serializable {
    @Basic(optional = false)
    @NotNull
    @Column(name = "proyectosid")
    private short proyectosid;
    @Basic(optional = false)
    @NotNull
    @Column(name = "proyectosl5linea")
    private short proyectosl5linea;

    public ProyectossubtemasPK() {
    }

    public ProyectossubtemasPK(short proyectosid, short proyectosl5linea) {
        this.proyectosid = proyectosid;
        this.proyectosl5linea = proyectosl5linea;
    }

    public short getProyectosid() {
        return proyectosid;
    }

    public void setProyectosid(short proyectosid) {
        this.proyectosid = proyectosid;
    }

    public short getProyectosl5linea() {
        return proyectosl5linea;
    }

    public void setProyectosl5linea(short proyectosl5linea) {
        this.proyectosl5linea = proyectosl5linea;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) proyectosid;
        hash += (int) proyectosl5linea;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ProyectossubtemasPK)) {
            return false;
        }
        ProyectossubtemasPK other = (ProyectossubtemasPK) object;
        if (this.proyectosid != other.proyectosid) {
            return false;
        }
        if (this.proyectosl5linea != other.proyectosl5linea) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "py.com.palermo.proyectosgob.persistencia.ProyectossubtemasPK[ proyectosid=" + proyectosid + ", proyectosl5linea=" + proyectosl5linea + " ]";
    }
    
}
