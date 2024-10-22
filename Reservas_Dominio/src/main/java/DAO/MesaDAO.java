/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import Conexion.Conexion;
import Entidades.Mesa;
import Interfaces.IMesaDAO;
import java.util.List;
import java.util.logging.Logger;
import javax.persistence.EntityManager;

/**
 *
 * @author skevi
 */
public class MesaDAO implements IMesaDAO{
    
    //instancia de logger para hacer informes en consola
    private static final Logger LOG = Logger.
            getLogger(HistorialReservaDAO.class.getName());
    
    // instancia para establecer conexion
    Conexion conexion;

    /**
     * Constructor por defecto
     */
    public MesaDAO() {
        this.conexion = new Conexion();
    }

    /**
     * 
     * @param mesa 
     */
    @Override
    public void agregarMesa(Mesa mesa) {
        EntityManager em = null;
        try {
            em = conexion.getEntityManager(); // Obtener el EntityManager
            em.getTransaction().begin(); // Iniciar la transacción
            em.persist(mesa); // Persistir la mesa
            em.getTransaction().commit(); // Confirmar la transacción
            LOG.info("Mesa agregada con éxito: " + mesa);
        } catch (Exception e) {
            if (em != null && em.getTransaction().isActive()) {
                em.getTransaction().rollback(); // Revertir la transacción en caso de error
            }
            LOG.severe("Error al agregar la mesa: " + e.getMessage());
            e.printStackTrace();
        } finally {
            if (em != null) {
                em.close(); // Cerrar el EntityManager
            }
        }
    }

    /**
     * 
     * @param mesas 
     */
    @Override
    public void agregarMesas(List<Mesa> mesas) {
        EntityManager em = null;
        try {
            em = conexion.getEntityManager(); // Obtener el EntityManager
            em.getTransaction().begin(); // Iniciar la transacción
            for (Mesa mesa : mesas) {
                em.persist(mesa); // Persistir cada mesa
            }
            em.getTransaction().commit(); // Confirmar la transacción
            LOG.info(mesas.size() + " mesas agregadas con éxito.");
        } catch (Exception e) {
            if (em != null && em.getTransaction().isActive()) {
                em.getTransaction().rollback(); // Revertir la transacción en caso de error
            }
            LOG.severe("Error al agregar las mesas: " + e.getMessage());
            e.printStackTrace();
        } finally {
            if (em != null) {
                em.close(); // Cerrar el EntityManager
            }
        }
    }

    /**
     * 
     * @param mesa 
     */
    @Override
    public void eliminarMesa(Mesa mesa) {
        EntityManager em = null;
        try {
            em = conexion.getEntityManager(); // Obtener el EntityManager
            em.getTransaction().begin(); // Iniciar la transacción
            Mesa mesaToRemove = em.find(Mesa.class, mesa.getId()); // Buscar la mesa por ID
            if (mesaToRemove != null) {
                em.remove(mesaToRemove); // Eliminar la mesa si existe
                em.getTransaction().commit(); // Confirmar la transacción
                LOG.info("Mesa eliminada con éxito: " + mesa);
            }
        } catch (Exception e) {
            if (em != null && em.getTransaction().isActive()) {
                em.getTransaction().rollback(); // Revertir la transacción en caso de error
            }
            LOG.severe("Error al eliminar la mesa: " + e.getMessage());
            e.printStackTrace();
        } finally {
            if (em != null) {
                em.close(); // Cerrar el EntityManager
            }
        }
    }

    @Override
    public void actualizarMesa(Mesa mesa) {
        EntityManager em = null;
        try {
            em = conexion.getEntityManager(); // Obtener el EntityManager
            em.getTransaction().begin(); // Iniciar la transacción
            em.merge(mesa); // Actualizar la mesa
            em.getTransaction().commit(); // Confirmar la transacción
            LOG.info("Mesa actualizada con éxito: " + mesa);
        } catch (Exception e) {
            if (em != null && em.getTransaction().isActive()) {
                em.getTransaction().rollback(); // Revertir la transacción en caso de error
            }
            LOG.severe("Error al actualizar la mesa: " + e.getMessage());
            e.printStackTrace();
        } finally {
            if (em != null) {
                em.close(); // Cerrar el EntityManager
            }
        }
    }

    /**
     * 
     * @return 
     */
     @Override
    public List<Mesa> consultarMesas() {
        EntityManager em = null;
        List<Mesa> mesas = null;
        try {
            em = conexion.getEntityManager(); // Obtener el EntityManager
            mesas = em.createQuery("SELECT m FROM Mesa m", Mesa.class).getResultList(); // Consultar todas las mesas
            LOG.info(mesas.size() + " mesas encontradas.");
        } catch (Exception e) {
            LOG.severe("Error al consultar las mesas: " + e.getMessage());
            e.printStackTrace();
        } finally {
            if (em != null) {
                em.close(); // Cerrar el EntityManager
            }
        }
        return mesas; // Devolver la lista de mesas
    }

    @Override
    public int cantidadMesasPequeñas() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public int cantidadMesasMedianas() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public int cantidadMesasGrandes() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    
    
}
