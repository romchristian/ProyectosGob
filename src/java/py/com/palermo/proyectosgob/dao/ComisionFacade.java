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
import py.com.palermo.proyectosgob.persistencia.Estado;
import py.com.palermo.proyectosgob.persistencia.Proyectos;
import py.com.palermo.proyectosgob.persistencia.Tramite;

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

    public List<Comision> findPorCamara(String camara) {
        return em.createQuery("SELECT c from Comision c where c.camara = :camara")
                .setParameter("camara", camara)
                .getResultList();
    }

    public List<Comision> findPorCamara(String camara, Estado estado) {
        return em.createQuery("SELECT c from Comision c where c.camara = :camara AND c.estado = :estado")
                .setParameter("camara", camara)
                .setParameter("estado", estado)
                .getResultList();
    }

    public void remover(Comision entity) throws HayProyectosAsociadosException {

        List<Tramite> tramites = em.createQuery("SELECT t FROM Tramite t where t.comisionDictamen = :comision")
                .setParameter("comision", entity)
                .getResultList();

        if (tramites != null && !tramites.isEmpty()) {
            throw new HayProyectosAsociadosException();
        }

        List<Tramite> tramites2 = em.createQuery("SELECT t FROM Tramite t JOIN t.comisiones c WHERE c = :comision")
                .setParameter("comision", entity)
                .getResultList();
        if (tramites2 != null && !tramites2.isEmpty()) {
            throw new HayProyectosAsociadosException();
        }

        super.remove(entity);
    }

}
