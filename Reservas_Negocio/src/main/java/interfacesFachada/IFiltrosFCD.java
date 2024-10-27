package interfacesFachada;

/**
 *
 * @author Sebastian Murrieta
 */
import DTOs.ReservaDTO;
import java.util.Date;
import java.util.List;

/**
 * Interfaz para la gestión de filtros de reservas.
 */
public interface IFiltrosFCD {

    List<ReservaDTO> filtrarReservas(String nombreCliente, String telefono, Date fecha);
}
