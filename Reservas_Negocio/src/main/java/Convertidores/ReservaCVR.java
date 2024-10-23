/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Convertidores;

import DTO.ReservaDTO;
import Entidades.Reserva;


/**
 *
 * @author skevi
 */
public class ReservaCVR {

    private final ClienteCVR clienteCVR; //convertidor de cliente
    private final MesaCVR mesaCVR; // convertidor de mesa
    private final RestauranteCVR restauranteCVR; //convertidor de restaurante

    public ReservaCVR() {
        this.clienteCVR = new ClienteCVR();
        this.mesaCVR = new MesaCVR();
        this.restauranteCVR = new RestauranteCVR();
    }
    
    /**
     * Convierte todos los atributos de ReservaDTO a Reserva, los elementos que 
     * puedan ser nulos se pasan directamente como nulos
     * nulos en caso de serlo
     * 
     * @param reservaDTO ReservaDTO a convertir.
     * @return Mesa de tipo entidad.
     */
    public Reserva toEntity(ReservaDTO reservaDTO){
        return null;
    }

    /**
     * Convierte todos los atributos de Reserva a ReservaDTO, los elementos que 
     * puedan ser nulos se pasan directamente como nulos
     * 
     * @param reserva Reservacion a convertir.
     * @return Reservacion convertida en DTO.
     */
    public ReservaDTO toDTO(Reserva reserva){
        return null;
    }
    
}
