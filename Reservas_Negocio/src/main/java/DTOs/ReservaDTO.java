package DTO;

import java.time.LocalDateTime;

public class ReservaDTO {

    private Long id;
    private LocalDateTime fechaHoraReserva;
    private int numeroPersonas;
    private double costo;
    private String estado;

    public ReservaDTO() {
    }

    public ReservaDTO(Long id, LocalDateTime fechaHoraReserva, int numeroPersonas,
            double costo, String estado) {
        this.id = id;
        this.fechaHoraReserva = fechaHoraReserva;
        this.numeroPersonas = numeroPersonas;
        this.costo = costo;
        this.estado = estado;
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

}
