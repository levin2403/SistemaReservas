/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Interfaces;

import Entidades.Cliente;
import java.util.List;

/**
 *
 * @author skevi
 */
public interface IClienteDAO {
    
    public void agregarCliente(Cliente cliente);
    
    public void obtenerCliente(Cliente cliente);
    
    public List<Cliente> obtenerClientes();
    
}
