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
public class ProyectosobjetivosPK implements Serializable {
    @Basic(optional = false)
    @NotNull
    @Column(name = "proyectosid")
    private short proyectosid;
    @Basic(optional = false)
    @NotNull
    @Column(name = "proyectosl2linea")
    private short proyectosl2linea;

    public ProyectosobjetivosPK() {
    }

    public ProyectosobjetivosPK(short proyectosid, short proyectosl2linea) {
        this.proyectosid = proyectosid;
        this.proyectosl2linea = proyectosl2linea;
    }

    public short getProyectosid() {
        return proyectosid;
    }

    public void setProyectosid(short proyectosid) {
        this.proyectosid = proyectosid;
    }

    public short getProyectosl2linea() {
        return proyectosl2linea;
    }

    public void setProyectosl2linea(short proyectosl2linea) {
        this.proyectosl2linea = proyectosl2linea;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) proyectosid;
        hash += (int) proyectosl2linea;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ProyectosobjetivosPK)) {
            return false;
        }
        ProyectosobjetivosPK other = (ProyectosobjetivosPK) object;
        if (this.proyectosid != other.proyectosid) {
            return false;
        }
        if (this.proyectosl2linea != other.proyectosl2linea) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "py.com.palermo.proyectosgob.persistencia.ProyectosobjetivosPK[ proyectosid=" + proyectosid + ", proyectosl2linea=" + proyectosl2linea + " ]";
    }
    
}
