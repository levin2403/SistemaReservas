/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Interfaces;

import Entidades.HistorialReserva;
import java.time.LocalDate;
import java.util.List;

/**
 *
 * @author skevi
 */
public interface IHistorialReservasDAO {
    
    public void agregar(HistorialReserva historialReserva);
    
    public void actualizar(HistorialReserva historialReserva);
    
    public List<HistorialReserva> buscarReservasPorFiltros(String nombreCliente, 
            String telefonoCliente, LocalDate fechaReserva,
            String areaRestaurante, LocalDate fechaInicio, 
            LocalDate fechaFin, Integer tamanoMesa);
    
}
