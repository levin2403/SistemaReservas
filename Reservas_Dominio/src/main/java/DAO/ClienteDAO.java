/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import Conexion.Conexion;
import Entidades.Cliente;
import Interfaces.IClienteDAO;
import java.util.List;
import java.util.logging.Logger;
import javax.persistence.EntityManager;

/**
 *
 * @author skevi
 */
public class ClienteDAO implements IClienteDAO{
    
    //instancia de logger para hacer informes en consola
    private static final Logger LOG = Logger.
            getLogger(HistorialReservaDAO.class.getName());
    
    //instancia de la conexion
    Conexion conexion;

    public ClienteDAO() {
        this.conexion = new Conexion();
    }

    
    /**
     * Agrega un nuevo cliente a la base de datos.
     * 
     * @param cliente Cliente a agregar.
     */
    @Override
    public void agregarCliente(Cliente cliente) {
        EntityManager em = null;
        try {
            em = conexion.getEntityManager(); // Obtener el EntityManager
            em.getTransaction().begin(); // Iniciar la transacción
            em.persist(cliente); // Guardar el cliente en la base de datos
            em.getTransaction().commit(); // Confirmar la transacción
        } catch (Exception e) {
            if (em != null && em.getTransaction().isActive()) {
                em.getTransaction().rollback(); // Revertir la transacción en caso de error
            }
            e.printStackTrace();
        } finally {
            if (em != null) {
                em.close(); // Cerrar el EntityManager
            }
        }
    }

    /**
     * Obtiene un cliente en especifico de la base de datos.
     *
     * @param id Id del cliente a obtener.
     * @return Cliente obtenido o null si no se encuentra.
     */
    @Override
    public Cliente obtenerCliente(Long id) {
        EntityManager em = null;
        Cliente cliente = null;
        try {
            em = conexion.getEntityManager(); // Obtener el EntityManager
            cliente = em.find(Cliente.class, id); // Buscar el cliente por su id
            if (cliente != null) {
                LOG.info("Cliente obtenido exitosamente.");
            } else {
                LOG.warning("Cliente no encontrado.");
            }
        } catch (Exception e) {
            LOG.severe("Error al obtener el cliente: " + e.getMessage());
            e.printStackTrace();
        } finally {
            if (em != null) {
                em.close(); // Cerrar el EntityManager
            }
        }
        return cliente;
    }
    /**
     * Obtiene una lista de todos los clientes en la base de datos.
     *
     * @return Lista de todos los clientes.
     */
    @Override
    public List<Cliente> obtenerClientes() {
        EntityManager em = null;
        List<Cliente> clientes = null;
        try {
            em = conexion.getEntityManager(); // Obtener el EntityManager
            clientes = em.createQuery("SELECT c FROM Cliente c", Cliente.class).getResultList(); // Consultar todos los clientes
            LOG.info("Clientes obtenidos exitosamente.");
        } catch (Exception e) {
            LOG.severe("Error al obtener los clientes: " + e.getMessage());
            e.printStackTrace();
        } finally {
            if (em != null) {
                em.close(); // Cerrar el EntityManager
            }
        }
        return clientes;
    }
    
}
