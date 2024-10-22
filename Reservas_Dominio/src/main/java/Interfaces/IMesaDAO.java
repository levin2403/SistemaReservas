/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Interfaces;

import Entidades.Mesa;
import java.util.List;

/**
 * Interfaz que define las operaciones básicas para la gestión de mesas en la capa de acceso a datos (DAO).
 * Esta interfaz proporciona un contrato para las implementaciones que manejarán la persistencia
 * y recuperación de información sobre mesas.
 * 
 * @author skevi
 */
public interface IMesaDAO {
    
    /**
     * Agrega una nueva mesa a la base de datos.
     * 
     * @param mesa El objeto {@link Mesa} que se desea agregar.
     */
    public void agregarMesa(Mesa mesa);
    
    /**
     * Agrega una lista de mesas a la base de datos.
     * 
     * @param mesas La lista de objetos {@link Mesa} que se desea agregar.
     */
    public void agregarMesas(List<Mesa> mesas);
    
    /**
     * Elimina una mesa específica de la base de datos.
     * 
     * @param mesa El objeto {@link Mesa} que se desea eliminar.
     */
    public void eliminarMesa(Mesa mesa);
    
    /**
     * Actualiza la información de una mesa existente en la base de datos.
     * 
     * @param mesa El objeto {@link Mesa} que contiene la información actualizada de la mesa.
     */
    public void actualizarMesa(Mesa mesa);
    
    /**
     * Consulta y recupera una lista de todas las mesas almacenadas en la base de datos.
     * 
     * @return Una lista de objetos {@link Mesa} que representa todas las mesas.
     */
    public List<Mesa> consultarMesas();
    
    /**
     * Devuelve la cantidad de mesas pequeñas en la base de datos.
     * 
     * @return El número de mesas clasificadas como pequeñas.
     */
    public int cantidadMesasPequeñas();
    
    /**
     * Devuelve la cantidad de mesas medianas en la base de datos.
     * 
     * @return El número de mesas clasificadas como medianas.
     */
    public int cantidadMesasMedianas();
    
    /**
     * Devuelve la cantidad de mesas grandes en la base de datos.
     * 
     * @return El número de mesas clasificadas como grandes.
     */
    public int cantidadMesasGrandes();
}

