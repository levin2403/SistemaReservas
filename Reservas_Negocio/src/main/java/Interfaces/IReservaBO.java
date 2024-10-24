/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Interfaces;

import DTO.ReservaDTO;
import Entidades.Reserva;
import Excepciones.BOException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

/**
 * Interfaz que define las operaciones básicas para la gestión de reservas en 
 * la capa de negocio (BO). Esta interfaz proporciona un contrato para las 
 * implementaciones que manejarán la persistencia y recuperación de 
 * información sobre reservas.
 * 
 * @author skevi
 */
public interface IReservaBO {
    
    /**
     * Agrega una nueva reserva a la base de datos.
     * 
     * @param reserva El objeto {@link Reserva} que se desea agregar.
     * @throws Excepciones.BOException En caso de error uno nunca sabe.
     */
    public void agregarReserva(ReservaDTO reserva) throws BOException;
    
    /**
     * Consulta y recupera una lista de reservas en un rango de fechas 
     * específico.
     * 
     * @param inicio La fecha de inicio del rango de búsqueda.
     * @param fin La fecha de fin del rango de búsqueda.
     * @return Una lista de objetos {@link Reserva} que representan las 
     * reservas dentro del rango de fechas especificado.
     * @throws Excepciones.BOException En caso de error uno nunca sabe.
     */
    public List<ReservaDTO> consultarPorFecha(LocalDateTime inicio, 
            LocalDateTime fin) throws BOException;
    
    /**
     * Consulta y recupera una lista de reservas para un día específico.
     * 
     * @param dia La fecha del día para el cual se desean consultar las 
     *            reservas.
     * @return Una lista de objetos {@link Reserva} que representan las 
     *         reservas del día especificado.
     * @throws Excepciones.BOException En caso de error uno nunca sabe.
     */
    public List<ReservaDTO> consultarPorDia(LocalDateTime dia) 
            throws BOException;
    
    /**
     * Metodo que mediante filtros obtiene las reservas que mas se adapten
     * algunos datos del parametro pueden ser nulos pero aun asi se adapta
     * a lo requerido.
     * 
     * @param nombreCliente Nombre del cliente.
     * @param telefonoCliente Telefono del cliente.
     * @param fechaReserva Fecha en que fue realizada la reserva.
     * @param areaRestaurante Area del restaurante.
     * @param fechaInicio Fecha de inicio para la busqueda.
     * @param fechaFin Fecha de fin para la busqueda.
     * @param tamanoMesa Tamaño de la mesa.
     * 
     * @return Retorna lista de reservaciones que mas se adapten a 
     *         los parametros.
     * @throws Excepciones.BOException En caso de error uno nunca sabe.
     */
    public List<ReservaDTO> buscarReservasPorFiltros(String nombreCliente, 
        String telefonoCliente, LocalDate fechaReserva,
        String areaRestaurante, LocalDate fechaInicio, 
        LocalDate fechaFin, Integer tamanoMesa) throws BOException;
    
}
