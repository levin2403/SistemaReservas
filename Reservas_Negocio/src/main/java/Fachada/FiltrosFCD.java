package Fachada;

import DAO.ReservaDAO; // Asegúrate de importar tu DAO
import DTOs.ReservaDTO;
import Excepciones.DAOException;
import interfacesFachada.IFiltrosFCD;
import java.time.ZoneId;
import java.util.Collections;
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
        this.reservaDAO = new ReservaDAO(); // Inicializa tu DAO
        this.reservas = reservas; // Asigna la lista de reservas pasada como argumento
    }

    public FiltrosFCD() {
        this.reservaDAO = new ReservaDAO(); // Inicializa tu DAO
        try {
            this.reservas = reservaDAO.obtenerReservas(); // Inicializa reservas
        } catch (DAOException e) {
            e.printStackTrace(); // Maneja la excepción adecuadamente
            this.reservas = Collections.emptyList(); // Asegúrate de que reservas no sea null
        }
    }

    @Override
    public List<ReservaDTO> filtrarReservas(String nombreCliente, String telefono, Date fecha) {
        try {
            if (reservas == null || reservas.isEmpty()) {
                reservas = reservaDAO.obtenerReservas(); // Asegúrate de obtener las reservas aquí
                if (reservas == null) {
                    return Collections.emptyList();
                }
            }
        } catch (DAOException e) {
            e.printStackTrace(); // Maneja la excepción adecuadamente
            return Collections.emptyList(); // Retorna una lista vacía en caso de error
        }

        return reservas.stream()
                .filter(reserva -> (nombreCliente == null || reserva.getCliente().getNombre().equalsIgnoreCase(nombreCliente))
                && (telefono == null || reserva.getCliente().getTelefono().equals(telefono))
                && (fecha == null || reserva.getFechaHoraReserva().toLocalDate().equals(fecha.toInstant().atZone(ZoneId.systemDefault()).toLocalDate())))
                .collect(Collectors.toList());
    }
}
