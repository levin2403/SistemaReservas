package BO;

import Convertidores.ReservaCVR;
import DAO.ReservaDAO;
import DTO.ReservaDTO;
import Entidades.Reserva;
import Excepciones.BOException;
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

    /**
     * Constructor por defecto de la clase.
     */
    public ReservaBO() {
        this.reservaDAO = new ReservaDAO();
        this.reservaCVR = new ReservaCVR();
        
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
     * @param dia
     * @return
     * @throws BOException 
     */
    @Override
    public List<ReservaDTO> consultarPorDia(LocalDateTime dia) 
            throws BOException {
        try{
           List<Reserva> entidades = reservaDAO.consultarPorDia(dia);
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
    
}
