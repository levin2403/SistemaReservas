package BO;

import java.time.LocalDateTime;

public class HistorialReservaBO {

    private Long id;
    private Long reservaId;
    private String cambioEstado;
    private LocalDateTime fechaCambio;

    public HistorialReservaBO() {}

    public HistorialReservaBO(Long id, Long reservaId, String cambioEstado, 
                              LocalDateTime fechaCambio) {
        this.id = id;
        this.reservaId = reservaId;
        this.cambioEstado = cambioEstado;
        this.fechaCambio = fechaCambio;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getReservaId() {
        return reservaId;
    }

    public void setReservaId(Long reservaId) {
        this.reservaId = reservaId;
    }

    public String getCambioEstado() {
        return cambioEstado;
    }

    public void setCambioEstado(String cambioEstado) {
        this.cambioEstado = cambioEstado;
    }

    public LocalDateTime getFechaCambio() {
        return fechaCambio;
    }

    public void setFechaCambio(LocalDateTime fechaCambio) {
        this.fechaCambio = fechaCambio;
    }

    
}
