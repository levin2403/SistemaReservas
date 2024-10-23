/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Convertidores;

import DTO.MesaDTO;
import Entidades.Mesa;

/**
 *
 * @author skevi
 */
public class MesaCVR {
    
    private RestauranteCVR restauranteCVR; //convertidor de restaurante.
    private ReservaCVR reservaCVR; //convertidor de reserva.

    public MesaCVR() {
        this.restauranteCVR = new RestauranteCVR();
        this.reservaCVR = new ReservaCVR();
    }
    
    /**
     * Convierte todos los atributos de MesaDTO a MesaDTO, los elementos que 
     * pueden ser nulos como la lista de reservas se pasan directamente como 
     * nulos en caso de serlo
     * 
     * @param mesa MesaDTO a convertir.
     * @return Mesa de tipo entidad.
     */
    public Mesa toEntity(MesaDTO mesa){
        return null;
    }

    /**
     * Convierte todos los atributos de MesaDTO a Mesa, los elementos que 
     * pueden ser nulos como la lista de reservas se pasan directamente como 
     * nulos en caso de serlo
     * 
     * @param mesa Mesa a convertir.
     * @return Mesa convertida en DTO.
     */
    public MesaDTO toDTO(Mesa mesa){
        return null;
    }
    
}
