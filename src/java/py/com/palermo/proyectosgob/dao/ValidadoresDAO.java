/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package py.com.palermo.proyectosgob.dao;

import java.io.Serializable;
import javax.ejb.Stateless;
import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import py.com.palermo.proyectosgob.persistencia.Proyectos;


/**
 *
 * @author christian
 */
@Named
@Stateless
public class ValidadoresDAO implements Serializable {

    @PersistenceContext(unitName = "ProyectosGobPU")
    private EntityManager em;

    public boolean hayNroExpediente(String nro) {

        boolean R = false;
        try {

            Proyectos f = (Proyectos) em.createQuery("SELECT p from Proyectos p where TRIM(UPPER(p.proyectosnroexpediente)) = :nro ")
                    .setParameter("nro", nro)
                    .getSingleResult();
            R = true;
        } catch (Exception e) {
        }
        return R;
    }

    
}
