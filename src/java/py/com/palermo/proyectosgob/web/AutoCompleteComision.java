/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package py.com.palermo.proyectosgob.web;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;
import py.com.palermo.proyectosgob.dao.ComisionFacade;
import py.com.palermo.proyectosgob.persistencia.Comision;
import py.com.palermo.proyectosgob.persistencia.Estado;

/**
 *
 * @author cromero
 */
@Named
@SessionScoped
public class AutoCompleteComision implements Serializable {

    private Comision elegido;
    @EJB
    private ComisionFacade dao;
    private List<Comision> lista;
    private String camara = "CAMARA DE DIPUTADOS";

    @PostConstruct
    public void init() {
        carga(camara);
    }

    public String getCamara() {
        return camara;
    }

    public void setCamara(String camara) {
        this.camara = camara;
    }

    public Comision getElegido() {
        return elegido;
    }

    public void setElegido(Comision elegido) {
        this.elegido = elegido;
    }

    public List<Comision> completar(String query) {
        List<Comision> sugerencias = new ArrayList<>();

        for (Comision c : getLista()) {

            String cadenaAComparar = c.getNombre();
            if (cadenaAComparar.trim().toUpperCase().startsWith(query.toUpperCase().trim())) {
                sugerencias.add(c);
            }
        }

        return sugerencias;
    }

    public List<Comision> getLista() {
        if (lista == null || lista.isEmpty()) {
            carga(camara);
        }
        return lista;
    }

    public void setLista(List<Comision> lista) {
        this.lista = lista;
    }

    public void reload() {
        carga(camara);
    }

    private void carga(String camara) {
        lista = dao.findPorCamara(camara, Estado.ACTIVO);
    }

}
