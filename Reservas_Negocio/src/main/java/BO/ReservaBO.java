package BO;

import Convertidores.ReservaCVR;
import DAO.ReservaDAO;
import DTO.ReservaDTO;
import Entidades.Reserva;
import Excepciones.BOException;
import Interfaces.IReservaBO;
import Interfaces.IReservaDAO;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

/**
 * 
 * @author skevi
 */
public class ReservaBO implements IReservaBO {
    
    private final IReservaDAO reservaDAO;
    private final ReservaCVR reservaCVR;

    public ReservaBO() {
        this.reservaDAO = new ReservaDAO();
        this.reservaCVR = new ReservaCVR();
        
    }

    @Override
    public void agregarReserva(ReservaDTO reserva) throws BOException {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public List<ReservaDTO> consultarPorFecha(LocalDateTime inicio, LocalDateTime fin) throws BOException {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public List<ReservaDTO> consultarPorDia(LocalDateTime dia) throws BOException {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public List<Reserva> buscarReservasPorFiltros(String nombreCliente, String telefonoCliente, LocalDate fechaReserva, String areaRestaurante, LocalDate fechaInicio, LocalDate fechaFin, Integer tamanoMesa) throws BOException {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
}
