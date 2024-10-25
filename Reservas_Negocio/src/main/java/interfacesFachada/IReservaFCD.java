/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package interfacesFachada;

import DTOs.ClienteDTO;
import DTOs.MesaDTO;
import Excepciones.FacadeException;
import java.time.LocalDateTime;

/**
 *
 * @author skevi
 */
public interface IReservaFCD {
    
    public void agregarReserva(ClienteDTO cliente, MesaDTO mesa, 
            LocalDateTime horaFecha, int numPersonas, double costo) 
            throws FacadeException;
    
}
