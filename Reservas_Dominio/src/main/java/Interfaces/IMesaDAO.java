/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Interfaces;

import Entidades.Mesa;
import java.util.List;

/**
 *
 * @author skevi
 */
public interface IMesaDAO {
    
    public void agregarMesa(Mesa mesa);
    
    public void agregarMesas(List<Mesa> mesas);
    
    public void eliminarMesa(Mesa mesa);
    
    public void actualizarMesa(Mesa mesa);
    
    public List<Mesa> consultarMesas();
    
    public int cantidadMesasPequeñas();
    
    public int cantidadMesasMedianas();
    
    public int cantidadMesasGrandes();
    
}
