/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Entidades;

import java.io.Serializable;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 *
 * @author skevi
 */
@Entity
@Table(name = "mesas")
public class Mesa implements Serializable{
    
    private static final long serialVersionUID = 1L;
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "codigo_mesa",nullable = false, unique = true)
    private String codigoMesa;

    @Column(name = "tipo_mesa", nullable = false)
    private String tipoMesa; // Ejemplo: pequeña, mediana, grande

    @Column(nullable = false)
    private int capacidad;

    @Column(nullable = false)
    private String ubicacion; // Ejemplo: terraza, ventana, general

    @ManyToOne
    @JoinColumn(name = "restaurante_id", nullable = false)
    private Restaurante restaurante;

    @OneToMany(mappedBy = "mesas", cascade = CascadeType.PERSIST)
    private List<Reserva> reservas;

    /**
     * 
     */
    public Mesa() {
    }

    public Mesa(String codigoMesa, String tipoMesa, int capacidad, 
            String ubicacion, Restaurante restaurante, 
            List<Reserva> reservas) {
        this.codigoMesa = codigoMesa;
        this.tipoMesa = tipoMesa;
        this.capacidad = capacidad;
        this.ubicacion = ubicacion;
        this.restaurante = restaurante;
        this.reservas = reservas;
    }

    public Mesa(Long id, String codigoMesa, String tipoMesa, 
            int capacidad, String ubicacion, Restaurante restaurante, 
            List<Reserva> reservas) {
        this.id = id;
        this.codigoMesa = codigoMesa;
        this.tipoMesa = tipoMesa;
        this.capacidad = capacidad;
        this.ubicacion = ubicacion;
        this.restaurante = restaurante;
        this.reservas = reservas;
    }

    //Getters y Setters

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCodigoMesa() {
        return codigoMesa;
    }

    public void setCodigoMesa(String codigoMesa) {
        this.codigoMesa = codigoMesa;
    }

    public String getTipoMesa() {
        return tipoMesa;
    }

    public void setTipoMesa(String tipoMesa) {
        this.tipoMesa = tipoMesa;
    }

    public int getCapacidad() {
        return capacidad;
    }

    public void setCapacidad(int capacidad) {
        this.capacidad = capacidad;
    }

    public String getUbicacion() {
        return ubicacion;
    }

    public void setUbicacion(String ubicacion) {
        this.ubicacion = ubicacion;
    }

    public Restaurante getRestaurante() {
        return restaurante;
    }

    public void setRestaurante(Restaurante restaurante) {
        this.restaurante = restaurante;
    }

    public List<Reserva> getReservas() {
        return reservas;
    }

    public void setReservas(List<Reserva> reservas) {
        this.reservas = reservas;
    }

    @Override
    public String toString() {
        return "Mesa{" + "id=" + id + ", codigoMesa=" + codigoMesa + 
                ", tipoMesa=" + tipoMesa + ", capacidad=" + capacidad + 
                ", ubicacion=" + ubicacion + ", restaurante=" + restaurante + 
                ", reservas=" + reservas + '}';
    }
        
}
