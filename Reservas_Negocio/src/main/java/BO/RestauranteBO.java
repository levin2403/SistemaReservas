package BO;

import Convertidores.RestauranteCVR;
import DAO.RestauranteDAO;
import DTOs.RestauranteDTO;
import Excepciones.BOException;
import Interfaces.IRestauranteBO;
import Interfaces.IRestauranteDAO;

/**
 * 
 * @author skevi
 */
public class RestauranteBO implements IRestauranteBO {
    
    private final IRestauranteDAO restauranteDAO;
    private final RestauranteCVR mesaCVR;

    /**
     * 
     */
    public RestauranteBO() {
        this.restauranteDAO = new RestauranteDAO();
        this.mesaCVR = new RestauranteCVR();
    }

    @Override
    public RestauranteDTO consultar() throws BOException {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

}
