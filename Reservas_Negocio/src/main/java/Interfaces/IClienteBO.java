/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Interfaces;

import DTO.ClienteDTO;
import java.util.List;

/**
 * Interfaz que define las operaciones básicas para la gestión de clientes en la capa de negocio (BO).
 * Esta interfaz proporciona un contrato para las implementaciones que manejarán la persistencia
 * y recuperación de información de clientes.
 * 
 * @author skevi
 */
public interface IClienteBO {
       
    /**
     * Obtiene los detalles de un cliente específico a partir de su objeto.
     * 
     * @param id id del cliente.
     * @return Cliente.
     */
    public ClienteDTO obtenerCliente(Long id);
    
    /**
     * Recupera una lista de todos los clientes almacenados en la base de datos.
     * 
     * @return Una lista de objetos {@link Cliente} que representa todos los 
     * clientes.
     */
    public List<ClienteDTO> obtenerClientes();
    
}
 