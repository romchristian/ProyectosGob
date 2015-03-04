/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package py.com.palermo.proyectosgob.persistencia;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import py.com.palermo.proyectosgob.web.util.Encryptador;

/**
 *
 * @author cromero
 */
@Entity
@Table(name = "usuarios")
@NamedQueries({
    @NamedQuery(name = "Usuarios.findAll", query = "SELECT u FROM Usuarios u")})
public class Usuarios implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Column(name = "usuariosid")
    private String usuariosid;

    @Column(name = "usuariosnombre")
    private String usuariosnombre;

    @Column(name = "usuariosapellido")
    private String usuariosapellido;

    @Column(name = "usuariosnombremostrar")
    private String usuariosnombremostrar;
    @Column(name = "usuariostipo")
    private Short usuariostipo;
    @Column(name = "usuariospassword")
    private Short usuariospassword;

    @Column(name = "usuariosemail")
    private String usuariosemail;

    @Column(name = "usuariosseguridad")
    private String usuariosseguridad;
    @Column(name = "usuariosestado")
    private Short usuariosestado;
    @Column(name = "usuariossync")
    private Short usuariossync;
    @Column(name = "usuariosfecha")
    @Temporal(TemporalType.DATE)
    private Date usuariosfecha;
    @Column(name = "usuariosnotificarvto")
    private Short usuariosnotificarvto;
    @ManyToMany(mappedBy = "usuariosList", cascade = CascadeType.ALL)
    private List<Roles> rolesList;
    @Column(name = "clave")
    private String clave;

    public Usuarios() {
        this.usuariosestado = new Short("0");
        this.usuariosfecha = new Date();
        this.usuariossync = new Short("0");
        this.usuariospassword = new Short("0");
        this.usuariostipo = new Short("0");
    }

    public Usuarios(String usuariosid) {
        this.usuariosid = usuariosid;
    }

    public String getUsuariosid() {
        return usuariosid;
    }

    public String getClave() {
        return clave;
    }

    public void setClave(String clave) {
        this.clave = clave;
    }

    public void setUsuariosid(String usuariosid) {
        this.usuariosid = usuariosid;
    }

    public String getUsuariosnombre() {
        return usuariosnombre;
    }

    public void setUsuariosnombre(String usuariosnombre) {
        this.usuariosnombre = usuariosnombre;
    }

    public String getUsuariosapellido() {
        return usuariosapellido;
    }

    public void setUsuariosapellido(String usuariosapellido) {
        this.usuariosapellido = usuariosapellido;
    }

    public String getUsuariosnombremostrar() {
        return usuariosnombremostrar;
    }

    public void setUsuariosnombremostrar(String usuariosnombremostrar) {
        this.usuariosnombremostrar = usuariosnombremostrar;
    }

    public Short getUsuariostipo() {
        return usuariostipo;
    }

    public void setUsuariostipo(Short usuariostipo) {
        this.usuariostipo = usuariostipo;
    }

    public Short getUsuariospassword() {
        return usuariospassword;
    }

    public void setUsuariospassword(Short usuariospassword) {
        this.usuariospassword = usuariospassword;
    }

    public String getUsuariosemail() {
        return usuariosemail;
    }

    public void setUsuariosemail(String usuariosemail) {
        this.usuariosemail = usuariosemail;
    }

    public String getUsuariosseguridad() {
        return usuariosseguridad;
    }

    public void setUsuariosseguridad(String usuariosseguridad) {
        this.usuariosseguridad = Encryptador.encrypta(usuariosseguridad);
    }

    public Short getUsuariosestado() {
        return usuariosestado;
    }

    public void setUsuariosestado(Short usuariosestado) {
        this.usuariosestado = usuariosestado;
    }

    public Short getUsuariossync() {
        return usuariossync;
    }

    public void setUsuariossync(Short usuariossync) {
        this.usuariossync = usuariossync;
    }

    public Date getUsuariosfecha() {
        return usuariosfecha;
    }

    public void setUsuariosfecha(Date usuariosfecha) {
        this.usuariosfecha = usuariosfecha;
    }

    public Short getUsuariosnotificarvto() {
        return usuariosnotificarvto;
    }

    public void setUsuariosnotificarvto(Short usuariosnotificarvto) {
        this.usuariosnotificarvto = usuariosnotificarvto;
    }

    public List<Roles> getRolesList() {
        if (rolesList == null) {
            rolesList = new ArrayList<>();
        }
        return rolesList;
    }

    public void setRolesList(List<Roles> rolesList) {
        this.rolesList = rolesList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (usuariosid != null ? usuariosid.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Usuarios)) {
            return false;
        }
        Usuarios other = (Usuarios) object;
        if ((this.usuariosid == null && other.usuariosid != null) || (this.usuariosid != null && !this.usuariosid.equals(other.usuariosid))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "py.com.palermo.proyectosgob.persistencia.Usuarios[ usuariosid=" + usuariosid + " ]";
    }

}
