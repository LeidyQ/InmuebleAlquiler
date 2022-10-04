package beans;

public class Usuario {
    private String username;
    private String contrasena;
    private String nombre;
    private String apellidos;
    private String telefono;
    private String email;
    private String direccion_u;
    private String ciudad_u;
    private String tipo_u;

    public Usuario(String username, String contrasena, String nombre, String apellidos, String telefono, String email, String direccion_u, String ciudad_u, String tipo_u) {
        this.username = username;
        this.contrasena = contrasena;
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.telefono = telefono;
        this.email = email;
        this.direccion_u = direccion_u;
        this.ciudad_u = ciudad_u;
        this.tipo_u = tipo_u;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getContrasena() {
        return contrasena;
    }

    public void setContrasena(String contrasena) {
        this.contrasena = contrasena;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
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

    public String getDireccion_u() {
        return direccion_u;
    }

    public void setDireccion_u(String direccion_u) {
        this.direccion_u = direccion_u;
    }

    public String getCiudad_u() {
        return ciudad_u;
    }

    public void setCiudad_u(String ciudad_u) {
        this.ciudad_u = ciudad_u;
    }

    public String getTipo_u() {
        return tipo_u;
    }

    public void setTipo_u(String tipo_u) {
        this.tipo_u = tipo_u;
    }

    @Override
    public String toString() {
        return "Usuario{" + "username=" + username + ", contrasena=" + contrasena + ", nombre=" + nombre + ", apellidos=" + apellidos + ", telefono=" + telefono + ", email=" + email + ", direccion_u=" + direccion_u + ", ciudad_u=" + ciudad_u + ", tipo_u=" + tipo_u + '}';
    }

    
    
}

   