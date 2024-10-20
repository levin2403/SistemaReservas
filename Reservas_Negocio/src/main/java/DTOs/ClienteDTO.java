package DTO;

/**
 * Objeto de transferencia de datos para el cliente.
 * 
 * Se usa para transferir datos entre la capa de presentación y la capa de negocio.
 * 
 * @author skevi
 * @author sebastian
 */
public class ClienteDTO {

    private Long id;
    private String nombreCompleto;
    private String telefono;

    // Constructor por defecto
    public ClienteDTO() {
    }

    // Constructor con parámetros
    public ClienteDTO(Long id, String nombreCompleto, String telefono) {
        this.id = id;
        this.nombreCompleto = nombreCompleto;
        this.telefono = telefono;
    }

    // Getters y Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombreCompleto() {
        return nombreCompleto;
    }

    public void setNombreCompleto(String nombreCompleto) {
        this.nombreCompleto = nombreCompleto;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    @Override
    public String toString() {
        return "ClienteDTO{" + "id=" + id + ", nombreCompleto=" + nombreCompleto + ", telefono=" + telefono + '}';
    }
}
