/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Convertidores;


import DTOs.RestauranteDTO;
import Entidades.Restaurante;

/**
 *
 * @author skevi
 * @author sebastian
 */
public class RestauranteCVR {
    
    private final MesaCVR mesaCVR; // convertidor de mesa

    /**
     * 
     */
    public RestauranteCVR() {
        this.mesaCVR = new MesaCVR();
    }
    
    /**
     * Convierte todos los atributos de RestauranteDTO a Restaurante, los elementos que 
     * pueden ser nulos como la lista de mesas se pasan directamente como 
     * nulos en caso de serlo
     * 
     * @param restauranteDTO MesaDTO a convertir.
     * @return Restaurante de tipo entidad.
     */
    public Restaurante toEntity(RestauranteDTO restauranteDTO){
        return null;
    }

    /**
     * Convierte todos los atributos de Restaurante a RestauranteDTO, los elementos que 
     * pueden ser nulos como la lista de mesas se pasan directamente como 
     * nulos en caso de serlo
     * 
     * @param restaurante Mesa a convertir.
     * @return RestauranteDTO convertida en DTO.
     */
    public RestauranteDTO toDTO(Restaurante restaurante){
        return null;
    }

}
