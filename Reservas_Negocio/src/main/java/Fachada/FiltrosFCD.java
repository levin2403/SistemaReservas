package Fachada;

import BO.ReservaBO;
import DTOs.ReservaDTO;
import Excepciones.BOException;
import interfacesFachada.IFiltrosFCD;
import java.time.ZoneId;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.stream.Collectors;

/**
 * Clase para filtrar reservas según criterios de cliente, teléfono y fecha.
 * Implementa el patrón Facade para simplificar la interfaz de filtrado de reservas.
 *
 * @author Sebastian
 */
public class FiltrosFCD implements IFiltrosFCD {
    
    private static final Logger LOG = Logger.getLogger(FiltrosFCD.class.getName());
    private List<ReservaDTO> reservas;
    private final ReservaBO reservaBO;  // Cambiamos a usar BO en lugar de DAO directamente
    
    /**
     * Constructor que inicializa con una lista específica de reservas.
     * @param reservas Lista predefinida de reservas
     */
    public FiltrosFCD(List<ReservaDTO> reservas) {
        this.reservaBO = new ReservaBO();
        this.reservas = reservas != null ? reservas : Collections.emptyList();
    }
    
    /**
     * Constructor por defecto que carga las reservas desde la base de datos.
     */
    public FiltrosFCD() {
        this.reservaBO = new ReservaBO();
        cargarReservas();
    }
    
    /**
     * Carga las reservas desde la base de datos.
     * Si ocurre un error, inicializa una lista vacía y registra el error.
     */
    private void cargarReservas() {
        try {
            this.reservas = reservaBO.obtenerReservas();
        } catch (BOException e) {
            LOG.log(Level.SEVERE, "Error al cargar las reservas: {0}", e.getMessage());
            this.reservas = Collections.emptyList();
        }
    }
    
    /**
     * Refresca la lista de reservas desde la base de datos.
     * Útil cuando se necesita actualizar los datos.
     *
     * @throws BOException si ocurre un error al recargar las reservas
     */
    public void refrescarReservas() throws BOException {
        cargarReservas();
    }
    
    /**
     * Filtra las reservas según los criterios especificados.
     * Si la lista de reservas está vacía, intenta cargarla primero.
     *
     * @param nombreCliente Nombre del cliente a filtrar (puede ser null)
     * @param telefono Teléfono del cliente a filtrar (puede ser null)
     * @param fecha Fecha de la reserva a filtrar (puede ser null)
     * @return Lista filtrada de reservas
     */
    @Override
    public List<ReservaDTO> filtrarReservas(String nombreCliente, String telefono, Date fecha) {
        if (reservas == null || reservas.isEmpty()) {
            cargarReservas();
        }
        
        return reservas.stream()
                .filter(reserva -> cumpleCriteriosFiltro(reserva, nombreCliente, telefono, fecha))
                .collect(Collectors.toList());
    }
    
    /**
     * Verifica si una reserva cumple con los criterios de filtrado especificados.
     *
     * @param reserva Reserva a verificar
     * @param nombreCliente Nombre del cliente a filtrar
     * @param telefono Teléfono del cliente a filtrar
     * @param fecha Fecha de la reserva a filtrar
     * @return true si la reserva cumple con los criterios, false en caso contrario
     */
    private boolean cumpleCriteriosFiltro(ReservaDTO reserva, String nombreCliente, 
            String telefono, Date fecha) {
        
        boolean cumpleNombre = nombreCliente == null || 
                (reserva.getCliente() != null && 
                reserva.getCliente().getNombre() != null &&
                reserva.getCliente().getNombre().toLowerCase()
                        .contains(nombreCliente.toLowerCase()));
        
        boolean cumpleTelefono = telefono == null || 
                (reserva.getCliente() != null && 
                reserva.getCliente().getTelefono() != null &&
                reserva.getCliente().getTelefono().equals(telefono));
        
        boolean cumpleFecha = fecha == null || 
                (reserva.getFechaHoraReserva() != null &&
                reserva.getFechaHoraReserva().toLocalDate()
                        .equals(fecha.toInstant()
                                .atZone(ZoneId.systemDefault())
                                .toLocalDate()));
        
        return cumpleNombre && cumpleTelefono && cumpleFecha;
    }
    
    /**
     * Obtiene la lista actual de reservas.
     *
     * @return Lista de reservas actual
     */
    public List<ReservaDTO> getReservas() {
        return Collections.unmodifiableList(reservas);
    }
}