/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package Pruebas;

import BO.ClienteBO;
import BO.MesaBO;
import BO.ReservaBO;
import DAO.ClienteDAO;
import DAO.MesaDAO;
import DAO.ReservaDAO;
import DTOs.ClienteDTO;
import DTOs.MesaDTO;
import DTOs.ReservaDTO;
import Entidades.Cliente;
import Excepciones.BOException;
import Excepciones.DAOException;
import Interfaces.IClienteBO;
import Interfaces.IClienteDAO;
import Interfaces.IMesaBO;
import Interfaces.IMesaDAO;
import Interfaces.IReservaBO;
import Interfaces.IReservaDAO;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Month;
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

          IClienteBO clienteBO = new ClienteBO();
          
          IReservaBO reservaBO = new ReservaBO();
          
          IMesaBO mesaBO = new MesaBO();
          
          
          
          try{
              int terraza = mesaBO.cantidadMesasPorUbicacion("GENERAL");
              System.out.println(terraza);
          }
          catch(BOException ex){
              System.out.println("la cague");
          }
    }
    
}
