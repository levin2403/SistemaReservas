package DTO;

import DTOs.RestauranteDTO;
import java.time.LocalDateTime;

public class ReservaDTO {

    private String id;
    private LocalDateTime fechaHoraReserva;
    private int numeroPersonas;
    private double costo;
    private String estado;
    private double multa;
    private ClienteDTO cliente;
    private MesaDTO mesa;
    private RestauranteDTO restaurante;
    

    public ReservaDTO() {
    }

    public ReservaDTO(LocalDateTime fechaHoraReserva, int numeroPersonas, 
            double costo, String estado, double multa, ClienteDTO cliente, 
            MesaDTO mesa, RestauranteDTO restaurante) {
        this.fechaHoraReserva = fechaHoraReserva;
        this.numeroPersonas = numeroPersonas;
        this.costo = costo;
        this.estado = estado;
        this.multa = multa;
        this.cliente = cliente;
        this.mesa = mesa;
        this.restaurante = restaurante;
    }

    public ReservaDTO(String id, LocalDateTime fechaHoraReserva, 
            int numeroPersonas, double costo, String estado, double multa, 
            ClienteDTO cliente, MesaDTO mesa, RestauranteDTO restaurante) {
        this.id = id;
        this.fechaHoraReserva = fechaHoraReserva;
        this.numeroPersonas = numeroPersonas;
        this.costo = costo;
        this.estado = estado;
        this.multa = multa;
        this.cliente = cliente;
        this.mesa = mesa;
        this.restaurante = restaurante;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
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

    public double getMulta() {
        return multa;
    }

    public void setMulta(double multa) {
        this.multa = multa;
    }

    public ClienteDTO getCliente() {
        return cliente;
    }

    public void setCliente(ClienteDTO cliente) {
        this.cliente = cliente;
    }

    public MesaDTO getMesa() {
        return mesa;
    }

    public void setMesa(MesaDTO mesa) {
        this.mesa = mesa;
    }

    public RestauranteDTO getRestaurante() {
        return restaurante;
    }

    public void setRestaurante(RestauranteDTO restaurante) {
        this.restaurante = restaurante;
    }

    @Override
    public String toString() {
        return "ReservaDTO{" + "id=" + id + ", fechaHoraReserva=" + 
                fechaHoraReserva + ", numeroPersonas=" + numeroPersonas + 
                ", costo=" + costo + ", estado=" + estado + ", multa=" + 
                multa + ", cliente=" + cliente + ", mesa=" + mesa + 
                ", restaurante=" + restaurante + '}';
    }

}
