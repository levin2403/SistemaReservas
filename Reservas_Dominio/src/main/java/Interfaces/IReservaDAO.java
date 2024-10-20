/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Interfaces;

import Entidades.Reserva;
import java.time.LocalDate;
import java.util.List;

/**
 *
 * @author skevi
 */
public interface IReservaDAO {
    
    public void agregarReserva(Reserva reserva);
    
    public List<Reserva> consultarPorFecha(LocalDate inicio, LocalDate fin);
}
