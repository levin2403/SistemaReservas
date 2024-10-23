/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import Conexion.Conexion;
import Entidades.Mesa;
import Interfaces.IMesaDAO;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.persistence.EntityManager;
import javax.persistence.Query;

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
            LOG.log(Level.INFO, "Mesa agregada con \u00e9xito: {0}", mesa);
        } catch (Exception e) {
            if (em != null && em.getTransaction().isActive()) {
                em.getTransaction().rollback(); // Revertir la transacción en caso de error
            }
            LOG.log(Level.SEVERE, "Error al agregar la mesa: {0}", e.getMessage());
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
            LOG.log(Level.INFO, "{0} mesas agregadas con \u00e9xito.", mesas.size());
        } catch (Exception e) {
            if (em != null && em.getTransaction().isActive()) {
                em.getTransaction().rollback(); // Revertir la transacción en caso de error
            }
            LOG.log(Level.SEVERE, "Error al agregar las mesas: {0}", e.getMessage());
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
//    @Override
//    public void eliminarMesa(Mesa mesa) {
//        EntityManager em = null;
//        try {
//            em = conexion.getEntityManager(); // Obtener el EntityManager
//            em.getTransaction().begin(); // Iniciar la transacción
//            Mesa mesaToRemove = em.find(Mesa.class, mesa.getId()); // Buscar la mesa por ID
//            if (mesaToRemove != null) {
//                em.remove(mesaToRemove); // Eliminar la mesa si existe
//                em.getTransaction().commit(); // Confirmar la transacción
//                LOG.info("Mesa eliminada con éxito: " + mesa);
//            }
//        } catch (Exception e) {
//            if (em != null && em.getTransaction().isActive()) {
//                em.getTransaction().rollback(); // Revertir la transacción en caso de error
//            }
//            LOG.severe("Error al eliminar la mesa: " + e.getMessage());
//            e.printStackTrace();
//        } finally {
//            if (em != null) {
//                em.close(); // Cerrar el EntityManager
//            }
//        }
//    }

//    @Override
//    public void actualizarMesa(Mesa mesa) {
//        EntityManager em = null;
//        try {
//            em = conexion.getEntityManager(); // Obtener el EntityManager
//            em.getTransaction().begin(); // Iniciar la transacción
//            em.merge(mesa); // Actualizar la mesa
//            em.getTransaction().commit(); // Confirmar la transacción
//            LOG.info("Mesa actualizada con éxito: " + mesa);
//        } catch (Exception e) {
//            if (em != null && em.getTransaction().isActive()) {
//                em.getTransaction().rollback(); // Revertir la transacción en caso de error
//            }
//            LOG.severe("Error al actualizar la mesa: " + e.getMessage());
//            e.printStackTrace();
//        } finally {
//            if (em != null) {
//                em.close(); // Cerrar el EntityManager
//            }
//        }
//    }

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
            LOG.log(Level.INFO, "{0} mesas encontradas.", mesas.size());
        } catch (Exception e) {
            LOG.log(Level.SEVERE, "Error al consultar las mesas: {0}", e.getMessage());
        } finally {
            if (em != null) {
                em.close(); // Cerrar el EntityManager
            }
        }
        return mesas; // Devolver la lista de mesas
    }

    /**
     * Retorna la cantidad de mesas por tipo
     * 
     * @param tipo Tipo de mesa;
     * @return Entero con la cantidad de mesas de ese tipo.
     */
    @Override
    public int cantidadMesasPorTipo(String tipo) {
        EntityManager em = null;
        int cantidad = 0;
        try {
            em = conexion.getEntityManager(); // Obtener el EntityManager
            Query query = em.createQuery("SELECT COUNT(m) FROM Mesa m WHERE m.tipoMesa = :tipo"); // Crear la consulta
            query.setParameter("tipo", tipo); // Pasar el parámetro
            cantidad = ((Long) query.getSingleResult()).intValue(); // Obtener el resultado y convertir a int
        } catch (Exception e) {
            LOG.log(Level.SEVERE, 
                    "Error al obtener la cantidad de mesas por tipo: {0}", 
                    e.getMessage());
        } finally {
            if (em != null) {
                em.close(); // Cerrar el EntityManager
            }
        }
        return cantidad;
    }

    /**
     * Obtiene una lista de mesas dependiendo su tipo especificado en el 
     * parámetro.
     * 
     * @param tipo Tipo de mesa.
     * @return Lista de mesas filtradas por tipo.
     */
    @Override
    public List<Mesa> obtenerMesasPorTipo(String tipo) {
        EntityManager em = null;
        List<Mesa> mesas = new ArrayList<>();
        try {
            em = conexion.getEntityManager(); // Obtener el EntityManager
            Query query = 
                    em.createQuery("SELECT m FROM Mesa m WHERE m.tipoMesa = :tipo"); // Crear la consulta
            query.setParameter("tipo", tipo); // Pasar el parámetro
            mesas = query.getResultList(); // Obtener el resultado
        } catch (Exception e) {
            LOG.log(Level.SEVERE, 
                    "Error al obtener las mesas por tipo: {0}", e.getMessage());
        } finally {
            if (em != null) {
                em.close(); // Cerrar el EntityManager
            }
        }
        return mesas;
    }


    
    
}
