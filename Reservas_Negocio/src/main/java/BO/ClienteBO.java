package BO;

import Convertidores.ClienteCVR;
import DAO.ClienteDAO;
import DTO.ClienteDTO;
import Excepciones.BOException;
import Interfaces.IClienteBO;
import Interfaces.IClienteDAO;
import java.util.List;

/**
 * Clase que maneja la lógica de negocio para los clientes.
 *
 * @author skevi
 * @author sebastian
 */
public class ClienteBO implements IClienteBO {
    
    private final IClienteDAO clienteDAO; // instancia de interfaz clienteDAO
    private final ClienteCVR clienteCVR;

    public ClienteBO() {
        this.clienteDAO = new ClienteDAO();
        this.clienteCVR = new ClienteCVR();
    }

    @Override
    public ClienteDTO obtenerCliente(Long id) throws BOException {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public List<ClienteDTO> obtenerClientes() throws BOException {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
}
