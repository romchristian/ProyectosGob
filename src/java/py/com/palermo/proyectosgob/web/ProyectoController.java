/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package py.com.palermo.proyectosgob.web;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.component.UIOutput;
import javax.faces.event.AjaxBehaviorEvent;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;
import org.joda.time.DateTime;
import py.com.palermo.proyectosgob.dao.ProyectosFacade;
import py.com.palermo.proyectosgob.persistencia.Comision;
import py.com.palermo.proyectosgob.persistencia.Objetivo;
import py.com.palermo.proyectosgob.persistencia.Proyectos;
import py.com.palermo.proyectosgob.persistencia.Proyectosobjetivos;
import py.com.palermo.proyectosgob.persistencia.ProyectosobjetivosPK;
import py.com.palermo.proyectosgob.persistencia.TipoResultado;
import py.com.palermo.proyectosgob.persistencia.Tramite;
import py.com.palermo.proyectosgob.web.util.JsfUtil;

/**
 *
 * @author cromero
 */
@Named
@ViewScoped
public class ProyectoController implements Serializable {

    @EJB
    private ProyectosFacade ejbFacade;

    private Proyectos selected;
    private int id;
    private String fraseBusqueda;
    private List<Proyectos> resultado;
    private long cantResultados;
    private Tramite tramiteNuevo;
    private List<Comision> comisionGiradas;
    private List<String> titulos;
    private List<String> subTitulos;
    private Comision comisionElegida;
    private String nombreArchivo;
    private String nombreArchivoOriginal;
    private Objetivo objetivoNuevo;

    @Inject
    private AutoCompleteComision autoCompleteComision;

    @PostConstruct
    public void init() {
        autoCompleteComision.reload();
        if (tramiteNuevo == null) {
            tramiteNuevo = new Tramite();
            tramiteNuevo.setCamara("CAMARA DE DIPUTADOS");
        }
    }

    public Objetivo getObjetivoNuevo() {
        if (objetivoNuevo == null) {
            objetivoNuevo = new Objetivo();
            objetivoNuevo.setProyecto(selected);
        }
        return objetivoNuevo;
    }

    public void setObjetivoNuevo(Objetivo objetivoNuevo) {
        this.objetivoNuevo = objetivoNuevo;
    }

    public String getNombreArchivo() {
        return nombreArchivo;
    }

    public void setNombreArchivo(String nombreArchivo) {
        this.nombreArchivo = nombreArchivo;
    }

    public String getNombreArchivoOriginal() {
        return nombreArchivoOriginal;
    }

    public void setNombreArchivoOriginal(String nombreArchivoOriginal) {
        this.nombreArchivoOriginal = nombreArchivoOriginal;
    }

    
    public void generarNombreArchivo() {
        UUID uuid = UUID.randomUUID();
        nombreArchivo = selected.getProyectosnroexpediente() + "_" + tramiteNuevo.getTipoResultado() + "_" + uuid.toString();
    }
    
    public void generarNombreArchivoOrignal() {
        UUID uuid = UUID.randomUUID();
        nombreArchivoOriginal = selected.getProyectosnroexpediente() + "_Texto_Original"+ "_" + uuid.toString();
    }
    
    public void guardaNombreArchivoOriginal() {
       selected.setProyectosrutatexto1(nombreArchivoOriginal);
       nombreArchivoOriginal = null;
    }
    
    public void guardaNombreArchivo() {
        tramiteNuevo.setResultadoLink(nombreArchivo);
        nombreArchivo = null;
    }

    public String guardar() {
        try {
            ejbFacade.edit(selected);
            JsfUtil.addSuccessMessage("El proyecto se guardo exitosamente!");
            
        } catch (Exception e) {
        }

        return "List.xhtml?faces-redirect=true";
    }

    public void cambiaCamara(AjaxBehaviorEvent event) {
        String camara = (String) ((UIOutput) event.getSource()).getValue();
        tramiteNuevo.setCamara(camara);
        autoCompleteComision.setCamara(camara);
        autoCompleteComision.reload();
    }

    public void addObjetivo() {
        if (selected.getObjetivos() == null) {
            selected.setObjetivos(new ArrayList<Objetivo>());
        }
        objetivoNuevo.setProyecto(selected);
        selected.getObjetivos().add(objetivoNuevo);
        objetivoNuevo = null;
    }

