/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package py.com.palermo.proyectosgob.persistencia;

import java.io.Serializable;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;

/**
 *
 * @author cromero
 */
@Entity
public class Comision implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nombre;
    private String camara;
    private String presidente;
    private String vicepresidente;
    private String secretario;
    @OneToMany(mappedBy = "comision", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Miembro> miembros;
    @ManyToMany(mappedBy = "comisiones")
    private List<Tramite> tramites;
    @Enumerated(EnumType.STRING)
    private Estado estado;

    public Comision() {
        estado = Estado.ACTIVO;
    }

    public Estado getEstado() {
        return estado;
    }

    public void setEstado(Estado estado) {
        this.estado = estado;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCamara() {
        return camara;
    }

    public void setCamara(String camara) {
        this.camara = camara;
    }

    public List<Tramite> getTramites() {
        return tramites;
    }

    public void setTramites(List<Tramite> tramites) {
        this.tramites = tramites;
    }

    public String getPresidente() {
        return presidente;
    }

    public void setPresidente(String presidente) {
        this.presidente = presidente;
    }

    public String getVicepresidente() {
        return vicepresidente;
    }

    public void setVicepresidente(String vicepresidente) {
        this.vicepresidente = vicepresidente;
    }

    public String getSecretario() {
        return secretario;
    }

    public void setSecretario(String secretario) {
        this.secretario = secretario;
    }

    public List<Miembro> getMiembros() {
        return miembros;
    }

    public void setMiembros(List<Miembro> miembros) {
        this.miembros = miembros;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Comision)) {
            return false;
        }
        Comision other = (Comision) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "py.com.palermo.proyectosgob.persistencia.Comision[ id=" + id + " ]";
    }

}
