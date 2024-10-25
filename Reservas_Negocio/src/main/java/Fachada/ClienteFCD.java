/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Fachada;

import BO.ClienteBO;
import DTOs.ClienteDTO;
import Excepciones.BOException;
import Excepciones.FacadeException;
import Interfaces.IClienteBO;
import interfacesFachada.IClienteFCD;
import java.util.List;
import javax.swing.JComboBox;

/**
 *
 * @author skevi
 */
public class ClienteFCD implements IClienteFCD{

    IClienteBO clienteBO;

    public ClienteFCD() {
        this.clienteBO = new ClienteBO();
    }
   
    /**
     * 
     * @param combo 
     */
    @Override
    public void cargarComboBoxClientes(JComboBox combo) throws FacadeException{
        try{
        List<ClienteDTO> clientes = clienteBO.obtenerClientes();
        
            for (ClienteDTO cliente : clientes) {
                combo.addItem(cliente);
            }
        }
        catch(BOException be){
            throw new FacadeException(be.getMessage());
        }
        
    }
    
}
