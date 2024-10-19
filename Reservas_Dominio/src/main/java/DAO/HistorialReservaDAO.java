/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import Conexion.Conexion;
import Entidades.HistorialReserva;
import Interfaces.IHistorialReservasDAO;

/**
 *
 * @author skevi
 */
public class HistorialReservaDAO implements IHistorialReservasDAO{
    
    // instancia para establecer conexion
    Conexion conexion;

    /**
     * Constructor por defecto
     */
    public HistorialReservaDAO() {
        this.conexion = new Conexion();
    }

    /**
     * 
     * @param historialReserva 
     */
    @Override
    public void agregar(HistorialReserva historialReserva) {
        
    }
    
}
