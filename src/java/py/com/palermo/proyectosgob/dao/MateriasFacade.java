/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package py.com.palermo.proyectosgob.dao;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import py.com.palermo.proyectosgob.persistencia.Materias;

/**
 *
 * @author cromero
 */
@Stateless
public class MateriasFacade extends AbstractFacade<Materias> {
    @PersistenceContext(unitName = "ProyectosGobPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public MateriasFacade() {
        super(Materias.class);
    }
    
}
