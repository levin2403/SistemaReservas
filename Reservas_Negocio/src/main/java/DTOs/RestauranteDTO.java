/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DTOs;

import DTO.MesaDTO;
import java.time.LocalTime;
import java.util.List;

/**
 *
 * @author skevi
 */
public class RestauranteDTO {

    private String id; // identificador del restaurante
    private String nombre; // nombre del restaurante
    private String direccion; // direccion del restaurante
    private String telefono; // telefono del restaurante
    private LocalTime horaApertura; // Hora de apertura
    private LocalTime horaCierre;   // Hora de cierre
    private List<MesaDTO> mesas;

    /**
     * 
     */
    public RestauranteDTO() {
    }

    public RestauranteDTO(String nombre, String direccion, 
            String telefono, LocalTime horaApertura, LocalTime horaCierre) {
        this.nombre = nombre;
        this.direccion = direccion;
        this.telefono = telefono;
        this.horaApertura = horaApertura;
        this.horaCierre = horaCierre;
    }

    public RestauranteDTO(String id, String nombre, String direccion, 
            String telefono, LocalTime horaApertura, LocalTime horaCierre, 
            List<MesaDTO> mesas) {
        this.id = id;
        this.nombre = nombre;
        this.direccion = direccion;
        this.telefono = telefono;
        this.horaApertura = horaApertura;
        this.horaCierre = horaCierre;
        this.mesas = mesas;
    }

    // Getters y Setters
    
    public String getId() {
        return id;
    }

    public void setId(String id) {
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

    public List<MesaDTO> getMesas() {
        return mesas;
    }

    public void setMesas(List<MesaDTO> mesas) {
        this.mesas = mesas;
    }

    @Override
    public String toString() {
        return "RestauranteDTO{" + "id=" + id + ", nombre=" + nombre + 
                ", direccion=" + direccion + ", telefono=" + telefono + 
                ", horaApertura=" + horaApertura + ", horaCierre=" + 
                horaCierre + ", mesas=" + mesas + '}';
    }

}