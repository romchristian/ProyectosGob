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
public class ProyectosproyectistasPK implements Serializable {
    @Basic(optional = false)
    @NotNull
    @Column(name = "proyectosid")
    private short proyectosid;
    @Basic(optional = false)
    @NotNull
    @Column(name = "proyectistasid")
    private short proyectistasid;

    public ProyectosproyectistasPK() {
    }

    public ProyectosproyectistasPK(short proyectosid, short proyectistasid) {
        this.proyectosid = proyectosid;
        this.proyectistasid = proyectistasid;
    }

    public short getProyectosid() {
        return proyectosid;
    }

    public void setProyectosid(short proyectosid) {
        this.proyectosid = proyectosid;
    }

    public short getProyectistasid() {
        return proyectistasid;
    }

    public void setProyectistasid(short proyectistasid) {
        this.proyectistasid = proyectistasid;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) proyectosid;
        hash += (int) proyectistasid;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ProyectosproyectistasPK)) {
            return false;
        }
        ProyectosproyectistasPK other = (ProyectosproyectistasPK) object;
        if (this.proyectosid != other.proyectosid) {
            return false;
        }
        if (this.proyectistasid != other.proyectistasid) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "py.com.palermo.proyectosgob.persistencia.ProyectosproyectistasPK[ proyectosid=" + proyectosid + ", proyectistasid=" + proyectistasid + " ]";
    }
    
}
