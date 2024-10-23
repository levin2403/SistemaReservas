package BO;

import DAO.ReservaDAO;
import DTO.ReservaDTO;
import Interfaces.IReservaBO;
import Interfaces.IReservaDAO;
import java.time.LocalDateTime;
import java.util.List;


public class ReservaBO implements IReservaBO {
    
    IReservaDAO reservaDAO;

    public ReservaBO() {
        this.reservaDAO = new ReservaDAO();
    }

    @Override
    public void agregarReserva(ReservaDTO reserva) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public List<ReservaDTO> consultarPorFecha(LocalDateTime inicio, LocalDateTime fin) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public List<ReservaDTO> consultarPorDia(LocalDateTime dia) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
}
