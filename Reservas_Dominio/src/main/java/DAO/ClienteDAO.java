/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import Conexion.Conexion;
import Entidades.Cliente;
import Interfaces.IClienteDAO;
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
    
}
