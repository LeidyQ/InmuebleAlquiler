package controller;

import java.util.Map;

public interface IUsuarioController {

    public String login(String username, String contrasena);

    public String register(String username, String contrasena,
            String nombre, String apellidos, String telefono, String email, String direccion_u, String ciudad_u, String tipo_u);

    public String pedir(String username);

    public String modificar(String username, String nuevaContrasena,
            String nuevoNombre, String nuevosApellidos, String nuevoTelefono,
            String nuevoEmail, String nuevaDireccion_u, String nuevaCiudad_u, String nuevoTipo_u);

    public String verInmuebles(String username);

    public String cancelarInmuebles(String username, Map<Integer, Integer> copias);

    public String eliminar(String username);
}
