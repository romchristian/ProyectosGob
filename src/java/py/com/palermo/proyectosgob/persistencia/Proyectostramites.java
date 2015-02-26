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
@Table(name = "proyectostramites")
@NamedQueries({
    @NamedQuery(name = "Proyectostramites.findAll", query = "SELECT p FROM Proyectostramites p")})
public class Proyectostramites implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected ProyectostramitesPK proyectostramitesPK;
    @Size(max = 300)
    @Column(name = "proyectosl3tramite")
    private String proyectosl3tramite;
    @Size(max = 20)
    @Column(name = "proyectosl3usuario")
    private String proyectosl3usuario;
    @JoinColumn(name = "proyectosid", referencedColumnName = "proyectosid", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Proyectos proyectos;

    public Proyectostramites() {
    }

    public Proyectostramites(ProyectostramitesPK proyectostramitesPK) {
        this.proyectostramitesPK = proyectostramitesPK;
    }

    public Proyectostramites(short proyectosid, short proyectosl3linea) {
        this.proyectostramitesPK = new ProyectostramitesPK(proyectosid, proyectosl3linea);
    }

    public ProyectostramitesPK getProyectostramitesPK() {
        return proyectostramitesPK;
    }

    public void setProyectostramitesPK(ProyectostramitesPK proyectostramitesPK) {
        this.proyectostramitesPK = proyectostramitesPK;
    }

    public String getProyectosl3tramite() {
        return proyectosl3tramite;
    }

    public void setProyectosl3tramite(String proyectosl3tramite) {
        this.proyectosl3tramite = proyectosl3tramite;
    }

    public String getProyectosl3usuario() {
        return proyectosl3usuario;
    }

    public void setProyectosl3usuario(String proyectosl3usuario) {
        this.proyectosl3usuario = proyectosl3usuario;
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
        hash += (proyectostramitesPK != null ? proyectostramitesPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Proyectostramites)) {
            return false;
        }
        Proyectostramites other = (Proyectostramites) object;
        if ((this.proyectostramitesPK == null && other.proyectostramitesPK != null) || (this.proyectostramitesPK != null && !this.proyectostramitesPK.equals(other.proyectostramitesPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "py.com.palermo.proyectosgob.persistencia.Proyectostramites[ proyectostramitesPK=" + proyectostramitesPK + " ]";
    }
    
}
