/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import Conexion.Conexion;
import Entidades.Cliente;
import Entidades.Mesa;
import Entidades.Reserva;
import Entidades.Restaurante;
import Excepciones.ConexionException;
import Excepciones.DAOException;
import Interfaces.IReservaDAO;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceException;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Join;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

/**
 * Clase de acceso a datos para la entidad de Reserva.
 * 
 * @author skevi
 */
public class ReservaDAO implements IReservaDAO{
    
    //instancia de logger para hacer informes en consola
    private static final Logger LOG = Logger.
            getLogger(ReservaDAO.class.getName());
    
    // instancia para establecer conexion
    Conexion conexion;

    /**
     * Constructor por defecto
     */
    public ReservaDAO() {
        this.conexion = new Conexion();
    }

    /**
     * Metodo que agrega una reserva a la base de datos.
     * 
     * @param reserva reserva a agregar.
     */
    @Override
    public void agregarReserva(Reserva reserva) throws DAOException{
        EntityManager em = null;
        try {
            em = conexion.getEntityManager(); // Obtener el EntityManager
            em.getTransaction().begin(); // Iniciar la transacción
            em.persist(reserva); // Persistir la reserva
            em.getTransaction().commit(); // Confirmar la transacción
            LOG.log(Level.INFO, "Reserva agregada con \u00e9xito: {0}", 
                    reserva);
        } catch (PersistenceException pe) {
            if (em != null && em.getTransaction().isActive()) {
                em.getTransaction().rollback(); 
            }
            
            LOG.log(Level.SEVERE, "Error al agregar la reserva: {0}", 
                    pe.getMessage());
            
            throw new DAOException("Error al agregar la reserva");
            
        } catch (ConexionException ex) {
            Logger.getLogger(ReservaDAO.class.getName()).log(Level.SEVERE, 
                    null, ex);
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
    public List<Reserva> consultarPorFecha(LocalDateTime inicio, 
            LocalDateTime fin) throws DAOException{
        EntityManager em = null;
            List<Reserva> reservas = null;
            try {
                em = conexion.getEntityManager(); // Obtener el EntityManager
                reservas = em.createQuery("SELECT r FROM Reserva r WHERE "
                        + "r.fechaHoraReserva BETWEEN :inicio AND :fin", 
                        Reserva.class)
                             .setParameter("inicio", inicio)
                             .setParameter("fin", fin)
                             .getResultList(); // Ejecutar la consulta
                LOG.log(Level.INFO, "{0} reservas encontradas entre {1} y {2}", 
                        new Object[]{reservas.size(), inicio, fin});
            } catch (PersistenceException pe) {
                
                LOG.log(Level.SEVERE, "Error al consultar las reservas: {0}", 
                        pe.getMessage());
                
                throw new DAOException("Error al consultar las reservas");
                
            } catch (ConexionException ex) {
            Logger.getLogger(ReservaDAO.class.getName()).log(Level.SEVERE, 
                    null, ex);
        } finally {
                if (em != null) {
                    em.close(); // Cerrar el EntityManager
                }
            }
            return reservas; // Devolver la lista de reservas    }
    }

    /**
     * Busca las reservaciones echas en un dia especifico.
     * 
     * @param dia
     * @return 
     */
    @Override
    public List<Reserva> consultarPorDia(LocalDateTime dia) throws DAOException{
        EntityManager em = null;
        List<Reserva> reservas = null;

        try {
            em = conexion.getEntityManager();

            // Definir el rango de tiempo para todo el día
            LocalDateTime inicioDia = dia.toLocalDate().atStartOfDay(); 
            LocalDateTime finDia = dia.toLocalDate().atTime(23, 59, 59);

            // Crear la consulta JPQL para obtener todas las reservas en ese 
            // rango de tiempo
            TypedQuery<Reserva> query = em.createQuery(
                "SELECT r FROM Reserva r WHERE r.fechaHoraReserva BETWEEN "
                        + ":inicioDia AND :finDia", 
                Reserva.class
            );

            // Establecer los parámetros de fecha/hora
            query.setParameter("inicioDia", inicioDia);
            query.setParameter("finDia", finDia);

            // Obtener la lista de resultados
            reservas = query.getResultList();

        } catch (PersistenceException pe) {
            LOG.log(Level.SEVERE, "Error al consultar reservas por d\u00eda: "
                    + "{0}", pe.getMessage());
            
            throw new DAOException("Error al consultar la reservas");
            
            
        } catch (ConexionException ex) {
            Logger.getLogger(ReservaDAO.class.getName()).log(Level.SEVERE, 
                    null, ex);
        } finally {
            if (em != null) {
                em.close(); // Cerrar el EntityManager
            }
        }

        return reservas;
    }

    /**
     * Metodo que mediante filtros obtiene las reservas que mas se adapten
     * algunos datos del parametro pueden ser nulos pero aun asi se adapta
     * a lo requerido
     * 
     * @param nombreCliente Nombre del cliente.
     * @param telefonoCliente Telefono del cliente.
     * @param fechaReserva Fecha en que fue realizada la reserva.
     * @param areaRestaurante Area del restaurante.
     * @param fechaInicio Fecha de inicio para la busqueda.
     * @param fechaFin Fecha de fin para la busqueda.
     * @param tamanoMesa Tamaño de la mesa.
     * 
     * @return Retorna lista de reservaciones que mas se adapten a 
     *         los parametros
     */
    @Override
    public List<Reserva> buscarReservasPorFiltros(String nombreCliente, 
            String telefonoCliente, LocalDate fechaReserva, 
            String areaRestaurante, LocalDate fechaInicio, 
            LocalDate fechaFin, Integer tamanoMesa) throws DAOException{

        EntityManager em = null;
        List<Reserva> resultados = null;

        try {
            em = conexion.getEntityManager();

            // CriteriaBuilder para crear la consulta
            CriteriaBuilder cb = em.getCriteriaBuilder();
            CriteriaQuery<Reserva> cq = cb.createQuery(Reserva.class);
            Root<Reserva> reserva = cq.from(Reserva.class);
            Join<Reserva, Cliente> cliente = reserva.join("cliente");
            Join<Reserva, Mesa> mesa = reserva.join("mesa");
            Join<Mesa, Restaurante> restaurante = mesa.join("restaurante");

            // Lista de predicados (filtros)
            List<Predicate> predicates = new ArrayList<>();

            // Filtros de cliente
            if (nombreCliente != null && !nombreCliente.isEmpty()) {
                predicates.add(cb.like(cliente.get("nombre"), "%" + 
                        nombreCliente + "%"));
            }

            if (telefonoCliente != null && !telefonoCliente.isEmpty()) {
                predicates.add(cb.equal(cliente.get("telefono"), 
                        telefonoCliente));
            }

            // Filtros de reserva
            if (fechaReserva != null) {
                predicates.add(cb.equal(reserva.get("fechaHoraReserva"), 
                        fechaReserva.atStartOfDay()));
            }

            if (areaRestaurante != null && !areaRestaurante.isEmpty()) {
                predicates.add(cb.equal(restaurante.get("area"), 
                        areaRestaurante));
            }

            if (fechaInicio != null) {
                predicates.add(cb.greaterThanOrEqualTo(reserva.
                        get("fechaHoraReserva"), fechaInicio.atStartOfDay()));
            }

            if (fechaFin != null) {
                predicates.add(cb.lessThanOrEqualTo(reserva.
                        get("fechaHoraReserva"), fechaFin.atTime(23, 59, 59)));
            }

            if (tamanoMesa != null) {
                predicates.add(cb.equal(mesa.get("tamano"), tamanoMesa));
            }

            // Aplicar los predicados a la consulta
            cq.where(predicates.toArray(new Predicate[0]));

            // Ejecutar la consulta y obtener resultados
            resultados = em.createQuery(cq).getResultList();

        } catch (PersistenceException pe) {
            LOG.log(Level.SEVERE, "Error al buscar reservas por filtros: {0}", 
                    pe.getMessage());
            
            throw new DAOException("Error al buscar reservas");
            
        } catch (ConexionException ex) { 
            Logger.getLogger(ReservaDAO.class.getName()).log(Level.SEVERE, 
                    null, ex);
            
        } finally {
            if (em != null) {
                em.close();
            }
        }

        return resultados; // Devolver la lista de reservas
    }





    
}
