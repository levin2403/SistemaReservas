package Fachada;

/**
 *
 * @author Sebastian Murrieta Verduzco - 233463
 */
import DTOs.ReservaDTO;
import interfacesFachada.IConsultasFCD;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class ConsultasFCD implements IConsultasFCD {

    private List<ReservaDTO> reservas; // Lista simulada de reservas

    public ConsultasFCD(List<ReservaDTO> reservas) {
        this.reservas = reservas;
    }

    @Override
    public List<ReservaDTO> consultarReservasPorFechas(LocalDateTime fechaInicio, LocalDateTime fechaFin) {
        return reservas.stream()
                .filter(reserva -> reserva.getFechaHoraReserva().isAfter(fechaInicio) &&
                                   reserva.getFechaHoraReserva().isBefore(fechaFin))
                .collect(Collectors.toList());
    }

    @Override
    public List<ReservaDTO> consultarReservasPorTipoMesa(String tipoMesa) {
        return reservas.stream()
                .filter(reserva -> reserva.getMesa().getTipoMesa().equalsIgnoreCase(tipoMesa))
                .collect(Collectors.toList());
    }

    @Override
    public List<ReservaDTO> consultarReservasPorUbicacion(String ubicacion) {
        return reservas.stream()
                .filter(reserva -> reserva.getMesa().getUbicacion().equalsIgnoreCase(ubicacion))
                .collect(Collectors.toList());
    }

    @Override
    public List<ReservaDTO> consultarReservas(LocalDateTime fechaInicio, LocalDateTime fechaFin, String tipoMesa, String ubicacion) {
        return reservas.stream()
                .filter(reserva -> reserva.getFechaHoraReserva().isAfter(fechaInicio) &&
                                   reserva.getFechaHoraReserva().isBefore(fechaFin) &&
                                   reserva.getMesa().getTipoMesa().equalsIgnoreCase(tipoMesa) &&
                                   reserva.getMesa().getUbicacion().equalsIgnoreCase(ubicacion))
                .collect(Collectors.toList());
    }
}

