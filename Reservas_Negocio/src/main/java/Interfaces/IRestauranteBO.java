/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Interfaces;

import DTOs.RestauranteDTO;
import Excepciones.BOException;

/**
 * Interfaz que define las operaciones básicas para la gestión de restaurantes 
 * en la capa de negocio (BO). Esta interfaz proporciona un contrato para las 
 * implementaciones que manejarán la persistencia y recuperación de información 
 * sobre restaurantes.
 * 
 * @author skevi
 */
public interface IRestauranteBO {
    
    
    /**
     * Consulta y recupera la información del restaurante.
     * 
     * @return El objeto {@link Restaurante} que representa el restaurante 
     *         consultado.
     * @throws Excepciones.BOException En caso de error uno nunca sabe.
     */
    public RestauranteDTO consultar() throws BOException;
    
}
