/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import Conexion.Conexion;
import Entidades.Mesa;
import Interfaces.IMesaDAO;

/**
 *
 * @author skevi
 */
public class MesaDAO implements IMesaDAO{
    
    // instancia para establecer conexion
    Conexion conexion;

    /**
     * Constructor por defecto
     */
    public MesaDAO() {
        this.conexion = new Conexion();
    }

    /**
     * 
     * @param mesa 
     */
    @Override
    public void agregarMesa(Mesa mesa) {
        
    }
    
    
}
