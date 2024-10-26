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
    
    IReservaBO reservaBO;

    public ReservaFCD() {
        this.reservaBO = new ReservaBO();
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
        try{
             verificarTamañoMesa(mesa, numPersonas);
             verificarFechaReservacion(horaFecha);
             verificarHoraReservacion(horaFecha);
             verificarReservacionesCliente(cliente,horaFecha);
//            verificarDisponibilidad(mesa,horaFecha);
//            hacerReserva(cliente, mesa, horaFecha, numPersonas, costo);
        }catch(FacadeException ex){
            throw new FacadeException(ex.getMessage());
        }
        
    }
    
    /**
     * 
     * @param mesa
     * @param numPersonas
     * @throws FacadeException 
     */
    private void verificarTamañoMesa(MesaDTO mesa, int numPersonas)
            throws FacadeException{
        if (numPersonas < mesa.getCapacidadMinima()) {
            throw new FacadeException("El numero de personas es menor a "
                    + "la capacidad de la mesa");
        }
        else if (numPersonas > mesa.getCapacidadMaxima()) {
            throw new FacadeException("El numero de personas es mayor a "
                    + "la capacidad de la mesa");
        }       
    }
    
    /**
     * Valida que la reservacion no se pueda hacer a menos de 24 horas
     * al igual que no se pueda hacer a más de un mes.
     * 
     * @param horaFecha Fecha y hora de la reservación.
     * @throws FacadeException Excepción si la fecha no es válida.
     */
    private void verificarFechaReservacion(LocalDateTime horaFecha) 
            throws FacadeException {

        // Obtener la fecha y hora de 24 horas a partir de ahora
        LocalDateTime masUnDia = LocalDateTime.now().plusHours(24);
        // Obtener la fecha y hora de 1 mes a partir de ahora
        LocalDateTime masUnMes = LocalDateTime.now().plusMonths(1);

        // Verificar si la horaFecha es antes de 24 horas
        if (horaFecha.isBefore(masUnDia)) {
            throw new FacadeException("La reservación no se puede realizar a "
                    + "menos de 24 horas, seleccione otra hora");
        }
        // Verificar si la horaFecha es después de un mes
        else if (horaFecha.isAfter(masUnMes)) {
            throw new FacadeException("La reservación no se puede realizar "
                    + "a fechas mayores de un mes a partir del día de hoy");
        }
    }

    /**
     * verifica que la hora de la reservacion no sea menor a la hora de 
     * apertura y no mayor a la hora de cierre.
     * 
     * @param horaFecha
     * @throws FacadeException 
     */
    private void verificarHoraReservacion(LocalDateTime horaFecha) 
            throws FacadeException{
        
        LocalTime horaElegida = horaFecha.toLocalTime();
        LocalTime horaCierre = LocalTime.of(21,0);
        LocalTime horaApertura = LocalTime.of(12,0);
        
        if (horaElegida.isAfter(horaCierre)){
            throw new FacadeException("La hora de la reservacion no puede ser "
                    + "despues del cierre del restaurante");
        }
        else if (horaElegida.isBefore(horaApertura)){
            throw new FacadeException("La hora de la reservacion no puede ser "
                    + "antes de la apertura del restaurante");
        }
    }
    
    /**
     * Verifica dentro de la base de datos que el cliente no tenga mas 
     * reservaciones a partir de la fecha y hora seleccionada, en caso 
     * de tener mas reservaciones, se le negara hacer la reservacion.
     * 
     * @param cliente
     * @param horaFecha
     * @throws FacadeException 
     */
    private void verificarReservacionesCliente(ClienteDTO cliente, 
            LocalDateTime horaFecha) throws FacadeException{
        try{
            boolean resultado = reservaBO.
                    verificarReservaciones(cliente);
            
            if (!resultado) {
                throw new FacadeException("El cliente ya tiene reservaciones "
                        + "activas a partir de esta fecha");
            }
            
        }catch(BOException be){
            throw new FacadeException(be.getMessage());
        }
    }
    
    /**
     * 
     * 
     * @param mesa
     * @param horaFecha
     * @throws FacadeException 
     */
    private void  verificarDisponibilidad(MesaDTO mesa, 
            LocalDateTime horaFecha) throws FacadeException{
        
    }
    
    /**
     * Realiza la reserva al cliente despues de haber pasado todos los filtros 
     * 
     * @param cliente
     * @param mesa
     * @param horaFecha
     * @param numPersonas
     * @param costo 
     */
    private void hacerReserva(ClienteDTO cliente, MesaDTO mesa, 
            LocalDateTime horaFecha, int numPersonas, double costo){
        
    }
    
}
