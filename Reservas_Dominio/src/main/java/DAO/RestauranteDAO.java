/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import Conexion.Conexion;
import Entidades.Restaurante;
import Interfaces.IRestauranteDAO;

/**
 *
 * @author skevi
 */
public class RestauranteDAO implements IRestauranteDAO{

    // instancia para establecer conexion
    Conexion conexion;

    /**
     * Constructor por defecto
     */
    public RestauranteDAO() {
        this.conexion = new Conexion();
    }
    
    /**
     * 
     * @param restaurante 
     */
    @Override
    public void agregarRestaurante(Restaurante restaurante) {
        
    }
    
}
