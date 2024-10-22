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
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "clientes")
public class Cliente implements Serializable{
    
    private static final long serialVersionUID = 1L;
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @Column(name = "nombre",nullable = false)
    private String nombre;
    
    @Column(name = "telefono", nullable = false, unique = true)
    private String telefono;
    
    @OneToMany(mappedBy = "clientes", cascade = CascadeType.PERSIST)
    private List<Reserva> reservas;

    /**
     * 
     */
    public Cliente() {
    }

    /**
     * 
     * @param nombreCompleto
     * @param telefono
     * @param reservas 
     */
    public Cliente(String nombreCompleto, String telefono, 
            List<Reserva> reservas) {
        this.nombre = nombreCompleto;
        this.telefono = telefono;
        this.reservas = reservas;
    }

    /**
     * 
     * @param id
     * @param nombreCompleto
     * @param telefono
     * @param reservas 
     */
    public Cliente(Long id, String nombreCompleto, String telefono, 
            List<Reserva> reservas) {
        this.id = id;
        this.nombre = nombreCompleto;
        this.telefono = telefono;
        this.reservas = reservas;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombreCompleto() {
        return nombre;
    }

    public void setNombreCompleto(String nombre) {
        this.nombre = nombre;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public List<Reserva> getReservas() {
        return reservas;
    }

    public void setReservas(List<Reserva> reservas) {
        this.reservas = reservas;
    }

    @Override
    public String toString() {
        return "Cliente{" + "id=" + id + ", nombreCompleto=" + nombre + 
                ", telefono=" + telefono + ", reservas=" + reservas + '}';
    }
    
}