    public void remueveObjetivo(Objetivo o) {
//        System.out.println("Removiendo....:" + o.getProyectosl2objetivo());
//        int indice = 0;
//        for (Proyectosobjetivos obj : selected.getProyectosobjetivosList()) {
//            System.out.println("Indice 0 1:" + o.getIndice());
//            System.out.println("Indice 0bj 1:" + obj.getIndice());
//            if (o.getIndice() == obj.getIndice()) {
//                System.out.println("Indice 0 2:" + o.getIndice());
//                System.out.println("Indice 0bj 2:" + obj.getIndice());
//                System.out.println("Indice of 2:" + selected.getProyectosobjetivosList().indexOf(obj));
//                indice = obj.getIndice();
//                break;
//            }
//        }
//
//        selected.getProyectosobjetivosList().remove(indice);

        selected.getObjetivos().remove(o);
    }

    public void addTramite() {
        if (selected.getTramites() == null) {
            selected.setTramites(new ArrayList<Tramite>());
        }

        tramiteNuevo.setProyecto(selected);
        if(tramiteNuevo.getTipoResultado() == TipoResultado.TEXTO_MEDIA_SANCION && tramiteNuevo.getFecha() != null){
            DateTime dt = new DateTime(tramiteNuevo.getFecha());
            Date fechaFicta = dt.plusMonths(3).toDate();
            selected.setProyectosfechaficta(fechaFicta);
        }
        selected.getTramites().add(tramiteNuevo);
        tramiteNuevo = new Tramite();
    }
    
    public void quitarTramite(Tramite t){
        selected.getTramites().remove(t);
    }
    
    public void toogleEditTramite(Tramite t){
        if(t.isEditar()){
            t.setEditar(false);
        }else{
            t.setEditar(true);
        }
       
    }

    public void addComision() {
        if (tramiteNuevo.getComisiones() == null) {
            tramiteNuevo.setComisiones(new ArrayList<Comision>());
        }
        tramiteNuevo.getComisiones().add(comisionElegida);
        comisionElegida = null;
    }

    public void quitarComision(Comision c) {
        tramiteNuevo.getComisiones().remove(c);
    }

    public Comision getComisionElegida() {
        return comisionElegida;
    }

    public void setComisionElegida(Comision comisionElegida) {
        this.comisionElegida = comisionElegida;
    }

    public List<String> getTitulos() {
        if (titulos == null) {

        }
        return titulos;
    }

    public void setTitulos(List<String> titulos) {
        this.titulos = titulos;
    }

    public List<String> getSubTitulos() {
        return subTitulos;
    }

    public void setSubTitulos(List<String> subTitulos) {
        this.subTitulos = subTitulos;
    }

    public List<Proyectos> getResultado() {
        return resultado;
    }

    public void setResultado(List<Proyectos> resultado) {
        this.resultado = resultado;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void subjectSelectionChanged(final AjaxBehaviorEvent event) {
        //tramiteNuevo.setTipoResultado((TipoResultado) event.getSource());
    }

    public Tramite getTramiteNuevo() {
        if (tramiteNuevo == null) {
            tramiteNuevo = new Tramite();
        }
        return tramiteNuevo;
    }

    public void setTramiteNuevo(Tramite tramiteNuevo) {
        this.tramiteNuevo = tramiteNuevo;
    }

    public List<Comision> getComisionGiradas() {
        return comisionGiradas;
    }

    public void setComisionGiradas(List<Comision> comisionGiradas) {
        this.comisionGiradas = comisionGiradas;
    }

    public void prepareCreate(){
        selected = new Proyectos();
    }
    
    public Proyectos getSelected() {
        return selected;
    }

    public void setSelected(Proyectos selected) {
        this.selected = selected;
    }

    public String getFraseBusqueda() {
        return fraseBusqueda;
    }

    public void setFraseBusqueda(String fraseBusqueda) {
        this.fraseBusqueda = fraseBusqueda;
    }

    public long getCantResultados() {
        return cantResultados;
    }

    public void setCantResultados(long cantResultados) {
        this.cantResultados = cantResultados;
    }

    public void cargaDatos() {
        selected = ejbFacade.find((new Integer(id)).shortValue());
    }

    public void buscarProyectos() {
        if (fraseBusqueda != null) {
            resultado = ejbFacade.getResultados(fraseBusqueda);
            cantResultados = resultado.size();
            System.out.println("Resultado: " + resultado);
        }
    }

}
