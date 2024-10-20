package BO;

import DAO.ClienteDAO;
import DTO.ClienteDTO;
import Entidades.Cliente;
import Interfaces.IClienteDAO;
import java.util.List;
import java.util.logging.Logger;

/**
 * Clase que maneja la lógica de negocio para los clientes.
 * 
 * @author skevi
 * @author sebastian
 */
public class ClienteBO {

    private static final Logger LOG = Logger.getLogger(ClienteBO.class.getName());

    // Instancia del DAO para interactuar con la base de datos
    private IClienteDAO clienteDAO;

    public ClienteBO() {
        this.clienteDAO = new ClienteDAO();
    }

    /**
     * Método para agregar un cliente a la base de datos.
     * 
     * @param clienteDTO El DTO con los datos del cliente.
     * @return true si el cliente se agregó con éxito, false en caso contrario.
     */
    public boolean agregarCliente(ClienteDTO clienteDTO) {
        Cliente cliente = convertirDTOAEntidad(clienteDTO);

        try {
            clienteDAO.agregarCliente(cliente);
            LOG.info("Cliente agregado correctamente: " + clienteDTO.getNombreCompleto());
            return true;
        } catch (Exception e) {
            LOG.severe("Error al agregar cliente: " + e.getMessage());
            return false;
        }
    }

    /**
     * Método para convertir un DTO a una entidad Cliente.
     * 
     * @param clienteDTO El DTO que contiene los datos del cliente.
     * @return La entidad Cliente.
     */
    private Cliente convertirDTOAEntidad(ClienteDTO clienteDTO) {
        Cliente cliente = new Cliente();
        cliente.setNombreCompleto(clienteDTO.getNombreCompleto());
        cliente.setTelefono(clienteDTO.getTelefono());
        return cliente;
    }

    // Otros métodos que manejen la lógica de negocio, por ejemplo, obtener cliente, eliminar cliente, etc.
}

