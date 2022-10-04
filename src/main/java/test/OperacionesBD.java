package test;

import beans.Inmuebles;
import connection.DBConnection;
import java.sql.ResultSet;
import java.sql.Statement;

public class OperacionesBD {

    public static void main(String[] args) {
        actualizarInmueble(1, "Casa");   
        listarInmueble();
    }

    public static void actualizarInmueble(int id, String tipo_inmueble) {
        DBConnection con = new DBConnection();
        String sql = "UPDATE inmueble SET tipo_inmueble ='" + tipo_inmueble + "'WHERE id = " + id;
        try {
            Statement st = con.getConnection().createStatement();
            st.executeUpdate(sql);
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        } finally {
            con.desconectar();
        }
    }

    public static void listarInmueble() {
        DBConnection con = new DBConnection();
        String sql = "SELECT * FROM inmueble";
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
                System.out.println(inmuebles.toString());

            }
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        } finally {
            con.desconectar();
        }
    }
}
