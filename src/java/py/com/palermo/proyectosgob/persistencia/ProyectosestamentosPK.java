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
public class ProyectosestamentosPK implements Serializable {
    @Basic(optional = false)
    @NotNull
    @Column(name = "proyectosid")
    private short proyectosid;
    @Basic(optional = false)
    @NotNull
    @Column(name = "proyectosl4linea")
    private short proyectosl4linea;

    public ProyectosestamentosPK() {
    }

    public ProyectosestamentosPK(short proyectosid, short proyectosl4linea) {
        this.proyectosid = proyectosid;
        this.proyectosl4linea = proyectosl4linea;
    }

    public short getProyectosid() {
        return proyectosid;
    }

    public void setProyectosid(short proyectosid) {
        this.proyectosid = proyectosid;
    }

    public short getProyectosl4linea() {
        return proyectosl4linea;
    }

    public void setProyectosl4linea(short proyectosl4linea) {
        this.proyectosl4linea = proyectosl4linea;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) proyectosid;
        hash += (int) proyectosl4linea;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ProyectosestamentosPK)) {
            return false;
        }
        ProyectosestamentosPK other = (ProyectosestamentosPK) object;
        if (this.proyectosid != other.proyectosid) {
            return false;
        }
        if (this.proyectosl4linea != other.proyectosl4linea) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "py.com.palermo.proyectosgob.persistencia.ProyectosestamentosPK[ proyectosid=" + proyectosid + ", proyectosl4linea=" + proyectosl4linea + " ]";
    }
    
}
