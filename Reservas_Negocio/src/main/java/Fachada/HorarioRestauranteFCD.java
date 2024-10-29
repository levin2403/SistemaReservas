package Fachada;

import DTOs.RestauranteDTO;
import interfacesFachada.IHorarioRestauranteFCD;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.logging.Logger;

/**
 * Clase fachada para gestionar el horario de apertura y cierre de un
 * restaurante. Esta clase permite establecer las horas de apertura y cierre de
 * un restaurante, asegurándose de que las horas sean válidas.
 *
 * @author Sebastian Murrieta
 */
public class HorarioRestauranteFCD implements IHorarioRestauranteFCD {

    private static final Logger logger = Logger.getLogger(HorarioRestauranteFCD.class.getName());

    /**
     * Establece la hora de apertura del restaurante.
     *
     * @param restaurante el restaurante cuyo horario se va a establecer
     * @param horaApertura la hora de apertura a establecer
     */
    @Override
    public void establecerHoraApertura(RestauranteDTO restaurante, String horaAperturaString) {
        if (horaAperturaString == null || !esFormatoHoraValido(horaAperturaString)) {
            logger.severe("Error: La hora de apertura no es válida.");
            return; // Salir del método si el formato es inválido
        }

        LocalTime horaApertura = LocalTime.parse(horaAperturaString, DateTimeFormatter.ofPattern("hh:mm a"));
        restaurante.setHoraApertura(horaApertura);
        logger.info("Hora de apertura establecida: " + horaApertura);
    }

    /**
     * Establece la hora de cierre del restaurante.
     *
     * @param restaurante el restaurante cuyo horario se va a establecer
     * @param horaCierre la hora de cierre a establecer
     */
    @Override
    public void establecerHoraCierre(RestauranteDTO restaurante, LocalTime horaCierre) {
        if (horaCierre == null) {
            logger.severe("Error: La hora de cierre no puede ser nula.");
            return; // Salir del método si la hora es nula
        }

        if (!isHoraCierreValida(restaurante, horaCierre)) {
            logger.severe("Error: La hora de cierre debe ser posterior a la de apertura.");
            return; // Salir del método si la validación falla
        }

        restaurante.setHoraCierre(horaCierre);
        logger.info("Hora de cierre establecida: " + horaCierre);
    }

    /**
     * Valida si la hora de cierre es posterior a la hora de apertura.
     *
     * @param restaurante el restaurante que se está verificando
     * @param horaCierre la hora de cierre a validar
     * @return true si la hora de cierre es válida; false en caso contrario
     */
    private boolean isHoraCierreValida(RestauranteDTO restaurante, LocalTime horaCierre) {
        LocalTime horaApertura = restaurante.getHoraApertura();
        return horaApertura != null && horaCierre.isAfter(horaApertura);
    }

    /**
     * Valida si el formato de la hora es correcto (hh:mm a).
     *
     * @param hora la cadena de hora a validar
     * @return true si el formato es válido, false de lo contrario
     */
    private boolean esFormatoHoraValido(String hora) {
        try {
            LocalTime.parse(hora, DateTimeFormatter.ofPattern("hh:mm a"));
            return true;
        } catch (Exception e) {
            return false;
        }
    }
}
