package BO;

import DAO.RestauranteDAO;
import DTOs.RestauranteDTO;
import Interfaces.IRestauranteBO;
import Interfaces.IRestauranteDAO;

/**
 * 
 * @author skevi
 */
public class RestauranteBO implements IRestauranteBO {
    
    private final IRestauranteDAO restauranteDAO;

    /**
     * 
     */
    public RestauranteBO() {
        this.restauranteDAO = new RestauranteDAO();
    }

    @Override
    public RestauranteDTO consultar() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

}
