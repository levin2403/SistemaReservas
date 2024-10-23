/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package Inserciones;

import DAO.ClienteDAO;
import DAO.MesaDAO;
import DAO.ReservaDAO;
import DAO.RestauranteDAO;
import Entidades.Cliente;
import Entidades.Mesa;
import Entidades.Reserva;
import Entidades.Restaurante;
import java.time.LocalDate;
import java.time.LocalDateTime;
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
        
//        // Crear una instancia del DAO de Restaurante
//        RestauranteDAO restauranteDAO = new RestauranteDAO();
//        
//        //Instancia de MesaDAO
//        MesaDAO mesaDAO = new MesaDAO();
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
          
//           List<Mesa> cantidad = mesaDAO.obtenerMesasPorTipo("PEQUEÑA");
//           
//           for (Mesa mesa : cantidad) {
//               System.out.println(mesa.toString());
//           }

//        // Crear instancias del DAO
//        ClienteDAO clienteDAO = new ClienteDAO();
        ReservaDAO reservaDAO = new ReservaDAO();
//
//        // Obtener un cliente y una mesa ya existentes en la base de datos
//        Cliente cliente = clienteDAO.obtenerCliente(1L); // Supongamos que el cliente con ID 1 existe
//        Mesa mesa = mesaDAO.obtenerMesasPorTipo("PEQUEÑA").get(0);
//
//        // Crear una nueva reserva
//        Reserva nuevaReserva = new Reserva();
//        nuevaReserva.setFechaHoraReserva(LocalDateTime.now());
//        nuevaReserva.setNumeroPersonas(4);
//        nuevaReserva.setCosto(300.00);
//        nuevaReserva.setEstado("ACTIVA");
//        nuevaReserva.setMulta(0);
//        nuevaReserva.setCliente(cliente);
//        nuevaReserva.setMesa(mesa);
//        nuevaReserva.setRestaurante(restaurante);

        // Agregar la reserva a la base de datos
        // Definir las fechas de inicio y fin
//        LocalDateTime fechaInicio = LocalDateTime.of(2024, 10, 1, 0, 0);  // 1 de octubre de 2024, 00:00:00
//        LocalDateTime fechaFin = LocalDateTime.of(2024, 10, 31, 23, 59);  // 31 de octubre de 2024, 23:59:00
//        
//        // Llamar al método consultarPorFecha
//        List<Reserva> reservas = reservaDAO.consultarPorFecha(fechaInicio, fechaFin);
//        
//        // Mostrar los resultados
//        if (reservas != null && !reservas.isEmpty()) {
//            for (Reserva reserva : reservas) {
//                System.out.println(reserva.toString());
//            }
//        } else {
//            System.out.println("No se encontraron reservas en el rango de fechas.");
//        }
          
          List<Reserva> reservas = reservaDAO.consultarPorDia(LocalDateTime.now().minusDays(1));
          
          for (Reserva reserva : reservas) {
              System.out.println(reserva.toString());
        }
    }
  
}
