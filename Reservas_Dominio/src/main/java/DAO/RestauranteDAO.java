/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import Conexion.Conexion;
import Entidades.Restaurante;
import Interfaces.IRestauranteDAO;
import java.util.logging.Logger;
import javax.persistence.EntityManager;

/**
 *
 * @author skevi
 */
public class RestauranteDAO implements IRestauranteDAO{
    
    //instancia de logger para hacer informes en consola
    private static final Logger LOG = Logger.
            getLogger(HistorialReservaDAO.class.getName());

    // instancia para establecer conexion
    Conexion conexion;

    /**
     * Constructor por defecto
     */
    public RestauranteDAO() {
        this.conexion = new Conexion();
    }
    
    /**
     * 
     * @param restaurante 
     */
    @Override
    public void agregarRestaurante(Restaurante restaurante) {
        EntityManager em = null;
        try {
            em = conexion.getEntityManager(); // Obtener el EntityManager
            em.getTransaction().begin(); // Iniciar la transacción
            em.persist(restaurante); // Persistir el objeto restaurante
            em.getTransaction().commit(); // Confirmar la transacción
            LOG.info("Restaurante agregado con éxito: " + restaurante);
        } catch (Exception e) {
            if (em != null && em.getTransaction().isActive()) {
                em.getTransaction().rollback(); // Revertir la transacción en caso de error
            }
            LOG.severe("Error al agregar el restaurante: " + e.getMessage());
            e.printStackTrace();
        } finally {
            if (em != null) {
                em.close(); // Cerrar el EntityManager
            }
        }
    }

    @Override
    public Restaurante consultar() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}
