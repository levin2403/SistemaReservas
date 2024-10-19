/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Entidades;

import java.io.Serializable;
import java.time.LocalDateTime;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

/**
 *
 * @author skevi
 */
@Entity
public class HistorialReserva implements Serializable{
    
    private static final long serialVersionUID = 1L;
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @Column(nullable = false)
    private LocalDateTime fechaRegistro;
    
    @Column(nullable = false)
    private String estadoReserva; // Ejemplo: activa, cancelada
    
    @Column(nullable = false)
    private double multa; // Multa por cancelación, si aplica
    
    @OneToOne
    @JoinColumn(name = "reserva_id", nullable = false)
    private Reserva reserva;

    public HistorialReserva() {
    }

    /**
     * 
     * @param fechaRegistro
     * @param estadoReserva
     * @param multa
     * @param reserva 
     */
    public HistorialReserva(LocalDateTime fechaRegistro, String estadoReserva, 
            double multa, Reserva reserva) {
        this.fechaRegistro = fechaRegistro;
        this.estadoReserva = estadoReserva;
        this.multa = multa;
        this.reserva = reserva;
    }

    /**
     * 
     * @param id
     * @param fechaRegistro
     * @param estadoReserva
     * @param multa
     * @param reserva 
     */
    public HistorialReserva(Long id, LocalDateTime fechaRegistro, 
            String estadoReserva, double multa, Reserva reserva) {
        this.id = id;
        this.fechaRegistro = fechaRegistro;
        this.estadoReserva = estadoReserva;
        this.multa = multa;
        this.reserva = reserva;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDateTime getFechaRegistro() {
        return fechaRegistro;
    }

    public void setFechaRegistro(LocalDateTime fechaRegistro) {
        this.fechaRegistro = fechaRegistro;
    }

    public String getEstadoReserva() {
        return estadoReserva;
    }

    public void setEstadoReserva(String estadoReserva) {
        this.estadoReserva = estadoReserva;
    }

    public double getMulta() {
        return multa;
    }

    public void setMulta(double multa) {
        this.multa = multa;
    }

    public Reserva getReserva() {
        return reserva;
    }

    public void setReserva(Reserva reserva) {
        this.reserva = reserva;
    }

    @Override
    public String toString() {
        return "HistorialReserva{" + "id=" + id + ", fechaRegistro=" + 
                fechaRegistro + ", estadoReserva=" + estadoReserva + 
                ", multa=" + multa + ", reserva=" + reserva + '}';
    }
    
}
