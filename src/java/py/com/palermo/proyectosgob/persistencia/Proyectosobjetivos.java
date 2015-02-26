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
@Table(name = "proyectosobjetivos")
@NamedQueries({
    @NamedQuery(name = "Proyectosobjetivos.findAll", query = "SELECT p FROM Proyectosobjetivos p")})
public class Proyectosobjetivos implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected ProyectosobjetivosPK proyectosobjetivosPK;
    @Size(max = 300)
    @Column(name = "proyectosl2objetivo")
    private String proyectosl2objetivo;
    @Size(max = 20)
    @Column(name = "proyectosl2usuario")
    private String proyectosl2usuario;
    @JoinColumn(name = "proyectosid", referencedColumnName = "proyectosid", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Proyectos proyectos;

    public Proyectosobjetivos() {
    }

    public Proyectosobjetivos(ProyectosobjetivosPK proyectosobjetivosPK) {
        this.proyectosobjetivosPK = proyectosobjetivosPK;
    }

    public Proyectosobjetivos(short proyectosid, short proyectosl2linea) {
        this.proyectosobjetivosPK = new ProyectosobjetivosPK(proyectosid, proyectosl2linea);
    }

    public ProyectosobjetivosPK getProyectosobjetivosPK() {
        return proyectosobjetivosPK;
    }

    public void setProyectosobjetivosPK(ProyectosobjetivosPK proyectosobjetivosPK) {
        this.proyectosobjetivosPK = proyectosobjetivosPK;
    }

    public String getProyectosl2objetivo() {
        return proyectosl2objetivo;
    }

    public void setProyectosl2objetivo(String proyectosl2objetivo) {
        this.proyectosl2objetivo = proyectosl2objetivo;
    }

    public String getProyectosl2usuario() {
        return proyectosl2usuario;
    }

    public void setProyectosl2usuario(String proyectosl2usuario) {
        this.proyectosl2usuario = proyectosl2usuario;
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
        hash += (proyectosobjetivosPK != null ? proyectosobjetivosPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Proyectosobjetivos)) {
            return false;
        }
        Proyectosobjetivos other = (Proyectosobjetivos) object;
        if ((this.proyectosobjetivosPK == null && other.proyectosobjetivosPK != null) || (this.proyectosobjetivosPK != null && !this.proyectosobjetivosPK.equals(other.proyectosobjetivosPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "py.com.palermo.proyectosgob.persistencia.Proyectosobjetivos[ proyectosobjetivosPK=" + proyectosobjetivosPK + " ]";
    }
    
}
