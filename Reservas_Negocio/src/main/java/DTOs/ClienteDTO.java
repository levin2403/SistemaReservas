package DTOs;

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

    // Constructor por defecto
    public ClienteDTO() {
    }

    /**
     * 
     * @param nombre
     * @param telefono 
     */
    public ClienteDTO(String nombre, String telefono) {
        this.nombre = nombre;
        this.telefono = telefono;
    }

    /**
     * 
     * @param id
     * @param nombre
     * @param telefono
     * @param reservas 
     */
    public ClienteDTO(String id, String nombre, String telefono, 
            List<ReservaDTO> reservas) {
        this.id = id;
        this.nombre = nombre;
        this.telefono = telefono;
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
        return  nombre + ", " + telefono;
    }

}
