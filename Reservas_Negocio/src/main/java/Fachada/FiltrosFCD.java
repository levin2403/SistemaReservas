package Fachada;

import DAO.ReservaDAO; // Asegúrate de importar tu DAO
import DTOs.ReservaDTO;
import Excepciones.DAOException;
import interfacesFachada.IFiltrosFCD;
import java.time.ZoneId;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Clase para filtrar reservas según criterios de cliente, teléfono y fecha.
 *
 * Author: Sebastian
 *
 * Implementación de los filtros de reservas según criterios de cliente,
 * teléfono y fecha.
 */
public class FiltrosFCD implements IFiltrosFCD {

    private List<ReservaDTO> reservas; // Lista de reservas
    private ReservaDAO reservaDAO; // DAO para obtener reservas

    // Constructor que recibe una lista de reservas
    public FiltrosFCD(List<ReservaDTO> reservas) {
        this.reservas = reservas;
        this.reservaDAO = new ReservaDAO(); // Inicializa tu DAO
    }

    // Constructor sin parámetros
    public FiltrosFCD() {
        this.reservaDAO = new ReservaDAO(); // Inicializa tu DAO
    }

    /**
     * Filtra las reservas según los parámetros de nombre del cliente, teléfono
     * y fecha de la reserva.
     *
     * @param nombreCliente Nombre del cliente para el filtro.
     * @param telefono Teléfono del cliente para el filtro.
     * @param fecha Fecha de la reserva para el filtro.
     * @return Lista de reservas que cumplen con los criterios de filtro.
     */
    @Override
    public List<ReservaDTO> filtrarReservas(String nombreCliente, String telefono, Date fecha) {
        return reservas.stream()
                .filter(reserva -> (nombreCliente == null || reserva.getCliente().getNombre().equals(nombreCliente))
                && (telefono == null || reserva.getCliente().getTelefono().equals(telefono))
                && (fecha == null || reserva.getFechaHoraReserva().toLocalDate().equals(fecha.toInstant().atZone(ZoneId.systemDefault()).toLocalDate())))
                .collect(Collectors.toList());
    }

    public List<ReservaDTO> obtenerReservas() {
        return null;
    }
       
}
