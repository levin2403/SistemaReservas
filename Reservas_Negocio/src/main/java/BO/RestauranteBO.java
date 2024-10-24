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
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * 
 * @author skevi
 */
public class RestauranteBO implements IRestauranteBO {

    //
    private static final Logger LOG = Logger.
            getLogger(RestauranteBO.class.getName());
    
    ///
    private final IRestauranteDAO restauranteDAO;
    
    //
    private final RestauranteCVR restauranteCVR;

    /**
     * Contructor por defecto de la clase.
     */
    public RestauranteBO() {
        this.restauranteDAO = new RestauranteDAO();
        this.restauranteCVR = new RestauranteCVR();
    }

    /**
     * 
     * @return
     * @throws BOException 
     */
    @Override
    public RestauranteDTO consultar() throws BOException {
        try{
            Restaurante restaurante = restauranteDAO.consultar();
            RestauranteDTO restauranteDTO = restauranteCVR.toDTO(restaurante);
            
            LOG.log(Level.INFO, "Exito al obtener el restaurante en BO");
            
            return restauranteDTO;
        }
        catch(DAOException de){
            LOG.log(Level.SEVERE, "Error al obtener el restaurante en BO", de);
            throw new BOException(de.getMessage());
        }
        catch(ConversionException ce){
            LOG.log(Level.SEVERE, "Error al obtener el restaurante en BO", ce);
            throw new BOException("Error al obtener el restaurante");
        }
    }

}
