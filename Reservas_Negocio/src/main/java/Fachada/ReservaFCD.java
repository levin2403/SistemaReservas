/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Fachada;

import BO.ReservaBO;
import DTOs.ClienteDTO;
import DTOs.MesaDTO;
import Excepciones.BOException;
import Excepciones.FacadeException;
import Interfaces.IReservaBO;
import interfacesFachada.IReservaFCD;
import java.time.LocalDateTime;
import java.time.LocalTime;

/**
 *
 * @author skevi
 */
public class ReservaFCD implements IReservaFCD{
    
    IReservaBO reseraBO;

    public ReservaFCD() {
        this.reseraBO = new ReservaBO();
    }

    /**
     *
     * @param cliente
     * @param mesa
     * @param horaFecha
     * @param numPersonas
     * @param costo
     * @throws FacadeException
     */
    @Override
    public void agregarReserva(ClienteDTO cliente, MesaDTO mesa, 
            LocalDateTime horaFecha, int numPersonas, double costo) 
            throws FacadeException {
//        try{
        // lista de reservas del dia que se selecciono para la mesa 
        // seleccionada 
        
        //lista de reservas del cliente seleccionado. 
        
        //verificamos el tamaño de la mesa sea la correcta para la 
        //cantidad de personas
        if (numPersonas < mesa.getCapacidadMinima() || 
                numPersonas > mesa.getCapacidadMaxima()) {
            
            // verificamos que la fecha no sea la misma del dia de hoy 
            // ni mayor a un mes.
            LocalDateTime masUnDia = horaFecha.plusHours(24);
            LocalDateTime masUnMes = horaFecha.plusMonths(1);
            if (horaFecha.isAfter(masUnDia) || horaFecha.isBefore(masUnMes)) {
                
                // verificamos que las reservaciones que la hora de la 
                // reservacion sea 1 hora antes del cierre.
                LocalTime horaElegida = horaFecha.toLocalTime();
                LocalTime horaCierre = LocalTime.of(22,0);
                if (horaElegida.isBefore(horaCierre)) {
                    //verificamos las reservas de la mesa seleccionada y 
                    //vemos si entra dentro del rango de las 5 horas.
                    if (true) {
                        
                    }
                }else{
                    throw new FacadeException("La hora elegida es superior a "
                            + "la hora de cierre");
                }
            }else{
                throw new FacadeException("Porfavor eliga una fecha para la "
                        + "reservacion no menor a 24 horas a partir de hoy "
                        + "ni mayora a un mes");
            }
        }else{
            throw new FacadeException("Porfavor seleccione una cantida de "
                    + "personas valida para el tamaño de la mesa");
        }
//        }catch(BOException ex){
//            throw new FacadeException(ex.getMessage());
//        }
        
    }
    
   
}
