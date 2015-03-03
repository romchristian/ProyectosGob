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
import java.util.UUID;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.Transient;

/**
 *
 * @author cromero
 */
@Entity
public class Tramite implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String sesion;
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date fecha;
    private String camara;
    private String titulo;
    private String subtitulo;
    @ManyToOne
    private Proyectos proyecto;
    private String resultado;
    @Enumerated(EnumType.STRING)
    private TipoResultado tipoResultado;
    @ManyToOne
    private Comision comisionDictamen;
    private String resultadoLink;
    @ManyToMany(cascade = CascadeType.ALL)
    private List<Comision> comisiones;
    @Transient
    private boolean editar = false;
    @Transient
    private Comision comisionElegida;
    @Transient
    private String nombreArchivo;

    public Tramite() {
        tipoResultado = TipoResultado.GIRADO_A;
    }

    public String getNombreArchivo() {
        return nombreArchivo;
    }

    public void setNombreArchivo(String nombreArchivo) {
        this.nombreArchivo = nombreArchivo;
    }

     public void generarNombreArchivo() {
        UUID uuid = UUID.randomUUID();
        nombreArchivo = proyecto.getProyectosnroexpediente() + "_" + getTipoResultado() + "_" + uuid.toString();
    }
     
     public void guardaNombreArchivo() {
        setResultadoLink(nombreArchivo);
        nombreArchivo = null;
    }
    
    public boolean isEditar() {
        return editar;
    }

    public void setEditar(boolean editar) {
        this.editar = editar;
    }

    public Comision getComisionElegida() {
        return comisionElegida;
    }

    public void setComisionElegida(Comision comisionElegida) {
        this.comisionElegida = comisionElegida;
    }
      
    
    public void addComision() {
        if (getComisiones() == null) {
            setComisiones(new ArrayList<Comision>());
        }
        getComisiones().add(comisionElegida);
        comisionElegida = null;
    }
    
    public void quitarComision(Comision c) {
        getComisiones().remove(c);
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public String getSesion() {
        return sesion;
    }

    public void setSesion(String sesion) {
        this.sesion = sesion;
    }

    public Proyectos getProyecto() {
        return proyecto;
    }

    public void setProyecto(Proyectos proyecto) {
        this.proyecto = proyecto;
    }

    public String getCamara() {
        return camara;
    }

    public void setCamara(String camara) {
        this.camara = camara;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getSubtitulo() {
        return subtitulo;
    }

    public void setSubtitulo(String subtitulo) {
        this.subtitulo = subtitulo;
    }

    public String getResultado() {
        return resultado;
    }

    public void setResultado(String resultado) {
        this.resultado = resultado;
    }

    public String getResultadoLink() {
        return resultadoLink;
    }

    public void setResultadoLink(String resultadoLink) {
        this.resultadoLink = resultadoLink;
    }

    public TipoResultado getTipoResultado() {
        return tipoResultado;
    }

    public void setTipoResultado(TipoResultado tipoResultado) {
        this.tipoResultado = tipoResultado;
    }

    public Comision getComisionDictamen() {
        return comisionDictamen;
    }

    public void setComisionDictamen(Comision comisionDictamen) {
        this.comisionDictamen = comisionDictamen;
    }

    public List<Comision> getComisiones() {
        return comisiones;
    }

    public void setComisiones(List<Comision> comisiones) {
        this.comisiones = comisiones;
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
        if (!(object instanceof Tramite)) {
            return false;
        }
        Tramite other = (Tramite) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "py.com.palermo.proyectosgob.persistencia.Tramite[ id=" + id + " ]";
    }
    
}
