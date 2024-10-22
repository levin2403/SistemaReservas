/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Conexion;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 * Clase que incluye un solo metodo para establecer conexion con la base de 
 * datos
 * 
 * @author skevi
 */
public class Conexion {
    
    
    private static EntityManagerFactory entityManagerFactory;

    /**
     * Método estático para obtener el EntityManagerFactory
     * 
     * @return 
     */
    public EntityManagerFactory getEntityManagerFactory() {
        if (entityManagerFactory == null) {
            entityManagerFactory = Persistence.
                    createEntityManagerFactory("miUnidadDePersistencia");
        }
        return entityManagerFactory;
    }

    /**
     * Método para obtener el EntityManager
     * 
     * @return 
     */
    public EntityManager getEntityManager() {
        return getEntityManagerFactory().createEntityManager();
    }

    /**
     * Método para cerrar el EntityManagerFactory
     */
    public static void closeEntityManagerFactory() {
        if (entityManagerFactory != null && entityManagerFactory.isOpen()) {
            entityManagerFactory.close();
        }
    }
    
}
