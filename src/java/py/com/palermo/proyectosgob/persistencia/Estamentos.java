/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package py.com.palermo.proyectosgob.persistencia;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 *
 * @author cromero
 */
@Entity
@Table(name = "estamentos")
@NamedQueries({
    @NamedQuery(name = "Estamentos.findAll", query = "SELECT e FROM Estamentos e")})
public class Estamentos implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "estamentosid")
    private Short estamentosid;
    @Size(max = 250)
    @Column(name = "estamentosnombre")
    private String estamentosnombre;
    @Size(max = 40)
    @Column(name = "estamentosdireccion")
    private String estamentosdireccion;
    @Size(max = 15)
    @Column(name = "estamentostelefono")
    private String estamentostelefono;
    @Column(name = "estamentosestado")
    private Short estamentosestado;
    @OneToMany(mappedBy = "estamentosid")
    private List<Proyectosestamentos> proyectosestamentosList;

    public Estamentos() {
    }

    public Estamentos(Short estamentosid) {
        this.estamentosid = estamentosid;
    }

    public Short getEstamentosid() {
        return estamentosid;
    }

    public void setEstamentosid(Short estamentosid) {
        this.estamentosid = estamentosid;
    }

    public String getEstamentosnombre() {
        return estamentosnombre;
    }

    public void setEstamentosnombre(String estamentosnombre) {
        this.estamentosnombre = estamentosnombre;
    }

    public String getEstamentosdireccion() {
        return estamentosdireccion;
    }

    public void setEstamentosdireccion(String estamentosdireccion) {
        this.estamentosdireccion = estamentosdireccion;
    }

    public String getEstamentostelefono() {
        return estamentostelefono;
    }

    public void setEstamentostelefono(String estamentostelefono) {
        this.estamentostelefono = estamentostelefono;
    }

    public Short getEstamentosestado() {
        return estamentosestado;
    }

    public void setEstamentosestado(Short estamentosestado) {
        this.estamentosestado = estamentosestado;
    }

    public List<Proyectosestamentos> getProyectosestamentosList() {
        return proyectosestamentosList;
    }

    public void setProyectosestamentosList(List<Proyectosestamentos> proyectosestamentosList) {
        this.proyectosestamentosList = proyectosestamentosList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (estamentosid != null ? estamentosid.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Estamentos)) {
            return false;
        }
        Estamentos other = (Estamentos) object;
        if ((this.estamentosid == null && other.estamentosid != null) || (this.estamentosid != null && !this.estamentosid.equals(other.estamentosid))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "py.com.palermo.proyectosgob.persistencia.Estamentos[ estamentosid=" + estamentosid + " ]";
    }
    
}
