/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Entidades;

import java.io.Serializable;
import java.time.LocalTime;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

/**
 *
 * @author skevi
 */
@Entity
public class Restaurante implements Serializable{

    private static final long serialVersionUID = 1L;
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String nombre;

    @Column(nullable = false)
    private String direccion;

    @Column(nullable = false)
    private String telefono;

    @Column(nullable = false)
    private LocalTime horaApertura; // Ejemplo: "10:00"
    
    @Column(nullable = false)
    private LocalTime horaCierre; // Ejemplo: "22:00"

    @OneToMany(mappedBy = "restaurante", cascade = CascadeType.ALL)
    private List<Mesa> mesas;

    @OneToMany(mappedBy = "restaurante", cascade = CascadeType.ALL)
    private List<Reserva> reservas;


    /**
     * 
     */
    public Restaurante() {
    }

    /**
     * Constructor completo sin id.
     * 
     * @param nombre
     * @param direccion
     * @param telefono
     * @param horaApertura
     * @param horaCierre
     * @param mesas
     * @param reservas 
     */
    public Restaurante(String nombre, String direccion, String telefono, 
            LocalTime horaApertura, LocalTime horaCierre, 
            List<Mesa> mesas, List<Reserva> reservas) {
        this.nombre = nombre;
        this.direccion = direccion;
        this.telefono = telefono;
        this.horaApertura = horaApertura;
        this.horaCierre = horaCierre;
        this.mesas = mesas;
        this.reservas = reservas;
    }

    /**
     * Constructor completo.
     * 
     * @param id
     * @param nombre
     * @param direccion
     * @param telefono
     * @param horaApertura
     * @param horaCierre
     * @param mesas
     * @param reservas 
     */
    public Restaurante(Long id, String nombre, String direccion, 
            String telefono, LocalTime horaApertura, LocalTime horaCierre, 
            List<Mesa> mesas, List<Reserva> reservas) {
        this.id = id;
        this.nombre = nombre;
        this.direccion = direccion;
        this.telefono = telefono;
        this.horaApertura = horaApertura;
        this.horaCierre = horaCierre;
        this.mesas = mesas;
        this.reservas = reservas;
    }

    /**
     * Constructor para inserciones.
     * 
     * @param nombre
     * @param direccion
     * @param telefono
     * @param horaApertura
     * @param horaCierre 
     */
    public Restaurante(String nombre, String direccion, String telefono, 
            LocalTime horaApertura, LocalTime horaCierre) {
        this.nombre = nombre;
        this.direccion = direccion;
        this.telefono = telefono;
        this.horaApertura = horaApertura;
        this.horaCierre = horaCierre;
    }


    //Getters y Setters
    
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

    public List<Mesa> getMesas() {
        return mesas;
    }

    public void setMesas(List<Mesa> mesas) {
        this.mesas = mesas;
    }

    public List<Reserva> getReservas() {
        return reservas;
    }

    public void setReservas(List<Reserva> reservas) {
        this.reservas = reservas;
    }
    
}
