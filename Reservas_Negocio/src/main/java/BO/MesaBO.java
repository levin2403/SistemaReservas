package BO;

import DAO.MesaDAO;
import DTO.MesaDTO;
import Interfaces.IMesaBO;
import Interfaces.IMesaDAO;
import java.util.List;

public class MesaBO implements IMesaBO {
    
    IMesaDAO mesaDAO;

    /**
     * 
     */
    public MesaBO() {
        this.mesaDAO = new MesaDAO();    
    }

    @Override
    public void agregarMesa(MesaDTO mesa) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void agregarMesas(List<MesaDTO> mesas) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public List<MesaDTO> consultarMesas() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public int cantidadMesasPorTipo(String tipo) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public List<MesaDTO> obtenerMesasPorTipo(String tipo) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

}
