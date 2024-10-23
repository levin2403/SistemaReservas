/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Convertidores;

import DTO.MesaDTO;
import DTO.ReservaDTO;
import Entidades.Mesa;
import Entidades.Reserva;
import java.util.List;
import java.util.stream.Collectors;

public class MesaCVR {
    
    private RestauranteCVR restauranteCVR; // Convertidor de restaurante.
    private ReservaCVR reservaCVR; // Convertidor de reserva.

    public MesaCVR() {
        this.restauranteCVR = new RestauranteCVR();
        this.reservaCVR = new ReservaCVR();
    }
    
    /**
     * Convierte todos los atributos de MesaDTO a Mesa, 
     * los elementos que pueden ser nulos como la lista de reservas se pasan 
     * directamente como nulos en caso de serlo.
     * 
     * @param mesaDTO MesaDTO a convertir.
     * @return Mesa de tipo entidad.
     */
    public Mesa toEntity(MesaDTO mesaDTO) {
        if (mesaDTO == null) {
            return null; // Retorna null si el DTO es nulo
        }

        Mesa mesa = new Mesa();
        mesa.setId(Long.valueOf(mesaDTO.getId())); // Asigna el ID
        mesa.setCodigoMesa(mesaDTO.getCodigoMesa()); // Asigna el código de mesa
        mesa.setTipoMesa(mesaDTO.getTipoMesa()); // Asigna el tipo de mesa
        mesa.setCapacidadMinima(mesaDTO.getCapacidadMinima()); // Asigna capacidad mínima
        mesa.setCapacidadMaxima(mesaDTO.getCapacidadMaxima()); // Asigna capacidad máxima
        mesa.setUbicacion(mesaDTO.getUbicacion()); // Asigna la ubicación

        // Convierte el restaurante utilizando el convertidor
        if (mesaDTO.getRestaurante() != null) {
            mesa.setRestaurante(restauranteCVR.toEntity(mesaDTO.getRestaurante()));
        }

        // Convierte la lista de reservas usando el convertidor
        if (mesaDTO.getReservas() != null) {
            List<Reserva> reservas = mesaDTO.getReservas()
                                              .stream()
                                              .map(reservaCVR::toEntity)
                                              .collect(Collectors.toList());
            mesa.setReservas(reservas);
        }

        return mesa;
    }

    /**
     * Convierte todos los atributos de Mesa a MesaDTO, 
     * los elementos que pueden ser nulos como la lista de reservas se pasan 
     * directamente como nulos en caso de serlo.
     * 
     * @param mesa Mesa a convertir.
     * @return MesaDTO convertida en DTO.
     */
    public MesaDTO toDTO(Mesa mesa) {
        if (mesa == null) {
            return null; // Retorna null si la entidad es nula
        }

        MesaDTO mesaDTO = new MesaDTO();
        mesaDTO.setId(String.valueOf(mesa.getId())); // Asigna el ID
        mesaDTO.setCodigoMesa(mesa.getCodigoMesa()); // Asigna el código de mesa
        mesaDTO.setTipoMesa(mesa.getTipoMesa()); // Asigna el tipo de mesa
        mesaDTO.setCapacidadMinima(mesa.getCapacidadMinima()); // Asigna capacidad mínima
        mesaDTO.setCapacidadMaxima(mesa.getCapacidadMaxima()); // Asigna capacidad máxima
        mesaDTO.setUbicacion(mesa.getUbicacion()); // Asigna la ubicación

        // Convierte el restaurante utilizando el convertidor
        if (mesa.getRestaurante() != null) {
            mesaDTO.setRestaurante(restauranteCVR.toDTO(mesa.getRestaurante()));
        }

        // Convierte la lista de reservas usando el convertidor
        if (mesa.getReservas() != null) {
            List<ReservaDTO> reservasDTO = mesa.getReservas()
                                                 .stream()
                                                 .map(reservaCVR::toDTO)
                                                 .collect(Collectors.toList());
            mesaDTO.setReservas(reservasDTO);
        }

        return mesaDTO;
    }
    
}
