/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package py.com.palermo.proyectosgob.dao;

/**
 *
 * @author cromero
 */
public class HayProyectosAsociadosException extends Exception {

    public HayProyectosAsociadosException() {
        super("No se puede borrar, hay proyectos asociados");
    }

}
