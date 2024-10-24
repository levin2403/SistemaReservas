package BO;

import Convertidores.ClienteCVR;
import DAO.ClienteDAO;
import DTO.ClienteDTO;
import Entidades.Cliente;
import Excepciones.BOException;
import Excepciones.ConversionException;
import Excepciones.DAOException;
import Interfaces.IClienteBO;
import Interfaces.IClienteDAO;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Clase que maneja la lógica de negocio para los clientes.
 *
 * @author skevi
 * @author sebastian
 */
public class ClienteBO implements IClienteBO {

    // instancia del logger para depuracion
    private static final Logger LOG = Logger.
            getLogger(ClienteBO.class.getName());
    
    private final IClienteDAO clienteDAO; // instancia de interfaz clienteDAO
    private final ClienteCVR clienteCVR; // instancia del convertidor de cliente

    /**
     * Constructor por defecto de la clase.
     */
    public ClienteBO() {
        this.clienteDAO = new ClienteDAO();
        this.clienteCVR = new ClienteCVR();
    }

    /**
     * Metodo de control entre la capa de DAO y BO para el metodo de obtener
     * cliente por id, este metodo se encarga de obtener tal cliente de 
     * la capa de DAO y lo convierte a un DTO para su uso en capas superiores.
     * 
     * @param id id del cliente a buscar
     * @return retorna un ClienteDTO
     * @throws BOException En caso de excepciones en capas inferiores.
     */
    @Override
    public ClienteDTO obtenerCliente(Long id) throws BOException {
        try{
            Cliente cliente = clienteDAO.obtenerCliente(id);
            ClienteDTO clienteDTO = clienteCVR.toDTO(cliente);
            
            LOG.log(Level.INFO, "exito al obtener al cliente por id en BO");
            
            return clienteDTO;
        }
        catch(DAOException de){
            LOG.log(Level.SEVERE, "Error al obtener el cliente por id en BO", 
                    de);
            throw new BOException(de.getMessage());
        }
        catch(ConversionException ce){
            LOG.log(Level.SEVERE, "Error al obtener el cliente por id en BO", 
                    ce);
            throw new BOException("Error al obtener el cliente por id");
        }
    }

    @Override
    public List<ClienteDTO> obtenerClientes() throws BOException {
       try{
           List<Cliente> entidades = clienteDAO.obtenerClientes();
           List<ClienteDTO> dto = new ArrayList<>();
           
           for (ClienteDTO clienteDTO : dto) {
               entidades.add(clienteCVR.toEntity(clienteDTO));
           }
           
           return dto;
       }
       catch(DAOException de){
            LOG.log(Level.SEVERE, "Error al obtener los clientes en BO", 
                    de);
            throw new BOException(de.getMessage());
        }
        catch(ConversionException ce){
            LOG.log(Level.SEVERE, "Error al obtener el clientes en BO", 
                    ce);
            throw new BOException("Error al obtener el cliente por id");
        }
    }
    
}
