/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Convertidores;

import DTO.ClienteDTO;
import DTO.ReservaDTO;
import Entidades.Cliente;
import Entidades.Reserva;
import java.util.List;
import java.util.stream.Collectors;



/**
 *
 * @author skevi
 * @author sebastian
 */
public class ClienteCVR {
    
    private ReservaCVR reservaCVR; // Convertidor de reserva

    /**
     * Constructor por defecto.
     */
    public ClienteCVR() {
        this.reservaCVR = new ReservaCVR();
    }
            
    /**
     * Convierte todos los atributos de ClienteDTO a Cliente, 
     * los elementos que pueden ser nulos como la lista de reservas se pasan 
     * directamente como nulos en caso de serlo.
     * 
     * @param clienteDTO ClienteDTO a convertir.
     * @return Cliente de tipo entidad.
     */
    public Cliente toEntity(ClienteDTO clienteDTO){
        if (clienteDTO == null) {
            return null; // Retorna null si el DTO es nulo
        }

        Cliente cliente = new Cliente();
        cliente.setId(clienteDTO.getId()); // Asigna el ID
        cliente.setNombre(clienteDTO.getNombre()); // Asigna el nombre
        cliente.setTelefono(clienteDTO.getTelefono()); // Asigna el teléfono
        
        // Convierte la lista de reservas usando el convertidor
        if (clienteDTO.getReservas() != null) {
            List<Reserva> reservas = clienteDTO.getReservas()
                                                 .stream()
                                                 .map(reservaCVR::toEntity)
                                                 .collect(Collectors.toList());
            cliente.setReservas(reservas);
        } else {
            cliente.setReservas(null); // Asigna null si no hay reservas
        }

        return cliente;
    }

    /**
     * Convierte todos los atributos de Cliente a ClienteDTO, 
     * los elementos que pueden ser nulos como la lista de reservas se pasan 
     * directamente como nulos en caso de serlo.
     * 
     * @param cliente Cliente a convertir.
     * @return ClienteDTO convertido.
     */
    public ClienteDTO toDTO(Cliente cliente){
        if (cliente == null) {
            return null; // Retorna null si la entidad es nula
        }

        ClienteDTO clienteDTO = new ClienteDTO();
        clienteDTO.setId(cliente.getId()); // Asigna el ID
        clienteDTO.setNombre(cliente.getNombre()); // Asigna el nombre
        clienteDTO.setTelefono(cliente.getTelefono()); // Asigna el teléfono

        // Convierte la lista de reservas usando el convertidor
        if (cliente.getReservas() != null) {
            List<ReservaDTO> reservasDTO = cliente.getReservas()
                                                   .stream()
                                                   .map(reservaCVR::toDTO)
                                                   .collect(Collectors.toList());
            clienteDTO.setReservas(reservasDTO);
        } else {
            clienteDTO.setReservas(null); // Asigna null si no hay reservas
        }

        return clienteDTO;
    }
}
