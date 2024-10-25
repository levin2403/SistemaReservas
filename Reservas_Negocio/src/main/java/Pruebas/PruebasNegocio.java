/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package Pruebas;

import BO.ClienteBO;
import BO.MesaBO;
import DTOs.MesaDTO;
import Excepciones.BOException;
import Interfaces.IClienteBO;
import Interfaces.IMesaBO;
import java.util.List;

/**
 *
 * @author skevi
 */
public class PruebasNegocio {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws BOException {
        
//        IClienteBO clienteBO = new ClienteBO();
//        
//        List<ClienteDTO> clientes= clienteBO.obtenerClientes();
//        
//        for (ClienteDTO clientesDTO : clientes) {
//            System.out.println(clientesDTO.toString());
//        }
        
          IMesaBO mesaBO = new MesaBO();
          
          List<MesaDTO> mesas = mesaBO.consultarMesas();
          
          for (MesaDTO mesa : mesas) {
              System.out.println(mesa.toString());
        }

    }
    
}
