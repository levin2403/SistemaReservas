/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Interfaces;

import Entidades.Restaurante;

/**
 *
 * @author skevi
 */
public interface IRestauranteDAO {
    
    public void agregarRestaurante(Restaurante restaurante);
    
    public Restaurante consultar();
    
}
