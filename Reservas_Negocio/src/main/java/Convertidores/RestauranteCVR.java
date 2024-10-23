/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Convertidores;


import DTO.MesaDTO;
import DTOs.RestauranteDTO;
import Entidades.Mesa;
import Entidades.Restaurante;
import java.util.ArrayList;
import java.util.List;

public class RestauranteCVR {
    
    private final MesaCVR mesaCVR; // convertidor de mesa

    /**
     * Constructor por defecto.
     */
    public RestauranteCVR() {
        this.mesaCVR = new MesaCVR();
    }
    
    /**
     * Convierte todos los atributos de RestauranteDTO a Restaurante, los elementos que 
     * pueden ser nulos como la lista de mesas se pasan directamente como 
     * nulos en caso de serlo.
     * 
     * @param restauranteDTO RestauranteDTO a convertir.
     * @return Restaurante de tipo entidad.
     */
    public Restaurante toEntity(RestauranteDTO restauranteDTO) {
        if (restauranteDTO == null) {
            return null;
        }

        Restaurante restaurante = new Restaurante();
        restaurante.setId(Long.valueOf(restauranteDTO.getId()));
        restaurante.setNombre(restauranteDTO.getNombre());
        restaurante.setDireccion(restauranteDTO.getDireccion());
        restaurante.setTelefono(restauranteDTO.getTelefono());
        restaurante.setHoraApertura(restauranteDTO.getHoraApertura());
        restaurante.setHoraCierre(restauranteDTO.getHoraCierre());

        // Convertir la lista de mesas
        if (restauranteDTO.getMesas() != null) {
            List<Mesa> mesas = new ArrayList<>();
            for (MesaDTO mesaDTO : restauranteDTO.getMesas()) {
                mesas.add(mesaCVR.toEntity(mesaDTO));
            }
            restaurante.setMesas(mesas);
        }
        
        return restaurante;
    }

    /**
     * Convierte todos los atributos de Restaurante a RestauranteDTO, los elementos que 
     * pueden ser nulos como la lista de mesas se pasan directamente como 
     * nulos en caso de serlo.
     * 
     * @param restaurante Restaurante a convertir.
     * @return RestauranteDTO convertida en DTO.
     */
    public RestauranteDTO toDTO(Restaurante restaurante) {
        if (restaurante == null) {
            return null;
        }

        RestauranteDTO restauranteDTO = new RestauranteDTO();
        restauranteDTO.setId(String.valueOf(restaurante.getId()));
        restauranteDTO.setNombre(restaurante.getNombre());
        restauranteDTO.setDireccion(restaurante.getDireccion());
        restauranteDTO.setTelefono(restaurante.getTelefono());
        restauranteDTO.setHoraApertura(restaurante.getHoraApertura());
        restauranteDTO.setHoraCierre(restaurante.getHoraCierre());

        // Convertir la lista de mesas
        if (restaurante.getMesas() != null) {
            List<MesaDTO> mesasDTO = new ArrayList<>();
            for (Mesa mesa : restaurante.getMesas()) {
                mesasDTO.add(mesaCVR.toDTO(mesa));
            }
            restauranteDTO.setMesas(mesasDTO);
        }
        
        return restauranteDTO;
    }
    
}

