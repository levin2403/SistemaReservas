/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import Conexion.Conexion;
import Entidades.Restaurante;
import Excepciones.ConexionException;
import Excepciones.DAOException;
import Interfaces.IRestauranteDAO;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceException;

/**
 * Clase de acceso a datos para la entidad de Restaurante.
 * 
 * @author skevi
 */
public class RestauranteDAO implements IRestauranteDAO{
    
    //instancia de logger para hacer informes en consola
    private static final Logger LOG = Logger.
            getLogger(RestauranteDAO.class.getName());

    // instancia para establecer conexion
    Conexion conexion;

    /**
     * Constructor por defecto
     */
    public RestauranteDAO() {
        this.conexion = new Conexion();
    }
    
    /**
     * Metodo para consultar el unico restaurante en existencia, ya que para
     * este programa solo existira uno.
     * 
     * @return Restaurante.
     */
    @Override
    public Restaurante consultar() throws DAOException{
        EntityManager em = null;
        Restaurante restaurante = null;
        try {
            em = conexion.getEntityManager(); // Obtener el EntityManager
            // Consultar el único restaurante existente en la base de datos
            restaurante = em.createQuery("SELECT r FROM Restaurante r", 
                    Restaurante.class)
                            .setMaxResults(1) 
                            .getSingleResult(); 

            LOG.log(Level.INFO, "Restaurante obtenido con \u00e9xito: {0}", 
                    restaurante);
        } catch (PersistenceException pe) {
            LOG.log(Level.SEVERE, "Error al obtener el restaurante: {0}", 
                    pe.getMessage());
            
            throw new DAOException("Error al consultar el restaurante");
            
        } catch (ConexionException ex) {
            Logger.getLogger(RestauranteDAO.class.getName()).log(Level.SEVERE, 
                    null, ex);
        } finally {
            if (em != null) {
                em.close(); // Cerrar el EntityManager
            }
        }
        return restaurante;
    }
}
