/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import Conexion.Conexion;
import Entidades.Reserva;
import Interfaces.IReservaDAO;
import java.time.LocalDate;
import java.util.List;
import java.util.logging.Logger;
import javax.persistence.EntityManager;

/**
 *
 * @author skevi
 */
public class ReservaDAO implements IReservaDAO{
    
    //instancia de logger para hacer informes en consola
    private static final Logger LOG = Logger.
            getLogger(HistorialReservaDAO.class.getName());
    
    // instancia para establecer conexion
    Conexion conexion;

    /**
     * Constructor por defecto
     */
    public ReservaDAO() {
        this.conexion = new Conexion();
    }

    /**
     * 
     * @param reserva 
     */
    public void agregarReserva(Reserva reserva) {
        EntityManager em = null;
        try {
            em = conexion.getEntityManager(); // Obtener el EntityManager
            em.getTransaction().begin(); // Iniciar la transacción
            em.persist(reserva); // Persistir la reserva
            em.getTransaction().commit(); // Confirmar la transacción
            LOG.info("Reserva agregada con éxito: " + reserva);
        } catch (Exception e) {
            if (em != null && em.getTransaction().isActive()) {
                em.getTransaction().rollback(); // Revertir la transacción en caso de error
            }
            LOG.severe("Error al agregar la reserva: " + e.getMessage());
            e.printStackTrace();
        } finally {
            if (em != null) {
                em.close(); // Cerrar el EntityManager
            }
        }
    }

    /**
     * 
     * @param inicio
     * @param fin
     * @return 
     */
    @Override
    public List<Reserva> consultarPorFecha(LocalDate inicio, LocalDate fin) {
        EntityManager em = null;
            List<Reserva> reservas = null;
            try {
                em = conexion.getEntityManager(); // Obtener el EntityManager
                reservas = em.createQuery("SELECT r FROM Reserva r WHERE r.fecha BETWEEN :inicio AND :fin", Reserva.class)
                             .setParameter("inicio", inicio)
                             .setParameter("fin", fin)
                             .getResultList(); // Ejecutar la consulta
                LOG.info(reservas.size() + " reservas encontradas entre " + inicio + " y " + fin);
            } catch (Exception e) {
                LOG.severe("Error al consultar las reservas: " + e.getMessage());
                e.printStackTrace();
            } finally {
                if (em != null) {
                    em.close(); // Cerrar el EntityManager
                }
            }
            return reservas; // Devolver la lista de reservas    }
    }



    
}
