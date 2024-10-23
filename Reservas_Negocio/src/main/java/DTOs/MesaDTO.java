package DTO;

import DTOs.RestauranteDTO;
import java.util.List;

public class MesaDTO {

    private String id;
    private String codigoMesa;
    private String tipoMesa;
    private int capacidadMinima;
    private int capacidadMaxima;
    private String ubicacion;
    private RestauranteDTO restaurante;  
    private List<ReservaDTO> reservas;

    public MesaDTO() {
    }

    public MesaDTO(String codigoMesa, String tipoMesa, int capacidadMinima, 
            int capacidadMaxima, String ubicacion, RestauranteDTO restaurante) {
        this.codigoMesa = codigoMesa;
        this.tipoMesa = tipoMesa;
        this.capacidadMinima = capacidadMinima;
        this.capacidadMaxima = capacidadMaxima;
        this.ubicacion = ubicacion;
        this.restaurante = restaurante;
    }

    public MesaDTO(String id, String codigoMesa, String tipoMesa, 
            int capacidadMinima, int capacidadMaxima, String ubicacion, 
            RestauranteDTO restaurante, List<ReservaDTO> reservas) {
        this.id = id;
        this.codigoMesa = codigoMesa;
        this.tipoMesa = tipoMesa;
        this.capacidadMinima = capacidadMinima;
        this.capacidadMaxima = capacidadMaxima;
        this.ubicacion = ubicacion;
        this.restaurante = restaurante;
        this.reservas = reservas;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
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

    public int getCapacidadMinima() {
        return capacidadMinima;
    }

    public void setCapacidadMinima(int capacidadMinima) {
        this.capacidadMinima = capacidadMinima;
    }

    public int getCapacidadMaxima() {
        return capacidadMaxima;
    }

    public void setCapacidadMaxima(int capacidadMaxima) {
        this.capacidadMaxima = capacidadMaxima;
    }

    public String getUbicacion() {
        return ubicacion;
    }

    public void setUbicacion(String ubicacion) {
        this.ubicacion = ubicacion;
    }

    public RestauranteDTO getRestaurante() {
        return restaurante;
    }

    public void setRestaurante(RestauranteDTO restaurante) {
        this.restaurante = restaurante;
    }

    public List<ReservaDTO> getReservas() {
        return reservas;
    }

    public void setReservas(List<ReservaDTO> reservas) {
        this.reservas = reservas;
    }

    @Override
    public String toString() {
        return "MesaDTO{" + "id=" + id + ", codigoMesa=" + codigoMesa + 
                ", tipoMesa=" + tipoMesa + ", capacidadMinima=" + 
                capacidadMinima + ", capacidadMaxima=" + capacidadMaxima + 
                ", ubicacion=" + ubicacion + ", restaurante=" + restaurante + 
                ", reservas=" + reservas + '}';
    }

}
