/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Interfaces;

import Entidades.Reserva;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

/**
 * Interfaz que define las operaciones básicas para la gestión de reservas en la capa de acceso a datos (DAO).
 * Esta interfaz proporciona un contrato para las implementaciones que manejarán la persistencia
 * y recuperación de información sobre reservas.
 * 
 * @author skevi
 */
public interface IReservaDAO {
    
    /**
     * Agrega una nueva reserva a la base de datos.
     * 
     * @param reserva El objeto {@link Reserva} que se desea agregar.
     */
    public void agregarReserva(Reserva reserva);
    
    /**
     * Consulta y recupera una lista de reservas en un rango de fechas específico.
     * 
     * @param inicio La fecha de inicio del rango de búsqueda.
     * @param fin La fecha de fin del rango de búsqueda.
     * @return Una lista de objetos {@link Reserva} que representan las reservas dentro del rango de fechas especificado.
     */
    public List<Reserva> consultarPorFecha(LocalDateTime inicio, LocalDateTime fin);
    
    /**
     * Consulta y recupera una lista de reservas para un día específico.
     * 
     * @param dia La fecha del día para el cual se desean consultar las reservas.
     * @return Una lista de objetos {@link Reserva} que representan las reservas del día especificado.
     */
    public List<Reserva> consultarPorDia(LocalDateTime dia);
}


