/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import Conexion.Conexion;
import Entidades.Reserva;
import Interfaces.IReservaDAO;

/**
 *
 * @author skevi
 */
public class ReservaDAO implements IReservaDAO{
    
    // instancia para establecer conexion
    Conexion conexion;

    /**
     * Constructor por defecto
     */
    public ReservaDAO() {
        this.conexion = new Conexion();
    }

    /**
     * 
     * @param reserva 
     */
    @Override
    public void agregarReserva(Reserva reserva) {
        
    }
    
}
