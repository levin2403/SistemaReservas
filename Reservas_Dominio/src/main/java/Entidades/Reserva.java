/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Entidades;

import java.io.Serializable;
import java.time.LocalDateTime;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

/**
 *
 * @author skevi
 */
@Entity
public class Reserva implements Serializable{
    
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private LocalDateTime fechaHoraReserva;

    @Column(nullable = false)
    private int numeroPersonas;

    @Column(nullable = false)
    private double costo;

    @Column(nullable = false)
    private String estado; // Ejemplo: activa, cancelada

    @ManyToOne
    @JoinColumn(name = "cliente_id", nullable = false)
    private Cliente cliente;

    @ManyToOne
    @JoinColumn(name = "mesa_id", nullable = false)
    private Mesa mesa;

    @ManyToOne
    @JoinColumn(name = "restaurante_id", nullable = false)
    private Restaurante restaurante;

    @OneToOne(mappedBy = "reserva", cascade = CascadeType.ALL)
    private HistorialReserva historialReserva;
    
    /**
     * 
     */
    public Reserva() {
    }

    /**
     * 
     * @param fechaHoraReserva
     * @param numeroPersonas
     * @param costo
     * @param estado
     * @param cliente
     * @param mesa
     * @param restaurante
     * @param historialReserva 
     */
    public Reserva(LocalDateTime fechaHoraReserva, int numeroPersonas, 
            double costo, String estado, Cliente cliente, Mesa mesa, 
            Restaurante restaurante, HistorialReserva historialReserva) {
        this.fechaHoraReserva = fechaHoraReserva;
        this.numeroPersonas = numeroPersonas;
        this.costo = costo;
        this.estado = estado;
        this.cliente = cliente;
        this.mesa = mesa;
        this.restaurante = restaurante;
        this.historialReserva = historialReserva;
    }

    /**
     * 
     * @param id
     * @param fechaHoraReserva
     * @param numeroPersonas
     * @param costo
     * @param estado
     * @param cliente
     * @param mesa
     * @param restaurante
     * @param historialReserva 
     */
    public Reserva(Long id, LocalDateTime fechaHoraReserva, 
            int numeroPersonas, double costo, String estado, 
            Cliente cliente, Mesa mesa, Restaurante restaurante, 
            HistorialReserva historialReserva) {
        this.id = id;
        this.fechaHoraReserva = fechaHoraReserva;
        this.numeroPersonas = numeroPersonas;
        this.costo = costo;
        this.estado = estado;
        this.cliente = cliente;
        this.mesa = mesa;
        this.restaurante = restaurante;
        this.historialReserva = historialReserva;
    }

    //Getters y Setters
    
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDateTime getFechaHoraReserva() {
        return fechaHoraReserva;
    }

    public void setFechaHoraReserva(LocalDateTime fechaHoraReserva) {
        this.fechaHoraReserva = fechaHoraReserva;
    }

    public int getNumeroPersonas() {
        return numeroPersonas;
    }

    public void setNumeroPersonas(int numeroPersonas) {
        this.numeroPersonas = numeroPersonas;
    }

    public double getCosto() {
        return costo;
    }

    public void setCosto(double costo) {
        this.costo = costo;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public Mesa getMesa() {
        return mesa;
    }

    public void setMesa(Mesa mesa) {
        this.mesa = mesa;
    }

    public Restaurante getRestaurante() {
        return restaurante;
    }

    public void setRestaurante(Restaurante restaurante) {
        this.restaurante = restaurante;
    }

    public HistorialReserva getHistorialReserva() {
        return historialReserva;
    }

    public void setHistorialReserva(HistorialReserva historialReserva) {
        this.historialReserva = historialReserva;
    }

    @Override
    public String toString() {
        return "Reserva{" + "id=" + id + ", fechaHoraReserva=" + 
                fechaHoraReserva + ", numeroPersonas=" + numeroPersonas + 
                ", costo=" + costo + ", estado=" + estado + ", cliente=" + 
                cliente + ", mesa=" + mesa + ", restaurante=" + restaurante + 
                ", historialReserva=" + historialReserva + '}';
    }

}
