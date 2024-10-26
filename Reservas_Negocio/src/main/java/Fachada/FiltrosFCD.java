package Fachada;

import DTOs.ReservaDTO;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

/**
 * Clase para filtrar reservas según criterios de fecha, tipo de mesa y ubicación.
 * 
 * @author Sebastian Murrieta Verduzco - 233463
 */
public class FiltrosFCD {

    @PersistenceContext
    private EntityManager entityManager;

    public List<ReservaDTO> obtenerReservasPorFiltros(String fechaInicio, String fechaFin, String tipoMesa, String ubicacion) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        LocalDateTime inicio = LocalDate.parse(fechaInicio, formatter).atStartOfDay();
        LocalDateTime fin = LocalDate.parse(fechaFin, formatter).atTime(23, 59);

        String jpql = "SELECT r FROM Reserva r WHERE r.fecha BETWEEN :inicio AND :fin";
        if (!tipoMesa.isEmpty()) jpql += " AND r.tipoMesa = :tipoMesa";
        if (!ubicacion.isEmpty()) jpql += " AND r.ubicacion = :ubicacion";

        TypedQuery<ReservaDTO> query = entityManager.createQuery(jpql, ReservaDTO.class)
                .setParameter("inicio", inicio)
                .setParameter("fin", fin);

        if (!tipoMesa.isEmpty()) query.setParameter("tipoMesa", tipoMesa);
        if (!ubicacion.isEmpty()) query.setParameter("ubicacion", ubicacion);

        return query.getResultList();
    }
}
