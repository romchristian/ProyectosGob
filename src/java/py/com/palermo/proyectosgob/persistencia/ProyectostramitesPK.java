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
public class ProyectostramitesPK implements Serializable {
    @Basic(optional = false)
    @NotNull
    @Column(name = "proyectosid")
    private short proyectosid;
    @Basic(optional = false)
    @NotNull
    @Column(name = "proyectosl3linea")
    private short proyectosl3linea;

    public ProyectostramitesPK() {
    }

    public ProyectostramitesPK(short proyectosid, short proyectosl3linea) {
        this.proyectosid = proyectosid;
        this.proyectosl3linea = proyectosl3linea;
    }

    public short getProyectosid() {
        return proyectosid;
    }

    public void setProyectosid(short proyectosid) {
        this.proyectosid = proyectosid;
    }

    public short getProyectosl3linea() {
        return proyectosl3linea;
    }

    public void setProyectosl3linea(short proyectosl3linea) {
        this.proyectosl3linea = proyectosl3linea;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) proyectosid;
        hash += (int) proyectosl3linea;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ProyectostramitesPK)) {
            return false;
        }
        ProyectostramitesPK other = (ProyectostramitesPK) object;
        if (this.proyectosid != other.proyectosid) {
            return false;
        }
        if (this.proyectosl3linea != other.proyectosl3linea) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "py.com.palermo.proyectosgob.persistencia.ProyectostramitesPK[ proyectosid=" + proyectosid + ", proyectosl3linea=" + proyectosl3linea + " ]";
    }
    
}
