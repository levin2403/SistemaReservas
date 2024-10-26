package DTOs;

import java.util.ArrayList;
import java.util.List;

/**
 * Objeto de transferencia de datos para el cliente.
 *
 * Se usa para transferir datos entre la capa de presentación y la capa de
 * negocio.
 *
 * @author skevi
 * @author sebastian
 */
public class ClienteDTO {
    private String id;
    private String nombre;
    private String telefono;
    private List<ReservaDTO> reservas; // Incluido

    // Constructor por defecto
    public ClienteDTO() {
    }

    public ClienteDTO(String nombre, String telefono) {
        this.nombre = nombre;
        this.telefono = telefono;
        this.reservas = new ArrayList<>(); // Inicializar lista vacía
    }

    public ClienteDTO(String id, String nombre, String telefono, List<ReservaDTO> reservas) {
        this.id = id;
        this.nombre = nombre;
        this.telefono = telefono;
        this.reservas = reservas != null ? reservas : new ArrayList<>(); // Inicializar lista
    }


    // Getters y Setters
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }


   @Override
    public String toString() {
        return "ClienteDTO{" + "id=" + id + ", nombre=" + nombre + 
               ", telefono=" + telefono + ", reservas=" + reservas.size() + '}';
    }

}
