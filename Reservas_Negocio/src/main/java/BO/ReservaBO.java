package BO;

import java.time.LocalDateTime;

public class ReservaBO {

    private Long id;
    private LocalDateTime fechaHoraReserva;
    private int numeroPersonas;
    private double costo;
    private String estado;
    private Long clienteId;
    private Long mesaId;
    private Long restauranteId;
    private Long historialReservaId;

    public ReservaBO() {}

    public ReservaBO(Long id, LocalDateTime fechaHoraReserva, int numeroPersonas, 
                    double costo, String estado, Long clienteId, Long mesaId, 
                    Long restauranteId, Long historialReservaId) {
        this.id = id;
        this.fechaHoraReserva = fechaHoraReserva;
        this.numeroPersonas = numeroPersonas;
        this.costo = costo;
        this.estado = estado;
        this.clienteId = clienteId;
        this.mesaId = mesaId;
        this.restauranteId = restauranteId;
        this.historialReservaId = historialReservaId;
    }

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

    public Long getClienteId() {
        return clienteId;
    }

    public void setClienteId(Long clienteId) {
        this.clienteId = clienteId;
    }

    public Long getMesaId() {
        return mesaId;
    }

    public void setMesaId(Long mesaId) {
        this.mesaId = mesaId;
    }

    public Long getRestauranteId() {
        return restauranteId;
    }

    public void setRestauranteId(Long restauranteId) {
        this.restauranteId = restauranteId;
    }

    public Long getHistorialReservaId() {
        return historialReservaId;
    }

    public void setHistorialReservaId(Long historialReservaId) {
        this.historialReservaId = historialReservaId;
    }

    
}
