/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package py.com.palermo.proyectosgob.web.util;

import java.io.Serializable;
import javax.enterprise.context.ApplicationScoped;
import javax.faces.model.SelectItem;
import javax.inject.Named;
import py.com.palermo.proyectosgob.persistencia.Estado;
import py.com.palermo.proyectosgob.persistencia.TipoResultado;

/**
 *
 * @author christian
 */
@Named
@ApplicationScoped
public class ProductorEnums implements Serializable {

    public SelectItem[] obtTiposResultados() {
        SelectItem[] R = new SelectItem[TipoResultado.values().length];
        TipoResultado[] lista = TipoResultado.values();
        for (int i = 0; i < lista.length; i++) {
            TipoResultado e = lista[i];
            R[i] = new SelectItem(e, e.toString());
        }
        return R;
    }

    public SelectItem[] obtEstados() {

        Estado[] lista = Estado.values();

        int i = 0;
        SelectItem[] R = new SelectItem[Estado.values().length + 1];
        R[0] = new SelectItem("", "---");
        i++;
        for (Estado e : lista) {
            R[i++] = new SelectItem(e, e.toString());

        }

        return R;
    }

}
