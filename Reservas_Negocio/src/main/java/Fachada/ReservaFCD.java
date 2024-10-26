/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Fachada;

import BO.ReservaBO;
import BO.RestauranteBO;
import DTOs.ClienteDTO;
import DTOs.MesaDTO;
import DTOs.ReservaDTO;
import DTOs.RestauranteDTO;
import Excepciones.BOException;
import Excepciones.FacadeException;
import Interfaces.IReservaBO;
import Interfaces.IRestauranteBO;
import interfacesFachada.IReservaFCD;
import java.time.Duration;
import java.time.LocalDateTime;
import java.time.LocalTime;
import javax.swing.JOptionPane;

/**
 *
 * @author skevi
 */
public class ReservaFCD implements IReservaFCD{
    
    IReservaBO reservaBO;
    IRestauranteBO restauranteBO;

    public ReservaFCD() {
        this.reservaBO = new ReservaBO();
        this.restauranteBO = new RestauranteBO();
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
             verificarReservacionesCliente(cliente);
             verificarDisponibilidad(mesa,horaFecha);
             System.out.println("paso prueba");
            hacerReserva(cliente, mesa, horaFecha, numPersonas, costo);
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
    private void verificarReservacionesCliente(ClienteDTO cliente) 
            throws FacadeException{
        try{

            boolean resultado = reservaBO.
                    verificarReservaciones(cliente);
            
            if (resultado) {
                throw new FacadeException("El cliente ya tiene reservaciones "
                        + "activas a partir de esta fecha");
            }
            
        }catch(BOException be){
            throw new FacadeException(be.getMessage());
        }
    }
    
    /**
     * Comparamos si en el dia elegido la mesa anterior 
     * 
     * @param mesa
     * @param horaFecha
     * @throws FacadeException 
     */
    private void  verificarDisponibilidad(MesaDTO mesa, 
            LocalDateTime horaFecha) throws FacadeException{
        try{
            
            boolean resultado = reservaBO.verificarPorDia(mesa, horaFecha);
            
            if (!resultado) {
                throw new FacadeException("La mesa no se encuntra disponible "
                        + "en las hora especificada");
            }
            
        }
        catch(BOException be){
            throw new FacadeException();
        }
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
            LocalDateTime horaFecha, int numPersonas, double costo) 
            throws FacadeException{
        try{
            
            //opcion para saber si desea agregar la reservacion
            int respuesta = JOptionPane.showConfirmDialog(null, 
                    "¿Esta seguro que desea agregar la reservacion?", 
                    "Agregar reservacion", JOptionPane.YES_NO_OPTION);
            
            //si la respuesta fue si
            if (respuesta == JOptionPane.YES_OPTION){
            RestauranteDTO restaurante = restauranteBO.consultar();
            
            ReservaDTO reserva = new ReservaDTO(horaFecha, numPersonas, costo, 
                    "ACTIVA", 0, cliente, mesa, restaurante);
            
            
            reservaBO.agregarReserva(reserva);
            
            JOptionPane.showMessageDialog(null, "Reservacion agregada con "
                    + "exito");
            }
            
        }
        catch(BOException be){
            throw new FacadeException();
        }
    }
    
    ////////////////////////////////////////////////////////////////////////////
    
    /**
     * 
     * @param reserva 
     * @throws Excepciones.FacadeException 
     */
    @Override
    public void cancelarReserva(ReservaDTO reserva) throws FacadeException{
        try{
            if (reserva.getEstado().equalsIgnoreCase("CANCELADA")) {
                throw new FacadeException("La reserva ya se encuentra "
                        + "cancelada");
            }
            
            LocalDateTime hoy = LocalDateTime.now();
            
            if (reserva.getFechaHoraReserva().isBefore(hoy)) {
                throw new FacadeException("La reserva ya a pasado, no puede "
                        + "ser cancelada");
            }
            
            
            //opcion para saber si desea agregar la reservacion
            int respuesta = JOptionPane.showConfirmDialog(null, 
                    "¿Esta seguro que desea agregar la reservacion?", 
                    "Agregar reservacion", JOptionPane.YES_NO_OPTION);
            
            //si la respuesta fue si
            if (respuesta == JOptionPane.YES_OPTION){
            
                reserva.setEstado("CANCELADA");
                reserva.setMulta(calcularMulta(reserva));
            
                System.out.println(reserva.toString());
            
                 JOptionPane.showMessageDialog(null, "Reservacion cancelada "
                         + "con exito");
                 
                 reservaBO.actualizarReserva(reserva);
            }

        }
        catch(BOException be){
            throw new FacadeException(be.getMessage());
        }
    }
    
    /**
     * Metodo que calcula la multa.
     * 
     * @param reserva El objeto que contiene la información de la reserva
     * @return El monto de la multa según el tiempo de antelación de la cancelación
     */
    private double calcularMulta(ReservaDTO reserva) {
        // Suponiendo que la fecha y hora actual representa el momento de la cancelación
        LocalDateTime ahora = LocalDateTime.now();
        LocalDateTime fechaReserva = reserva.getFechaHoraReserva();
        double costoReserva = reserva.getCosto();

        // Calculamos la diferencia en horas entre el momento actual y la fecha de la reserva
        long horasDeAnticipacion = Duration.between(ahora, fechaReserva).toHours();

        // Aplicamos las reglas de penalización según el tiempo de anticipación
        if (horasDeAnticipacion > 48) {
            return 0.0; // Sin multa
        } else if (horasDeAnticipacion >= 24) {
            return costoReserva * 0.25; // Multa del 25%
        } else {
            return costoReserva * 0.50; // Multa del 50%
        }
    }

    
}
