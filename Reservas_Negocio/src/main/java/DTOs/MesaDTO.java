package DTO;

public class MesaDTO {

    private Long id;
    private int capacidad;
    private String codigoMesa;
    private String estado;

    public MesaDTO() {
    }

    public MesaDTO(Long id, int capacidad, String codigoMesa, String estado) {
        this.id = id;
        this.capacidad = capacidad;
        this.codigoMesa = codigoMesa;
        this.estado = estado;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getCapacidad() {
        return capacidad;
    }

    public void setCapacidad(int capacidad) {
        this.capacidad = capacidad;
    }

    public String getCodigoMesa() {
        return codigoMesa;
    }

    public void setCodigoMesa(String codigoMesa) {
        this.codigoMesa = codigoMesa;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    
}
