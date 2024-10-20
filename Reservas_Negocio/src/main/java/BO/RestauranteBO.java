package BO;

public class RestauranteBO {

    private Long id;
    private String nombre;
    private String direccion;
    private String telefono;
    private String email;
    private String datosContactoEncriptados;

    public RestauranteBO() {}

    public RestauranteBO(Long id, String nombre, String direccion, String telefono, 
                         String email, String datosContactoEncriptados) {
        this.id = id;
        this.nombre = nombre;
        this.direccion = direccion;
        this.telefono = telefono;
        this.email = email;
        this.datosContactoEncriptados = datosContactoEncriptados;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getDatosContactoEncriptados() {
        return datosContactoEncriptados;
    }

    public void setDatosContactoEncriptados(String datosContactoEncriptados) {
        this.datosContactoEncriptados = datosContactoEncriptados;
    }

  
}
