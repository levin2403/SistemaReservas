/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import Conexion.Conexion;
import Entidades.Cliente;
import Entidades.HistorialReserva;
import Entidades.Mesa;
import Entidades.Restaurante;
import Interfaces.IHistorialReservasDAO;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;
import javax.persistence.EntityManager;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Join;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

/**
 *
 * @author skevi
 */
public class HistorialReservaDAO implements IHistorialReservasDAO {

    //instancia de logger para hacer informes en consola
    private static final Logger LOG = Logger.
            getLogger(HistorialReservaDAO.class.getName());
    
    // instancia para establecer conexion
    Conexion conexion;

    /**
     * Constructor por defecto
     */
    public HistorialReservaDAO() {
        this.conexion = new Conexion();
    }

    /**
     * Agrega al historial de reservas un nuevo historial acerca de una 
     * reservacion que ya se hizo
     * 
     * @param historialReserva 
     */
    @Override
    public void agregar(HistorialReserva historialReserva) {
        EntityManager em = null;
        try {
            em = conexion.getEntityManager(); // Obtener el EntityManager
            em.getTransaction().begin(); // Iniciar la transacción
            em.persist(historialReserva); // Persistir la reserva
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
     * Actualiza el historial de reservas para indicar si cancelo una 
     * reservacion y en caso de que haya habido multa por ello.
     * 
     * @param historialReserva Nuevo historial de reserva.
     */
    @Override
    public void actualizar(HistorialReserva historialReserva) {
        EntityManager em = null;
        try {
            em = conexion.getEntityManager(); // Obtener el EntityManager
            em.getTransaction().begin(); // Iniciar la transacción
            em.merge(historialReserva); // Actualizar el historial de reserva
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
     * 
     * @param nombreCliente
     * @param telefonoCliente
     * @param fechaReserva
     * @param areaRestaurante
     * @param fechaInicio
     * @param fechaFin
     * @param tamanoMesa
     * @return 
     */
    public List<HistorialReserva> buscarReservasPorFiltros(String nombreCliente, 
            String telefonoCliente, LocalDate fechaReserva,
            String areaRestaurante, LocalDate fechaInicio, 
            LocalDate fechaFin, Integer tamanoMesa) {
        
    EntityManager em = null;
    List<HistorialReserva> resultados = null;
    
    try {
        em = conexion.getEntityManager();
        
        // CriteriaBuilder para crear la consulta
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<HistorialReserva> cq = cb.createQuery(HistorialReserva.class);
        Root<HistorialReserva> reserva = cq.from(HistorialReserva.class);
        Join<HistorialReserva, Mesa> mesa = reserva.join("mesa");
        Join<Mesa, Restaurante> restaurante = mesa.join("restaurante");
        Join<HistorialReserva, Cliente> cliente = reserva.join("cliente"); 
        // Asegúrate de que esto esté definido en la entidad HistorialReserva
        
        // Lista de predicados (filtros)
        List<Predicate> predicates = new ArrayList<>();
        
        // Filtros de cliente
        if (nombreCliente != null && !nombreCliente.isEmpty()) {
            predicates.add(cb.like(cliente.get("nombre"), "%" + nombreCliente + "%"));
        }
        
        if (telefonoCliente != null && !telefonoCliente.isEmpty()) {
            predicates.add(cb.equal(cliente.get("telefono"), telefonoCliente));
        }
        
        if (fechaReserva != null) {
            predicates.add(cb.equal(reserva.get("fechaReserva"), fechaReserva));
        }
        
        // Filtros de reserva
        if (areaRestaurante != null && !areaRestaurante.isEmpty()) {
            predicates.add(cb.equal(restaurante.get("area"), areaRestaurante));
        }
        
        if (fechaInicio != null) {
            predicates.add(cb.greaterThanOrEqualTo(reserva.get("fechaReserva"), fechaInicio));
        }
        
        if (fechaFin != null) {
            predicates.add(cb.lessThanOrEqualTo(reserva.get("fechaReserva"), fechaFin));
        }
        
        if (tamanoMesa != null) {
            predicates.add(cb.equal(mesa.get("tamano"), tamanoMesa));
        }
        
        // Aplicar los predicados a la consulta
        cq.where(predicates.toArray(new Predicate[0]));

        // Ejecutar la consulta y obtener resultados
        resultados = em.createQuery(cq).getResultList();
        
    } catch (Exception e) {
        LOG.severe("Error al buscar reservas: " + e.getMessage());
        e.printStackTrace();
    } finally {
        if (em != null) {
            em.close();
        }
    }
    
    return resultados; // Devolver la lista de reservas
}

    
    
}
