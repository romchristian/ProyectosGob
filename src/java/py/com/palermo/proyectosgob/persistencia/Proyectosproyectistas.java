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
@Table(name = "proyectosproyectistas")
@NamedQueries({
    @NamedQuery(name = "Proyectosproyectistas.findAll", query = "SELECT p FROM Proyectosproyectistas p")})
public class Proyectosproyectistas implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected ProyectosproyectistasPK proyectosproyectistasPK;
    @Size(max = 20)
    @Column(name = "proyectosl1usuario")
    private String proyectosl1usuario;
    @JoinColumn(name = "proyectosid", referencedColumnName = "proyectosid", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Proyectos proyectos;
    @JoinColumn(name = "proyectistasid", referencedColumnName = "proyectistasid", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Proyectistas proyectistas;

    public Proyectosproyectistas() {
    }

    public Proyectosproyectistas(ProyectosproyectistasPK proyectosproyectistasPK) {
        this.proyectosproyectistasPK = proyectosproyectistasPK;
    }

    public Proyectosproyectistas(short proyectosid, short proyectistasid) {
        this.proyectosproyectistasPK = new ProyectosproyectistasPK(proyectosid, proyectistasid);
    }

    public ProyectosproyectistasPK getProyectosproyectistasPK() {
        return proyectosproyectistasPK;
    }

    public void setProyectosproyectistasPK(ProyectosproyectistasPK proyectosproyectistasPK) {
        this.proyectosproyectistasPK = proyectosproyectistasPK;
    }

    public String getProyectosl1usuario() {
        return proyectosl1usuario;
    }

    public void setProyectosl1usuario(String proyectosl1usuario) {
        this.proyectosl1usuario = proyectosl1usuario;
    }

    public Proyectos getProyectos() {
        return proyectos;
    }

    public void setProyectos(Proyectos proyectos) {
        this.proyectos = proyectos;
    }

    public Proyectistas getProyectistas() {
        return proyectistas;
    }

    public void setProyectistas(Proyectistas proyectistas) {
        this.proyectistas = proyectistas;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (proyectosproyectistasPK != null ? proyectosproyectistasPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Proyectosproyectistas)) {
            return false;
        }
        Proyectosproyectistas other = (Proyectosproyectistas) object;
        if ((this.proyectosproyectistasPK == null && other.proyectosproyectistasPK != null) || (this.proyectosproyectistasPK != null && !this.proyectosproyectistasPK.equals(other.proyectosproyectistasPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "py.com.palermo.proyectosgob.persistencia.Proyectosproyectistas[ proyectosproyectistasPK=" + proyectosproyectistasPK + " ]";
    }
    
}
