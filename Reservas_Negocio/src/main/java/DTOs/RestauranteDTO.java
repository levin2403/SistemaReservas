/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DTOs;

import java.time.LocalTime;

/**
 *
 * @author skevi
 */
public class RestauranteDTO {

    private Long id; // identificador del restaurante
    private String nombre; // nombre del restaurante
    private String direccion; // direccion del restaurante
    private String telefono; // telefono del restaurante
    private LocalTime horaApertura; // Hora de apertura
    private LocalTime horaCierre;   // Hora de cierre

    /**
     * 
     */
    public RestauranteDTO() {
    }

    /**
     * 
     * @param nombre
     * @param direccion
     * @param telefono
     * @param horaApertura
     * @param horaCierre 
     */
    public RestauranteDTO(String nombre, String direccion, String telefono, 
            LocalTime horaApertura, LocalTime horaCierre) {
        this.nombre = nombre;
        this.direccion = direccion;
        this.telefono = telefono;
        this.horaApertura = horaApertura;
        this.horaCierre = horaCierre;
    }

    /**
     * 
     * @param id
     * @param nombre
     * @param direccion
     * @param telefono
     * @param horaApertura
     * @param horaCierre 
     */
    public RestauranteDTO(Long id, String nombre, String direccion, 
            String telefono, LocalTime horaApertura, LocalTime horaCierre) {
        this.id = id;
        this.nombre = nombre;
        this.direccion = direccion;
        this.telefono = telefono;
        this.horaApertura = horaApertura;
        this.horaCierre = horaCierre;
    }

    // Getters y Setters
    
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public LocalTime getHoraApertura() {
        return horaApertura;
    }

    public void setHoraApertura(LocalTime horaApertura) {
        this.horaApertura = horaApertura;
    }

    public LocalTime getHoraCierre() {
        return horaCierre;
    }

    public void setHoraCierre(LocalTime horaCierre) {
        this.horaCierre = horaCierre;
    }

}