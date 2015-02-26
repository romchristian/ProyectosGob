/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package py.com.palermo.proyectosgob.dao;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import py.com.palermo.proyectosgob.persistencia.Proyectostramites;

/**
 *
 * @author cromero
 */
@Stateless
public class ProyectostramitesFacade extends AbstractFacade<Proyectostramites> {
    @PersistenceContext(unitName = "ProyectosGobPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public ProyectostramitesFacade() {
        super(Proyectostramites.class);
    }
    
}
