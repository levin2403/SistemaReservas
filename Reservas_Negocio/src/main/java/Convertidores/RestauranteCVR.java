/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Convertidores;

import BO.RestauranteBO;
import DTOs.RestauranteDTO;
import Entidades.Restaurante;

/**
 *
 * @author skevi
 * @author sebastian
 */
public class RestauranteCVR {

    /**
     * Convierte de RestauranteBO a Restaurante.
     *
     * @param restauranteBO Objeto de negocio que contiene los datos del
     * restaurante.
     * @return Objeto Restaurante con los datos del RestauranteBO.
     */
    public static Restaurante convertirBOAEntidad(RestauranteBO restauranteBO) {
        if (restauranteBO == null) {
            throw new IllegalArgumentException("El objeto RestauranteBO no puede ser nulo.");
        }

        Restaurante restaurante = new Restaurante();
        restaurante.setId(restauranteBO.getId());
        restaurante.setNombre(restauranteBO.getNombre());
        restaurante.setDireccion(restauranteBO.getDireccion());
        restaurante.setTelefono(restauranteBO.getTelefono());
        // No se incluyen email y datos de contacto encriptados
        return restaurante;
    }

    /**
     * Convierte de Restaurante a RestauranteBO.
     *
     * @param restaurante Objeto entidad que contiene los datos del restaurante.
     * @return Objeto RestauranteBO con los datos de la entidad Restaurante.
     */
    public static RestauranteBO convertirEntidadABO(Restaurante restaurante) {
        if (restaurante == null) {
            throw new IllegalArgumentException("El objeto Restaurante no puede ser nulo.");
        }

        RestauranteBO restauranteBO = new RestauranteBO();
        restauranteBO.setId(restaurante.getId());
        restauranteBO.setNombre(restaurante.getNombre());
        restauranteBO.setDireccion(restaurante.getDireccion());
        restauranteBO.setTelefono(restaurante.getTelefono());
        // No se incluyen email y datos de contacto encriptados
        return restauranteBO;
    }

    /**
     * Convierte de RestauranteDTO a Restaurante.
     *
     * @param restauranteDTO Objeto DTO que contiene los datos del restaurante.
     * @return Objeto Restaurante con los datos del RestauranteDTO.
     */
    public static Restaurante convertirDTOAEntidad(RestauranteDTO restauranteDTO) {
        if (restauranteDTO == null) {
            throw new IllegalArgumentException("El objeto RestauranteDTO no puede ser nulo.");
        }

        Restaurante restaurante = new Restaurante();
        restaurante.setId(restauranteDTO.getId());
        restaurante.setNombre(restauranteDTO.getNombre());
        restaurante.setDireccion(restauranteDTO.getDireccion());
        restaurante.setTelefono(restauranteDTO.getTelefono());
        restaurante.setHoraApertura(restauranteDTO.getHoraApertura());
        restaurante.setHoraCierre(restauranteDTO.getHoraCierre());

        return restaurante;
    }

    /**
     * Convierte de Restaurante a RestauranteDTO.
     *
     * @param restaurante Objeto entidad que contiene los datos del restaurante.
     * @return Objeto RestauranteDTO con los datos de la entidad Restaurante.
     */
    public static RestauranteDTO convertirEntidadADTO(Restaurante restaurante) {
        if (restaurante == null) {
            throw new IllegalArgumentException("El objeto Restaurante no puede ser nulo.");
        }

        RestauranteDTO restauranteDTO = new RestauranteDTO();
        restauranteDTO.setId(restaurante.getId());
        restauranteDTO.setNombre(restaurante.getNombre());
        restauranteDTO.setDireccion(restaurante.getDireccion());
        restauranteDTO.setTelefono(restaurante.getTelefono());
        restauranteDTO.setHoraApertura(restaurante.getHoraApertura());
        restauranteDTO.setHoraCierre(restaurante.getHoraCierre());

        return restauranteDTO;
    }
}
