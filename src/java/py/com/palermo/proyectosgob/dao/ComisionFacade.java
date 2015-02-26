/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package py.com.palermo.proyectosgob.dao;

import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import py.com.palermo.proyectosgob.persistencia.Comision;

/**
 *
 * @author cromero
 */
@Stateless
public class ComisionFacade extends AbstractFacade<Comision> {
    @PersistenceContext(unitName = "ProyectosGobPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public ComisionFacade() {
        super(Comision.class);
    }
    
    public List<Comision> findPorCamara(String camara){
        return em.createQuery("SELECT c from Comision c where c.camara = :camara").setParameter("camara", camara).getResultList();
    }
    
}
