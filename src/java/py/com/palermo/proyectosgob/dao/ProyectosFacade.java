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
import py.com.palermo.proyectosgob.persistencia.Proyectos;

/**
 *
 * @author cromero
 */
@Stateless
public class ProyectosFacade extends AbstractFacade<Proyectos> {

    @PersistenceContext(unitName = "ProyectosGobPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public ProyectosFacade() {
        super(Proyectos.class);
    }

    public List<Proyectos> getResultados(String frase) {
        System.out.println("frase: " + frase);
        
        frase = frase.trim().toUpperCase()
                .replace("Á", "A")
                .replace("É", "E")
                .replace("Í", "I")
                .replace("Ó", "O")
                .replace("Ú", "U");
        
        String replaceNombre = "TRIM(FUNCTION('REPLACE',FUNCTION('REPLACE',FUNCTION('REPLACE',FUNCTION('REPLACE',FUNCTION('REPLACE',UPPER(p.proyectosnombre),'Á','A'),'É','E'),'Í','I'),'Ó','O'),'Ú','U'))";
        return em.createQuery("SELECT p from Proyectos p where TRIM(UPPER(p.proyectosnroexpediente)) LIKE CONCAT('%',CONCAT(?1, '%')) OR "
                + replaceNombre + " LIKE CONCAT('%',CONCAT(?1, '%'))")
                .setParameter(1, frase.toUpperCase())
                .getResultList();
    }
}
