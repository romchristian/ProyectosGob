/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package py.com.palermo.proyectosgob.persistencia;

import java.io.Serializable;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 *
 * @author cromero
 */
@Entity
@Table(name = "proyectos")
@NamedQueries({
    @NamedQuery(name = "Proyectos.findAll", query = "SELECT p FROM Proyectos p")})
public class Proyectos implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "proyectosid")
    private Short proyectosid;
    @Size(max = 15)
    @Column(name = "proyectosnroexpediente")
    private String proyectosnroexpediente;
    @Size(max = 715)
    @Column(name = "proyectosnombre")
    private String proyectosnombre;
    @Column(name = "proyectoscamaraorigen")
    private Short proyectoscamaraorigen;
    @Column(name = "proyectosfechaingreso")
    @Temporal(TemporalType.DATE)
    private Date proyectosfechaingreso;
    @Column(name = "proyectosperiodolegislativo")
    private Short proyectosperiodolegislativo;
    @Size(max = 440)
    @Column(name = "proyectosdictamen")
    private String proyectosdictamen;
    @Column(name = "proyectoscalificativo")
    private Character proyectoscalificativo;
    @Size(max = 500)
    @Column(name = "proyectosobservacion")
    private String proyectosobservacion;
    @Column(name = "proyectosestado")
    private Short proyectosestado;
    @Column(name = "proyectosseriall2")
    private Short proyectosseriall2;
    @Column(name = "proyectosseriall3")
    private Short proyectosseriall3;
    @Column(name = "proyectosseriall4")
    private Short proyectosseriall4;
    @Column(name = "proyectosseriall5")
    private Short proyectosseriall5;
    @Column(name = "proyectosfechaficta")
    @Temporal(TemporalType.DATE)
    private Date proyectosfechaficta;
    @Size(max = 60)
    @Column(name = "proyectosrutatexto1")
    private String proyectosrutatexto1;
    @Size(max = 60)
    @Column(name = "proyectosrutatexto2")
    private String proyectosrutatexto2;
    @Size(max = 60)
    @Column(name = "proyectosrutatexto3")
    private String proyectosrutatexto3;
    @Size(max = 60)
    @Column(name = "proyectosrutatexto4")
    private String proyectosrutatexto4;
    @Column(name = "proyectosfechatramite3")
    @Temporal(TemporalType.DATE)
    private Date proyectosfechatramite3;
    @Column(name = "proyectosfechatramite2")
    @Temporal(TemporalType.DATE)
    private Date proyectosfechatramite2;
    @Column(name = "proyectosfechatramite1")
    @Temporal(TemporalType.DATE)
    private Date proyectosfechatramite1;
    @Column(name = "proyectosnotificado")
    private Short proyectosnotificado;
    @Size(max = 20)
    @Column(name = "proyectosusuario")
    private String proyectosusuario;
    @Column(name = "proyectosiniciativa")
    private String proyectosiniciativa;
    @JoinColumn(name = "materiasid", referencedColumnName = "materiasid")
    @ManyToOne
    private Materias materiasid;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "proyectos")
    private List<Proyectossubtemas> proyectossubtemasList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "proyectos")
    private List<Proyectosobjetivos> proyectosobjetivosList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "proyectos")
    private List<Proyectostramites> proyectostramitesList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "proyectos")
    private List<Proyectosproyectistas> proyectosproyectistasList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "proyectos")
    private List<Proyectosestamentos> proyectosestamentosList;
    @OneToMany(mappedBy = "proyecto", cascade = CascadeType.ALL, fetch = FetchType.EAGER, orphanRemoval = true)
    private List<Tramite> tramites;
    @OneToMany(mappedBy = "proyecto",cascade = CascadeType.ALL, fetch = FetchType.EAGER, orphanRemoval = true)
    private List<Objetivo> objetivos;
    private Boolean favorito;

    public Proyectos() {
    }

    public List<Objetivo> getObjetivos() {
        return objetivos;
    }

    public void setObjetivos(List<Objetivo> objetivos) {
        this.objetivos = objetivos;
    }

    public Boolean getFavorito() {
        return favorito;
    }

    public void setFavorito(Boolean favorito) {
        this.favorito = favorito;
    }

    public Proyectos(Short proyectosid) {
        this.proyectosid = proyectosid;
    }

    public List<Tramite> getTramites() {
        return tramites;
    }

    public void setTramites(List<Tramite> tramites) {
        this.tramites = tramites;
    }

    public String getProyectosiniciativa() {
        return proyectosiniciativa;
    }

    public void setProyectosiniciativa(String proyectosiniciativa) {
        this.proyectosiniciativa = proyectosiniciativa;
    }

    public Short getProyectosid() {
        return proyectosid;
    }

    public void setProyectosid(Short proyectosid) {
        this.proyectosid = proyectosid;
    }

    public String getProyectosnroexpediente() {
        return proyectosnroexpediente;
    }

    public void setProyectosnroexpediente(String proyectosnroexpediente) {
        this.proyectosnroexpediente = proyectosnroexpediente;
    }

    public String getProyectosnombre() {
        return proyectosnombre;
    }

    public void setProyectosnombre(String proyectosnombre) {
        this.proyectosnombre = proyectosnombre;
    }

    public Short getProyectoscamaraorigen() {
        return proyectoscamaraorigen;
    }

    public void setProyectoscamaraorigen(Short proyectoscamaraorigen) {
        this.proyectoscamaraorigen = proyectoscamaraorigen;
    }

    public Date getProyectosfechaingreso() {
        return proyectosfechaingreso;
    }

    public void setProyectosfechaingreso(Date proyectosfechaingreso) {
        this.proyectosfechaingreso = proyectosfechaingreso;
    }

    public Short getProyectosperiodolegislativo() {
        return proyectosperiodolegislativo;
    }

    public void setProyectosperiodolegislativo(Short proyectosperiodolegislativo) {
        this.proyectosperiodolegislativo = proyectosperiodolegislativo;
    }

    public String getProyectosdictamen() {
        return proyectosdictamen;
    }

    public void setProyectosdictamen(String proyectosdictamen) {
        this.proyectosdictamen = proyectosdictamen;
    }

    public Character getProyectoscalificativo() {
        return proyectoscalificativo;
    }

    public void setProyectoscalificativo(Character proyectoscalificativo) {
        this.proyectoscalificativo = proyectoscalificativo;
    }

    public String getProyectosobservacion() {
        return proyectosobservacion;
    }

    public void setProyectosobservacion(String proyectosobservacion) {
        this.proyectosobservacion = proyectosobservacion;
    }

    public Short getProyectosestado() {
        return proyectosestado;
    }

    public void setProyectosestado(Short proyectosestado) {
        this.proyectosestado = proyectosestado;
    }

    public Short getProyectosseriall2() {
        return proyectosseriall2;
    }

    public void setProyectosseriall2(Short proyectosseriall2) {
        this.proyectosseriall2 = proyectosseriall2;
    }

    public Short getProyectosseriall3() {
        return proyectosseriall3;
    }

    public void setProyectosseriall3(Short proyectosseriall3) {
        this.proyectosseriall3 = proyectosseriall3;
    }

    public Short getProyectosseriall4() {
        return proyectosseriall4;
    }

    public void setProyectosseriall4(Short proyectosseriall4) {
        this.proyectosseriall4 = proyectosseriall4;
    }

    public Short getProyectosseriall5() {
        return proyectosseriall5;
    }

    public void setProyectosseriall5(Short proyectosseriall5) {
        this.proyectosseriall5 = proyectosseriall5;
    }

    public Date getProyectosfechaficta() {
        return proyectosfechaficta;
    }

    public void setProyectosfechaficta(Date proyectosfechaficta) {
        this.proyectosfechaficta = proyectosfechaficta;
    }

    public String getProyectosrutatexto1() {
        return proyectosrutatexto1;
    }

    public void setProyectosrutatexto1(String proyectosrutatexto1) {
        this.proyectosrutatexto1 = proyectosrutatexto1;
    }

    public String getProyectosrutatexto2() {
        return proyectosrutatexto2;
    }

    public void setProyectosrutatexto2(String proyectosrutatexto2) {
        this.proyectosrutatexto2 = proyectosrutatexto2;
    }

    public String getProyectosrutatexto3() {
        return proyectosrutatexto3;
    }

    public void setProyectosrutatexto3(String proyectosrutatexto3) {
        this.proyectosrutatexto3 = proyectosrutatexto3;
    }

    public String getProyectosrutatexto4() {
        return proyectosrutatexto4;
    }

    public void setProyectosrutatexto4(String proyectosrutatexto4) {
        this.proyectosrutatexto4 = proyectosrutatexto4;
    }

    public Date getProyectosfechatramite3() {
        return proyectosfechatramite3;
    }

    public void setProyectosfechatramite3(Date proyectosfechatramite3) {
        this.proyectosfechatramite3 = proyectosfechatramite3;
    }

    public Date getProyectosfechatramite2() {
        return proyectosfechatramite2;
    }

    public void setProyectosfechatramite2(Date proyectosfechatramite2) {
        this.proyectosfechatramite2 = proyectosfechatramite2;
    }

    public Date getProyectosfechatramite1() {
        return proyectosfechatramite1;
    }

    public void setProyectosfechatramite1(Date proyectosfechatramite1) {
        this.proyectosfechatramite1 = proyectosfechatramite1;
    }

    public Short getProyectosnotificado() {
        return proyectosnotificado;
    }

    public void setProyectosnotificado(Short proyectosnotificado) {
        this.proyectosnotificado = proyectosnotificado;
    }

    public String getProyectosusuario() {
        return proyectosusuario;
    }

    public void setProyectosusuario(String proyectosusuario) {
        this.proyectosusuario = proyectosusuario;
    }

    public Materias getMateriasid() {
        return materiasid;
    }

    public void setMateriasid(Materias materiasid) {
        this.materiasid = materiasid;
    }

    public List<Proyectossubtemas> getProyectossubtemasList() {
        return proyectossubtemasList;
    }

    public void setProyectossubtemasList(List<Proyectossubtemas> proyectossubtemasList) {
        this.proyectossubtemasList = proyectossubtemasList;
    }

    public List<Proyectosobjetivos> getProyectosobjetivosList() {

        if (proyectosobjetivosList != null) {
//            Comparator<Proyectosobjetivos> comp = new Comparator<Proyectosobjetivos>() {
//
//                @Override
//                public int compare(Proyectosobjetivos o1, Proyectosobjetivos o2) {
//                    return o1.getProyectosl2objetivo().compareToIgnoreCase(o2.getProyectosl2objetivo()) > 0 ? 1 : -1;
//                }
//            };
//
//            Collections.sort(proyectosobjetivosList, comp);

            int i = 0;
            for (Proyectosobjetivos o : proyectosobjetivosList) {
                o.setIndice(i);
                i++;
            }
        }
        return proyectosobjetivosList;
    }

    public void setProyectosobjetivosList(List<Proyectosobjetivos> proyectosobjetivosList) {
        this.proyectosobjetivosList = proyectosobjetivosList;
    }

    public List<Proyectostramites> getProyectostramitesList() {
        return proyectostramitesList;
    }

    public void setProyectostramitesList(List<Proyectostramites> proyectostramitesList) {
        this.proyectostramitesList = proyectostramitesList;
    }

    public List<Proyectosproyectistas> getProyectosproyectistasList() {
        return proyectosproyectistasList;
    }

    public void setProyectosproyectistasList(List<Proyectosproyectistas> proyectosproyectistasList) {
        this.proyectosproyectistasList = proyectosproyectistasList;
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
        hash += (proyectosid != null ? proyectosid.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Proyectos)) {
            return false;
        }
        Proyectos other = (Proyectos) object;
        if ((this.proyectosid == null && other.proyectosid != null) || (this.proyectosid != null && !this.proyectosid.equals(other.proyectosid))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "py.com.palermo.proyectosgob.persistencia.Proyectos[ proyectosid=" + proyectosid + " ]";
    }

}
