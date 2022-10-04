package controller;

import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.google.gson.Gson;
import beans.Inmuebles;
import beans.Usuario;
import connection.DBConnection;

public class InmuebleController implements IInmuebleController {

    @Override
    public String listar(boolean ordenar, String orden) {

        Gson gson = new Gson();

        DBConnection con = new DBConnection();
        String sql = "Select * from inmueble";

        if (ordenar == true) {
            sql += " order by tipo_inmueble " + orden;
        }

        List<String> inmueble = new ArrayList<String>();

        try {

            Statement st = con.getConnection().createStatement();
            ResultSet rs = st.executeQuery(sql);

            while (rs.next()) {

                int id = rs.getInt("id");
                String tipo_inmueble = rs.getString("tipo_inmueble");
                int n_habitacion = rs.getInt("n_habitacion");
                int n_bano = rs.getInt("n_bano");
                String direccion_i = rs.getString("direccion_i");
                String patio = rs.getString("patio");
                String parqueadero = rs.getString("parqueadero");
                String telefono_i = rs.getString("telefono_i");
                String ciudad_i = rs.getString("ciudad_i");
                String comuna_i = rs.getString("comuna_i");
                double valor_alquiler = rs.getDouble("valor_alquiler");

                Inmuebles inmuebles = new Inmuebles(id, tipo_inmueble, n_habitacion, n_bano, direccion_i, patio, parqueadero, telefono_i, ciudad_i, comuna_i, valor_alquiler);

                inmueble.add(gson.toJson(inmuebles));

            }
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        } finally {
            con.desconectar();
        }

        return gson.toJson(inmueble);

    }

    public String cancelar(int id, String username) {

        DBConnection con = new DBConnection();
        String sql = "Delete from alquiler where id= " + id + " and username = '"
                + username + "' limit 1";

        try {
            Statement st = con.getConnection().createStatement();
            st.executeQuery(sql);

            this.sumarCantidad(id);

            return "true";
        } catch (Exception ex) {
            System.out.println(ex.toString());
        } finally {
            con.desconectar();
        }

        return "false";
    }

    @Override
    public String sumarCantidad(int id) {

        DBConnection con = new DBConnection();

        String sql = "Update inmuebles set tipo_inmueble = (Select  from inmuebles where id = "
                + id + ") + 1 where id = " + id;

        try {
            Statement st = con.getConnection().createStatement();
            st.executeUpdate(sql);

            return "true";
        } catch (Exception ex) {
            System.out.println(ex.toString());
        } finally {
            con.desconectar();
        }

        return "false";

    }

    @Override
    public String devolver(int id, String username) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    public String register(String tipo_inmueble, int n_habitaciones, int n_banos, String direccion_i, String patio,
            String parqueadero, String telefono_i, String ciudad_i, String comuna_i, double valor_alquiler) {
        Gson gson = new Gson();
        System.out.println("hola-----------------------------------");
        DBConnection con = new DBConnection();
        String sql = "Insert into inmueble values("+getId()+",'" + tipo_inmueble + "', " + n_habitaciones + ", " + n_banos
                + ", '" + direccion_i + "', '" + patio + "', '" + parqueadero + "', '" + telefono_i + "', '" + ciudad_i + "', '" + comuna_i + "', " + valor_alquiler + " )";
                System.out.println(sql);
        try {
            Statement st = con.getConnection().createStatement();
            st.executeUpdate(sql);

            Inmuebles inmueble = new Inmuebles(n_banos, tipo_inmueble, n_habitaciones, n_banos, direccion_i, patio, parqueadero, telefono_i, ciudad_i, comuna_i, valor_alquiler);
            st.close();

            return gson.toJson(inmueble);
        } catch (Exception ex) {
            System.out.println("error:"+ex.getMessage());

        } finally {
            con.desconectar();
        }

        return "false";

    }

    public InmuebleController() {
    }

    private Integer getId() {

        Integer id = null;

        DBConnection con = new DBConnection();
        String sql = "Select max(id) incrementable from inmueble";

        try {

            Statement st = con.getConnection().createStatement();
            ResultSet rs = st.executeQuery(sql);

            while (rs.next()) {
                id = rs.getInt("incrementable");
            }
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        } finally {
            con.desconectar();
        }
        return id == null ? 1 : id + 1;

    }
}
