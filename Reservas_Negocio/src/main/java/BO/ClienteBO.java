package BO;

/**
 * Clase que maneja la lógica de negocio para los clientes.
 *
 * @author skevi
 * @author sebastian
 */
public class ClienteBO {

    private Long id;
    private String nombreCompleto;
    private String telefono;

    public ClienteBO() {
    }

    public ClienteBO(Long id, String nombreCompleto, String telefono) {
        this.id = id;
        this.nombreCompleto = nombreCompleto;
        this.telefono = telefono;
    }

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

}
