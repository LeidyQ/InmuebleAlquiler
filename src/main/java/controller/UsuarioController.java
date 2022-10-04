package controller;

import java.sql.ResultSet;
import java.sql.Statement;
import com.google.gson.Gson;

import beans.Usuario;
import connection.DBConnection;
import java.util.HashMap;
import java.util.Map;

public class UsuarioController implements IUsuarioController {

    @Override
    public String login(String username, String contrasena) {

        Gson gson = new Gson();

        DBConnection con = new DBConnection();

        String sql = "Select * from usuario where username = '" + username
                + "' and contrasena = '" + contrasena + "'";
        try {
            Statement st = con.getConnection().createStatement();
            ResultSet rs = st.executeQuery(sql);

            while (rs.next()) {
                String nombre = rs.getString("nombre");
                String apellidos = rs.getString("apellidos");
                String telefono = rs.getString("telefono");
                String email = rs.getString("email");
                String direccion_u = rs.getString("direccion_u");
                String ciudad_u = rs.getString("ciudad_u");
                String tipo_u = rs.getString("tipo_u");

                

                Usuario usuario
                        = new Usuario(username, contrasena, nombre, apellidos, telefono, email, direccion_u, ciudad_u, tipo_u);
                return gson.toJson(usuario);
            }
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        } finally {
            con.desconectar();
        }

        return "false";
    }
    
     public String register(String username, String contrasena, String nombre, String apellidos, String telefono,
            String email, String direccion_u, String ciudad_u, String tipo_u) {
        Gson gson = new Gson();

          DBConnection con = new DBConnection();
        String sql = "Insert into usuario values('" + username + "', '" + contrasena + "', '" + nombre
                + "', '" + apellidos + "', '" + telefono + "', '" + email + "', '" + direccion_u + "', '" + ciudad_u + "', '" + tipo_u + "')";
        try {
            Statement st = con.getConnection().createStatement();
            st.executeUpdate(sql);

            Usuario usuario = new Usuario(username, contrasena, nombre, apellidos, telefono, email, direccion_u, ciudad_u, tipo_u);

            st.close();

            return gson.toJson(usuario);
        } catch (Exception ex) {
            System.out.println(ex.getMessage());

        } finally {
            con.desconectar();
        }

        return "false";

    }

    @Override
    public String pedir(String username) {

        Gson gson = new Gson();

        DBConnection con = new DBConnection();
        String sql = "Select * from usuario where username = '" + username + "'";

        try {

            Statement st = con.getConnection().createStatement();
            ResultSet rs = st.executeQuery(sql);

            while (rs.next()) {
                String contrasena = rs.getString("contrasena");
                String nombre = rs.getString("nombre");
                String apellidos = rs.getString("apellidos");
                String telefono = rs.getString("telefono");
                String email = rs.getString("email");
                String direccion_u = rs.getString("direccion_u");
                String ciudad_u = rs.getString("ciudad_u");
                String tipo_u = rs.getString("tipo_u");

                Usuario usuario = new Usuario(username, contrasena,
                        nombre, apellidos, telefono, email, direccion_u, ciudad_u, tipo_u);

                return gson.toJson(usuario);
            }
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        } finally {
            con.desconectar();
        }

        return "false";
    }

    @Override
    public String modificar(String username, String nuevaContrasena,
            String nuevoNombre, String nuevosApellidos, String nuevoTelefono,
            String nuevoEmail, String nuevaDireccion_u, String nuevaCiudad_u, String nuevoTipo_u) {

        DBConnection con = new DBConnection();

        String sql = "Update usuario set contrasena = '" + nuevaContrasena
                + "', nombre = '" + nuevoNombre + "', "
                + "apellidos = '" + nuevosApellidos + "', telefono = '" + nuevoTelefono + "', email = '"
                + nuevoEmail + "', direccion_u = '" + nuevaDireccion_u + "', ciudad_u = '"+ nuevaCiudad_u +"' ";

        sql += " where username = '" + username + "'";
                
        System.out.println(sql);

        try {

            Statement st = con.getConnection().createStatement();
            st.executeUpdate(sql);

            return "true";
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        } finally {
            con.desconectar();
        }

        return "false";

    }

    @Override
    public String verInmuebles(String username) {

        DBConnection con = new DBConnection();
        String sql = "Select id,count(*) as num_n_habitacion from alquiler where username = '"
                + username + "' group by id;";

        Map<Integer, Integer> n_habitacion = new HashMap<Integer, Integer>();

        try {

            Statement st = con.getConnection().createStatement();
            ResultSet rs = st.executeQuery(sql);

            while (rs.next()) {
                int id = rs.getInt("id");
                int num_n_habitacion = rs.getInt("num_n_habitacion");

                n_habitacion.put(id, num_n_habitacion);
            }

            cancelarInmuebles(username, n_habitacion);

            return "true";
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        } finally {
            con.desconectar();
        }

        return "false";

    }

    @Override
    public String cancelarInmuebles(String username, Map<Integer, Integer> n_habitacion) {

        DBConnection con = new DBConnection();

        try {
            for (Map.Entry<Integer, Integer> inmueble : n_habitacion.entrySet()) {
                int id = inmueble.getKey();
                int num_n_habbitacion = inmueble.getValue();

                String sql = "Update inmueble set n_habitacion = (Select n_habitacion + " + n_habitacion
                        + " from inmueble where id = " + id + ") where id = " + id;

                Statement st = con.getConnection().createStatement();
                st.executeUpdate(sql);

            }

            this.eliminar(username);
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        } finally {
            con.desconectar();
        }
        return "false";
    }

    public String eliminar(String username) {

        DBConnection con = new DBConnection();

        String sql1 = "Delete from alquiler where username = '" + username + "'";
        String sql2 = "Delete from usuario where username = '" + username + "'";

        try {
            Statement st = con.getConnection().createStatement();
            st.executeUpdate(sql1);
            st.executeUpdate(sql2);

            return "true";
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        } finally {
            con.desconectar();
        }

        return "false";
    }

   
}
    