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
@Table(name = "proyectosestamentos")
@NamedQueries({
    @NamedQuery(name = "Proyectosestamentos.findAll", query = "SELECT p FROM Proyectosestamentos p")})
public class Proyectosestamentos implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected ProyectosestamentosPK proyectosestamentosPK;
    @Size(max = 20)
    @Column(name = "proyectosl4usuario")
    private String proyectosl4usuario;
    @JoinColumn(name = "proyectosid", referencedColumnName = "proyectosid", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Proyectos proyectos;
    @JoinColumn(name = "estamentosid", referencedColumnName = "estamentosid")
    @ManyToOne
    private Estamentos estamentosid;

    public Proyectosestamentos() {
    }

    public Proyectosestamentos(ProyectosestamentosPK proyectosestamentosPK) {
        this.proyectosestamentosPK = proyectosestamentosPK;
    }

    public Proyectosestamentos(short proyectosid, short proyectosl4linea) {
        this.proyectosestamentosPK = new ProyectosestamentosPK(proyectosid, proyectosl4linea);
    }

    public ProyectosestamentosPK getProyectosestamentosPK() {
        return proyectosestamentosPK;
    }

    public void setProyectosestamentosPK(ProyectosestamentosPK proyectosestamentosPK) {
        this.proyectosestamentosPK = proyectosestamentosPK;
    }

    public String getProyectosl4usuario() {
        return proyectosl4usuario;
    }

    public void setProyectosl4usuario(String proyectosl4usuario) {
        this.proyectosl4usuario = proyectosl4usuario;
    }

    public Proyectos getProyectos() {
        return proyectos;
    }

    public void setProyectos(Proyectos proyectos) {
        this.proyectos = proyectos;
    }

    public Estamentos getEstamentosid() {
        return estamentosid;
    }

    public void setEstamentosid(Estamentos estamentosid) {
        this.estamentosid = estamentosid;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (proyectosestamentosPK != null ? proyectosestamentosPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Proyectosestamentos)) {
            return false;
        }
        Proyectosestamentos other = (Proyectosestamentos) object;
        if ((this.proyectosestamentosPK == null && other.proyectosestamentosPK != null) || (this.proyectosestamentosPK != null && !this.proyectosestamentosPK.equals(other.proyectosestamentosPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "py.com.palermo.proyectosgob.persistencia.Proyectosestamentos[ proyectosestamentosPK=" + proyectosestamentosPK + " ]";
    }
    
}
