package BO;

import Convertidores.MesaCVR;
import DAO.MesaDAO;
import DTO.MesaDTO;
import Excepciones.BOException;
import Interfaces.IMesaBO;
import Interfaces.IMesaDAO;
import java.util.List;

/**
 * 
 * @author skevi
 */
public class MesaBO implements IMesaBO {
    
    private final IMesaDAO mesaDAO;
    private final MesaCVR mesaCVR;

    /**
     * 
     */
    public MesaBO() {
        this.mesaDAO = new MesaDAO();   
        this.mesaCVR = new MesaCVR();
    }

    @Override
    public void agregarMesas(List<MesaDTO> mesas) throws BOException {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public List<MesaDTO> consultarMesas() throws BOException {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public int cantidadMesasPorTipo(String tipo) throws BOException {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public List<MesaDTO> obtenerMesasPorTipo(String tipo) throws BOException {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

}
