package BO;

import DAO.ClienteDAO;
import DTO.ClienteDTO;
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
    
    IClienteDAO clienteDAO; // instancia de interfaz clienteDAO

    /**
     * 
     */
    public ClienteBO() {
        this.clienteDAO = new ClienteDAO();
    }

    @Override
    public void agregarCliente(ClienteDTO cliente) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public ClienteDTO obtenerCliente(Long id) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public List<ClienteDTO> obtenerClientes() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

}
