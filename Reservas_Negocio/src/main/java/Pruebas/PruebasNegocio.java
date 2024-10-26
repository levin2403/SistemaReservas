/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package Pruebas;

import BO.ClienteBO;
import BO.MesaBO;
import DAO.ClienteDAO;
import DAO.MesaDAO;
import DAO.ReservaDAO;
import DTOs.MesaDTO;
import Entidades.Cliente;
import Excepciones.BOException;
import Excepciones.DAOException;
import Interfaces.IClienteBO;
import Interfaces.IClienteDAO;
import Interfaces.IMesaBO;
import Interfaces.IMesaDAO;
import Interfaces.IReservaDAO;
import java.time.LocalDateTime;
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
        
//          IMesaBO mesaBO = new MesaBO();
//          
//          List<MesaDTO> mesas = mesaBO.consultarMesas();
//          
//          for (MesaDTO mesa : mesas) {
//              System.out.println(mesa.toString());
//        }

          IClienteDAO clienteDAO = new ClienteDAO();
          
          IReservaDAO reservaDAO = new ReservaDAO();
          
          IMesaDAO mesaDAO = new MesaDAO();
          
          LocalDateTime fechaHoraEspecifica = LocalDateTime.of(2024, 10, 26, 10, 30);
          
          
          try{              
              Cliente cliente = clienteDAO.obtenerCliente(4L);
              
              boolean resultado = reservaDAO.
                      verificarReservaciones(cliente);
              
              if (resultado) {
                  System.out.println("Ya tiene reservaciones activas");
              }
              else if (!resultado){
                  System.out.println("No tiene reservaciones activas");
              }
          }
          catch(DAOException ex){
              
          }

    }
    
}
