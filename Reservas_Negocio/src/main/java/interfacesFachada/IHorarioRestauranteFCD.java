/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package interfacesFachada;

import DTOs.RestauranteDTO;
import java.time.LocalTime;

/**
 * Interfaz para establecer las horas de apertura y cierre de un restaurante.
 * Autor: Sebastian Murrieta
 */
public interface IHorarioRestauranteFCD {
    void establecerHoraApertura(RestauranteDTO restaurante, String horaAperturaString);
    void establecerHoraCierre(RestauranteDTO restaurante, LocalTime horaCierre);
}
