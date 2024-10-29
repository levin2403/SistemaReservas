package BO;

import Convertidores.RestauranteCVR;
import DAO.RestauranteDAO;
import DTOs.RestauranteDTO;
import Entidades.Restaurante;
import Excepciones.BOException;
import Excepciones.ConversionException;
import Excepciones.DAOException;
import Interfaces.IRestauranteBO;
import Interfaces.IRestauranteDAO;
import java.time.LocalTime;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Clase intermediaria entre la capa de DAO para la entidad Restaurante que 
 * convierte los métodos de la clase DAO a DTO o a Entidad dependiendo del 
 * flujo. Sirve como puente para la lógica de negocio en la gestión de 
 * restaurantes, coordinando interacciones entre la capa de acceso a datos (DAO) 
 * y la de presentación.
 * 
 * Proporciona métodos que encapsulan las operaciones de negocio, como la 
 * consulta de datos de restaurante, y maneja las excepciones para que puedan 
 * ser interpretadas adecuadamente en la capa de presentación.
 * 
 * @author skevi
 */
public class RestauranteBO implements IRestauranteBO {

    // Instancia del logger para registrar eventos y errores durante la ejecución.
    private static final Logger LOG = Logger.getLogger(RestauranteBO.class.getName());
    
    // Interfaz de acceso a datos para Restaurante, permite realizar operaciones de persistencia.
    private final IRestauranteDAO restauranteDAO;
    
    // Convertidor que transforma objetos entre las representaciones DAO y DTO.
    private final RestauranteCVR restauranteCVR;

    /**
     * Constructor por defecto de la clase. Inicializa las instancias necesarias 
     * para acceder a datos de restaurante y realizar conversiones entre 
     * entidades y DTO.
     */
    public RestauranteBO() {
        this.restauranteDAO = new RestauranteDAO();
        this.restauranteCVR = new RestauranteCVR();
    }

    /**
     * Realiza una consulta de los datos del restaurante y devuelve un 
     * objeto DTO que representa los datos del restaurante.
     * 
     * @return Un objeto RestauranteDTO que contiene los datos del restaurante 
     *         obtenidos desde la base de datos.
     * @throws BOException Si ocurre un error en la capa de acceso a datos o 
     *         en la conversión de los datos de la entidad a DTO.
     */
    @Override
    public RestauranteDTO consultar() throws BOException {
        try {
            // Recupera la entidad Restaurante desde la capa de acceso a datos.
            Restaurante restaurante = restauranteDAO.consultar();
            
            // Convierte la entidad Restaurante a su representación DTO.
            RestauranteDTO restauranteDTO = restauranteCVR.toDTO(restaurante);
            
            // Registro de información sobre la consulta exitosa.
            LOG.log(Level.INFO, "Éxito al obtener el restaurante en BO");
            
            return restauranteDTO;
        } catch (DAOException de) {
            LOG.log(Level.SEVERE, "Error al obtener el restaurante en BO", de);
            throw new BOException(de.getMessage());
        } catch (ConversionException ce) {
            LOG.log(Level.SEVERE, "Error al obtener el restaurante en BO", ce);
            throw new BOException("Error al obtener el restaurante");
        }
    }

    /**
     * Cambia la hora de apertura y/o cierre del restaurante.
     *
     * @param horaApertura Nueva hora de apertura en formato LocalTime.
     * @param horaCierre Nueva hora de cierre en formato LocalTime.
     * @throws BOException Si ocurre un error en la capa de acceso a datos 
     *         o en la conversión de los datos.
     */
    public void cambiarHoraRestaurante(LocalTime horaApertura, LocalTime horaCierre) throws BOException {
        try {
            // Recupera el restaurante actual
            Restaurante restaurante = restauranteDAO.consultar();

            // Establece la nueva hora de apertura si no es nula
            if (horaApertura != null) {
                restaurante.setHoraApertura(horaApertura);
                LOG.log(Level.INFO, "Hora de apertura actualizada a: {0}", horaApertura);
            }

            // Establece la nueva hora de cierre si no es nula
            if (horaCierre != null) {
                // Valida que la hora de cierre sea posterior a la de apertura
                if (restaurante.getHoraApertura() != null && horaCierre.isBefore(restaurante.getHoraApertura())) {
                    throw new BOException("La hora de cierre debe ser posterior a la de apertura.");
                }
                restaurante.setHoraCierre(horaCierre);
                LOG.log(Level.INFO, "Hora de cierre actualizada a: {0}", horaCierre);
            }

            // Guarda los cambios en la base de datos
            restauranteDAO.actualizar(restaurante);

        } catch (DAOException de) {
            LOG.log(Level.SEVERE, "Error al actualizar las horas del restaurante", de);
            throw new BOException(de.getMessage());
        }
    }
}
