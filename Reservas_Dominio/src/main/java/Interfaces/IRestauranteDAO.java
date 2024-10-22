/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Interfaces;

import Entidades.Restaurante;

/**
 * Interfaz que define las operaciones básicas para la gestión de restaurantes en la capa de acceso a datos (DAO).
 * Esta interfaz proporciona un contrato para las implementaciones que manejarán la persistencia
 * y recuperación de información sobre restaurantes.
 * 
 * @author skevi
 */
public interface IRestauranteDAO {
    
    /**
     * Agrega un nuevo restaurante a la base de datos.
     * 
     * @param restaurante El objeto {@link Restaurante} que se desea agregar.
     */
    public void agregarRestaurante(Restaurante restaurante);
    
    /**
     * Consulta y recupera la información del restaurante.
     * 
     * @return El objeto {@link Restaurante} que representa el restaurante consultado.
     */
    public Restaurante consultar();
}

