/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Interfaces;

import DTO.MesaDTO;
import java.util.List;

/**
 * Interfaz que define las operaciones básicas para la gestión de mesas en la capa de negocio (BO).
 * Esta interfaz proporciona un contrato para las implementaciones que manejarán la persistencia
 * y recuperación de información sobre mesas.
 * 
 * @author skevi
 */
public interface IMesaBO {
 
        /**
     * Agrega una nueva mesa a la base de datos.
     * 
     * @param mesa El objeto {@link Mesa} que se desea agregar.
     */
    public void agregarMesa(MesaDTO mesa);
    
    /**
     * Agrega una lista de mesas a la base de datos.
     * 
     * @param mesas La lista de objetos {@link Mesa} que se desea agregar.
     */
    public void agregarMesas(List<MesaDTO> mesas);
    
    /**
     * Consulta y recupera una lista de todas las mesas almacenadas en la base de datos.
     * 
     * @return Una lista de objetos {@link Mesa} que representa todas las mesas.
     */
    public List<MesaDTO> consultarMesas();
    
    /**
     * Devuelve la cantidad de mesas dependiendo de su tipo;
     * 
     * @return El número de mesas clasificadas como pequeñas.
     */
    public int cantidadMesasPorTipo(String tipo);
    
    /**
     * Obtiene una lista de mesas dependiendo su tipo especidicado en el 
     * parametro.
     * 
     * @param tipo Tipo de mesa.
     * @return Lista de mesas filtradas por tipo.
     */
    public List<MesaDTO> obtenerMesasPorTipo(String tipo);
    
}
