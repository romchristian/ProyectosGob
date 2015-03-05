/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package py.com.palermo.proyectosgob.dao;

import java.util.Date;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import py.com.palermo.proyectosgob.persistencia.Auditoria;
import py.com.palermo.proyectosgob.persistencia.Usuarios;

/**
 *
 * @author cromero
 */
@Stateless
public class AuditoriaFacade extends AbstractFacade<Auditoria> {
    @PersistenceContext(unitName = "ProyectosGobPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public AuditoriaFacade() {
        super(Auditoria.class);
    }

    public void create(Auditoria entity,String principal) {
        Usuarios u = em.find(Usuarios.class, principal);
        entity.setUsuario(u);
        entity.setFecha(new Date());
        em.persist(entity);
    }
    
}
