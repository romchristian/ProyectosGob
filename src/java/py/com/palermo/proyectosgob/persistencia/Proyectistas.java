/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package py.com.palermo.proyectosgob.persistencia;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
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
@Table(name = "proyectistas")
@NamedQueries({
    @NamedQuery(name = "Proyectistas.findAll", query = "SELECT p FROM Proyectistas p")})
public class Proyectistas implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "proyectistasid")
    private Short proyectistasid;
    @Size(max = 120)
    @Column(name = "proyectistasnombre")
    private String proyectistasnombre;
    @Size(max = 120)
    @Column(name = "proyectistasapellido")
    private String proyectistasapellido;
    @Column(name = "proyectistasestado")
    private Short proyectistasestado;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "proyectistas")
    private List<Proyectosproyectistas> proyectosproyectistasList;

    public Proyectistas() {
    }

    public Proyectistas(Short proyectistasid) {
        this.proyectistasid = proyectistasid;
    }

    public Short getProyectistasid() {
        return proyectistasid;
    }

    public void setProyectistasid(Short proyectistasid) {
        this.proyectistasid = proyectistasid;
    }

    public String getProyectistasnombre() {
        return proyectistasnombre;
    }

    public void setProyectistasnombre(String proyectistasnombre) {
        this.proyectistasnombre = proyectistasnombre;
    }

    public String getProyectistasapellido() {
        return proyectistasapellido;
    }

    public void setProyectistasapellido(String proyectistasapellido) {
        this.proyectistasapellido = proyectistasapellido;
    }

    public Short getProyectistasestado() {
        return proyectistasestado;
    }

    public void setProyectistasestado(Short proyectistasestado) {
        this.proyectistasestado = proyectistasestado;
    }

    public List<Proyectosproyectistas> getProyectosproyectistasList() {
        return proyectosproyectistasList;
    }

    public void setProyectosproyectistasList(List<Proyectosproyectistas> proyectosproyectistasList) {
        this.proyectosproyectistasList = proyectosproyectistasList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (proyectistasid != null ? proyectistasid.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Proyectistas)) {
            return false;
        }
        Proyectistas other = (Proyectistas) object;
        if ((this.proyectistasid == null && other.proyectistasid != null) || (this.proyectistasid != null && !this.proyectistasid.equals(other.proyectistasid))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "py.com.palermo.proyectosgob.persistencia.Proyectistas[ proyectistasid=" + proyectistasid + " ]";
    }
    
}
