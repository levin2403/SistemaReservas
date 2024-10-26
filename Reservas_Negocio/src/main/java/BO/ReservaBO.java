package BO;

import Convertidores.ClienteCVR;
import Convertidores.MesaCVR;
import Convertidores.ReservaCVR;
import DAO.ReservaDAO;
import DTOs.ClienteDTO;
import DTOs.MesaDTO;
import DTOs.ReservaDTO;
import Entidades.Cliente;
import Entidades.Mesa;
import Entidades.Reserva;
import Excepciones.BOException;
import Excepciones.ConversionException;
import Excepciones.DAOException;
import Interfaces.IReservaBO;
import Interfaces.IReservaDAO;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * 
 * @author skevi
 */
public class ReservaBO implements IReservaBO {

    // instancia de logger para depuracion.
    private static final Logger LOG = Logger.
            getLogger(ReservaBO.class.getName());
    
    // instancia de la interfaz de ReservaDAO.
    private final IReservaDAO reservaDAO; 
   
    // instancia del convertidor de Reservas.
    private final ReservaCVR reservaCVR; 
    
    //instancia del convertidor de cliente
    private final ClienteCVR clienteCVR;
    
    //instancia del convertidor de mesa.
    private final MesaCVR mesaCVR;

    /**
     * Constructor por defecto de la clase.
     */
    public ReservaBO() {
        this.reservaDAO = new ReservaDAO();
        this.reservaCVR = new ReservaCVR();
        this.clienteCVR = new ClienteCVR();
        this.mesaCVR = new MesaCVR();
    }

    /**
     * 
     * @param reserva
     * @throws BOException 
     */
    @Override
    public void agregarReserva(ReservaDTO reserva) throws BOException {
        try{
            Reserva reservaEntity = reservaCVR.toEntity(reserva);
            reservaDAO.agregarReserva(reservaEntity);
        }
        catch(DAOException de){
            LOG.log(Level.SEVERE, "Error al agregar la reserva en dao", de);
            throw new BOException(de.getMessage());
        }
    }

    /**
     * 
     * @param inicio
     * @param fin
     * @return
     * @throws BOException 
     */
    @Override
    public List<ReservaDTO> consultarPorFecha(LocalDateTime inicio, 
            LocalDateTime fin) throws BOException {
        try{
           List<Reserva> entidades = reservaDAO.consultarPorFecha(inicio, fin);
           List<ReservaDTO> dto = new ArrayList<>();
            
            for (Reserva reserva : entidades) {
                dto.add(reservaCVR.toDTO(reserva));
            }
           
            return dto;
        }
        catch(DAOException de){
            LOG.log(Level.SEVERE, "Error al agregar la reserva en dao", de);
            throw new BOException(de.getMessage());
        }
    }

    /**
     * 
     * @param mesa
     * @param dia
     * @return
     * @throws BOException 
     */
    @Override
    public boolean verificarPorDia(MesaDTO mesa, LocalDateTime dia)
            throws BOException {
        try{
            Mesa mesaEntidad = mesaCVR.toEntity(mesa);
            
            boolean resultado = reservaDAO.verificarPorDia(mesaEntidad, dia);
            return resultado;
        }
        catch(DAOException de){
            LOG.log(Level.SEVERE, "Error al agregar la reserva en dao", de);
            throw new BOException(de.getMessage());
        } catch (ConversionException ex) {
            Logger.getLogger(ReservaBO.class.getName()).log(Level.SEVERE, null, ex);
            throw new BOException("Error al verificar la reserva por dia");
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
     * @throws BOException 
     */
    @Override
    public List<ReservaDTO> buscarReservasPorFiltros(String nombreCliente, 
            String telefonoCliente, LocalDate fechaReserva, 
            String areaRestaurante, LocalDate fechaInicio, LocalDate fechaFin, 
            Integer tamanoMesa) throws BOException {
        
        try{
           List<Reserva> entidades = reservaDAO.
                   buscarReservasPorFiltros(nombreCliente, telefonoCliente, 
                           fechaReserva, areaRestaurante, fechaInicio, 
                           fechaFin, tamanoMesa);
           
           List<ReservaDTO> dto = new ArrayList<>();
            
            for (Reserva reserva : entidades) {
                dto.add(reservaCVR.toDTO(reserva));
            }
           
            return dto;
        }
        catch(DAOException de){
            LOG.log(Level.SEVERE, "Error al agregar la reserva en dao", de);
            throw new BOException(de.getMessage());
        }
    }

    /**
     * Verifica que el cliente dado en el parametro ya no tenga mas 
     * reservaciones a partir de la hora y fecha dada, en caso de tener 
     * reservaciones a partir de esa fecha y hora se regresara un nulo
     * indicando que hay reservaciones activas, por otro lado en caso de no 
     * haber encontrado ninguna retornara un false.
     * 
     * @param cliente Cliente de cual queremos buscar las resarvaciones.
     * @return True en caso de que haya reservaciones, false en caso contrario
     * @throws Excepciones.BOException En caso de excepcion uno nunc sabe.
     */
    @Override
    public boolean verificarReservaciones(ClienteDTO cliente) throws BOException {
        try{
            Cliente clienteEntidad = clienteCVR.toEntity(cliente);
            return reservaDAO.verificarReservaciones(clienteEntidad);
        }
        catch(ConversionException ce){
            LOG.log(Level.SEVERE, "Error en verificar las reservaciones en BO");
            throw new BOException(ce.getMessage());
        } catch (DAOException ex) {
            LOG.log(Level.SEVERE, "Error en verificar las reservaciones en BO");
            throw new BOException(ex.getMessage());
        }
    }
    
}
