/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Convertidores;

import DTO.ReservaDTO;
import Entidades.Reserva;


public class ReservaCVR {

    private final ClienteCVR clienteCVR; // convertidor de cliente
    private final MesaCVR mesaCVR; // convertidor de mesa
    private final RestauranteCVR restauranteCVR; // convertidor de restaurante

    public ReservaCVR() {
        this.clienteCVR = new ClienteCVR();
        this.mesaCVR = new MesaCVR();
        this.restauranteCVR = new RestauranteCVR();
    }
    
    /**
     * Convierte todos los atributos de ReservaDTO a Reserva, 
     * los elementos que pueden ser nulos se pasan directamente como nulos en caso de serlo
     * 
     * @param reservaDTO ReservaDTO a convertir.
     * @return Reserva de tipo entidad.
     */
    public Reserva toEntity(ReservaDTO reservaDTO) {
        if (reservaDTO == null) {
            return null; // Devuelve null si el DTO es nulo
        }

        Reserva reserva = new Reserva();
        reserva.setId(Long.valueOf(reservaDTO.getId()));
        reserva.setFechaHoraReserva(reservaDTO.getFechaHoraReserva());
        reserva.setNumeroPersonas(reservaDTO.getNumeroPersonas());
        reserva.setCosto(reservaDTO.getCosto());
        reserva.setEstado(reservaDTO.getEstado());
        reserva.setMulta(reservaDTO.getMulta());
        
        // Conversión de cliente
        if (reservaDTO.getCliente() != null) {
            reserva.setCliente(clienteCVR.toEntity(reservaDTO.getCliente()));
        }

        // Conversión de mesa
        if (reservaDTO.getMesa() != null) {
            reserva.setMesa(mesaCVR.toEntity(reservaDTO.getMesa()));
        }

        // Conversión de restaurante
        if (reservaDTO.getRestaurante() != null) {
            reserva.setRestaurante(restauranteCVR.toEntity(reservaDTO.getRestaurante()));
        }

        return reserva;
    }

    /**
     * Convierte todos los atributos de Reserva a ReservaDTO, 
     * los elementos que pueden ser nulos se pasan directamente como nulos
     * 
     * @param reserva Reserva a convertir.
     * @return Reserva convertida en DTO.
     */
    public ReservaDTO toDTO(Reserva reserva) {
        if (reserva == null) {
            return null; // Devuelve null si la reserva es nula
        }

        ReservaDTO reservaDTO = new ReservaDTO();
        reservaDTO.setId(String.valueOf(reserva.getId()));
        reservaDTO.setFechaHoraReserva(reserva.getFechaHoraReserva());
        reservaDTO.setNumeroPersonas(reserva.getNumeroPersonas());
        reservaDTO.setCosto(reserva.getCosto());
        reservaDTO.setEstado(reserva.getEstado());
        reservaDTO.setMulta(reserva.getMulta());

        // Conversión de cliente
        if (reserva.getCliente() != null) {
            reservaDTO.setCliente(clienteCVR.toDTO(reserva.getCliente()));
        }

        // Conversión de mesa
        if (reserva.getMesa() != null) {
            reservaDTO.setMesa(mesaCVR.toDTO(reserva.getMesa()));
        }

        // Conversión de restaurante
        if (reserva.getRestaurante() != null) {
            reservaDTO.setRestaurante(restauranteCVR.toDTO(reserva.getRestaurante()));
        }

        return reservaDTO;
    }
    
}
