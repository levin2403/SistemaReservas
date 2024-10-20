/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Convertidores;

import BO.ClienteBO;
import DTO.ClienteDTO;
import Entidades.Cliente;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author skevi
 * @author sebastian
 */
public class ClienteCVR {

    // Convertir de ClienteDTO a ClienteBO
    public static ClienteBO convertirDTOABO(ClienteDTO clienteDTO) {
        if (clienteDTO == null) {
            return null;
        }
        ClienteBO clienteBO = new ClienteBO();
        clienteBO.setNombreCompleto(clienteDTO.getNombreCompleto());
        clienteBO.setTelefono(clienteDTO.getTelefono());
        return clienteBO;
    }

    // Convertir de ClienteBO a Cliente (Entidad)
    public static Cliente convertirBOAEntidad(ClienteBO clienteBO) {
        if (clienteBO == null) {
            return null;
        }
        Cliente cliente = new Cliente();
        cliente.setNombreCompleto(clienteBO.getNombreCompleto());
        cliente.setTelefono(clienteBO.getTelefono());
        // Las reservas no se convierten en este paso
        return cliente;
    }

    // Convertir de Cliente a ClienteDTO
    public static ClienteDTO convertirEntidadADTO(Cliente cliente) {
        if (cliente == null) {
            return null;
        }
        ClienteDTO clienteDTO = new ClienteDTO();
        clienteDTO.setId(cliente.getId());
        clienteDTO.setNombreCompleto(cliente.getNombreCompleto());
        clienteDTO.setTelefono(cliente.getTelefono());
        return clienteDTO;
    }

    // Convertir de ClienteDTO a Cliente (Entidad)
    public static Cliente convertirDTOAEntidad(ClienteDTO clienteDTO) {
        if (clienteDTO == null) {
            return null;
        }
        Cliente cliente = new Cliente();
        cliente.setId(clienteDTO.getId());
        cliente.setNombreCompleto(clienteDTO.getNombreCompleto());
        cliente.setTelefono(clienteDTO.getTelefono());
        return cliente;
    }

    // Convertir una lista de ClienteDTO a ClienteBO
    public static List<ClienteBO> convertirListaDTOABO(List<ClienteDTO> clienteDTOs) {
        if (clienteDTOs == null || clienteDTOs.isEmpty()) {
            return new ArrayList<>();
        }
        List<ClienteBO> clienteBOs = new ArrayList<>();
        for (ClienteDTO clienteDTO : clienteDTOs) {
            clienteBOs.add(convertirDTOABO(clienteDTO));
        }
        return clienteBOs;
    }

    // Convertir una lista de Cliente a ClienteDTO
    public static List<ClienteDTO> convertirListaEntidadADTO(List<Cliente> clientes) {
        if (clientes == null || clientes.isEmpty()) {
            return new ArrayList<>();
        }
        List<ClienteDTO> clienteDTOs = new ArrayList<>();
        for (Cliente cliente : clientes) {
            clienteDTOs.add(convertirEntidadADTO(cliente));
        }
        return clienteDTOs;
    }
}
