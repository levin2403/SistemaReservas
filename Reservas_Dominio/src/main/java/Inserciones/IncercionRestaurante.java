/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package Inserciones;

import DAO.MesaDAO;
import DAO.RestauranteDAO;
import Entidades.Mesa;
import Entidades.Restaurante;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author skevi
 */
public class IncercionRestaurante {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        // Crear una instancia del DAO de Restaurante
        RestauranteDAO restauranteDAO = new RestauranteDAO();
        
        //Instancia de MesaDAO
        MesaDAO mesaDAO = new MesaDAO();
//
//        // Crear una nueva instancia de Restaurante
//        Restaurante restaurante = new Restaurante();
//        restaurante.setNombre("Restaurante Delicias");
//        restaurante.setDireccion("Calle Principal #123, Ciudad");
//        restaurante.setTelefono("1234567890");
//        restaurante.setHoraApertura(LocalTime.of(10, 0));  // Hora de apertura: 10:00
//        restaurante.setHoraCierre(LocalTime.of(22, 0));    // Hora de cierre: 22:00
//
//        // Llamar al método para agregar el restaurante a la base de datos
//        restauranteDAO.agregarRestaurante(restaurante);


//        System.out.println(restauranteDAO.consultar().toString());
        
//          Restaurante restaurante = restauranteDAO.consultar();
//          
//          Mesa mesa1 = new Mesa("TC-002", "PEQUEÑA", 1, 2, "TERRAZA", restaurante);
//          Mesa mesa2 = new Mesa("TC-003", "MEDIANA", 3, 4, "VENTANA", restaurante);
//          Mesa mesa3 = new Mesa("TC-004", "GRANDE", 5, 8, "GENERAL", restaurante);
          
//          List<Mesa> mesas = new ArrayList<>();
          
//          mesas.add(mesa1);
//          mesas.add(mesa2);
//          mesas.add(mesa3);
//          
//          mesaDAO.agregarMesas(mesas);

//          List<Mesa> mesas = mesaDAO.consultarMesas();
//          
//          for (Mesa mesa : mesas) {
//              System.out.println(mesa.toString());
//          }
          
           List<Mesa> cantidad = mesaDAO.obtenerMesasPorTipo("PEQUEÑA");
           
           for (Mesa mesa : cantidad) {
               System.out.println(mesa.toString());
           }
    }
  
}
