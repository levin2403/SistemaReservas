package DTO;

import java.time.LocalDateTime;

public class HistorialReservaDTO {

    private Long id;
    private String cambioEstado;
    private LocalDateTime fechaCambio;

    public HistorialReservaDTO() {}

    public HistorialReservaDTO(Long id, String cambioEstado, 
                               LocalDateTime fechaCambio) {
        this.id = id;
        this.cambioEstado = cambioEstado;
        this.fechaCambio = fechaCambio;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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
