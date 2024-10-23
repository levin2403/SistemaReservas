/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Logica;

/**
 *
 * @author Sebastian Murrieta Verduzco - 233463
 */
import Entidades.Cliente;
import Entidades.Mesa;
import Entidades.Reserva;
import Entidades.Restaurante;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class GestorReservas {

    private List<Reserva> listaReservas;

    public GestorReservas() {
        this.listaReservas = new ArrayList<>();
    }

    /**
     * Método para agregar una nueva reserva.
     * 
     * @param fecha Fecha de la reserva.
     * @param hora Hora de la reserva.
     * @param numeroPersonas Número de personas.
     * @param cliente Objeto Cliente asociado a la reserva.
     * @param mesa Objeto Mesa asociada a la reserva.
     * @param restaurante Objeto Restaurante al que pertenece la reserva.
     * @param costo Costo de la reserva.
     * @param estado Estado de la reserva.
     * @param multa Multa por cancelación, si aplica.
     * @return La reserva creada.
     */
    public Reserva agregarReserva(LocalDateTime fecha, int numeroPersonas, 
            Cliente cliente, Mesa mesa, Restaurante restaurante, 
            double costo, String estado, double multa) {
        
        // Creación de la instancia de la reserva
        Reserva nuevaReserva = new Reserva(fecha, numeroPersonas, costo, estado, multa, cliente, mesa, restaurante);
        
        // Agregar la reserva a la lista
        listaReservas.add(nuevaReserva);
        
        return nuevaReserva;
    }

    /**
     * Método para obtener todas las reservas.
     * 
     * @return Lista de todas las reservas.
     */
    public List<Reserva> obtenerReservas() {
        return listaReservas;
    }

    /**
     * Método para buscar una reserva por ID.
     * 
     * @param id El ID de la reserva a buscar.
     * @return La reserva si se encuentra, null si no.
     */
    public Reserva buscarReservaPorId(Long id) {
        for (Reserva reserva : listaReservas) {
            if (reserva.getId().equals(id)) {
                return reserva;
            }
        }
        return null;
    }

    /**
     * Método para cancelar una reserva y aplicar una multa.
     * 
     * @param id El ID de la reserva a cancelar.
     * @param multa La multa a aplicar en caso de cancelación.
     * @return true si la cancelación fue exitosa, false si no se encuentra la reserva.
     */
    public boolean cancelarReserva(Long id, double multa) {
        Reserva reserva = buscarReservaPorId(id);
        if (reserva != null) {
            reserva.setEstado("Cancelada");
            reserva.setMulta(multa);
            return true;
        }
        return false;
    }

    /**
     * Método para eliminar una reserva por ID.
     * 
     * @param id El ID de la reserva a eliminar.
     * @return true si la reserva fue eliminada, false si no se encontró.
     */
    public boolean eliminarReserva(Long id) {
        Reserva reserva = buscarReservaPorId(id);
        if (reserva != null) {
            listaReservas.remove(reserva);
            return true;
        }
        return false;
    }
    
}
