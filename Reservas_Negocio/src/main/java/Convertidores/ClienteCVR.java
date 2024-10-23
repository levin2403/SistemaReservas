/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Convertidores;

import DTO.ClienteDTO;
import Entidades.Cliente;



/**
 *
 * @author skevi
 * @author sebastian
 */
public class ClienteCVR {

    /**
     * Convierte todos los atributos de ClienteDTO a Cliente, los elementos que 
     * pueden ser nulos como la lista de reservas se pasan directamente como 
     * nulos en caso de serlo
     * 
     * @param clienteDTO MesaDTO a convertir.
     * @return Mesa de tipo entidad.
     */
    public Cliente toEntity(ClienteDTO clienteDTO){
        return null;
    }

    /**
     * Convierte todos los atributos de Cliente a ClienteDTO, los elementos que 
     * pueden ser nulos como la lista de reservas se pasan directamente como 
     * nulos en caso de serlo
     * 
     * @param cliente Mesa a convertir.
     * @return Mesa convertida en DTO.
     */
    public ClienteDTO toDTO(Cliente cliente){
        return null;
    }
    
}
