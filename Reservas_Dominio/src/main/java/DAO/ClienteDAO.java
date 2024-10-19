/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import Conexion.Conexion;
import Entidades.Cliente;
import Interfaces.IClienteDAO;

/**
 *
 * @author skevi
 */
public class ClienteDAO implements IClienteDAO{
    
    Conexion conexion;

    public ClienteDAO() {
        this.conexion = new Conexion();
    }

    /**
     * 
     * @param cliente 
     */
    @Override
    public void agregarCliente(Cliente cliente) {
        
    }
    
}
