package controller;

import java.sql.Date;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import java.util.List;

import com.google.gson.Gson;

import beans.Alquiler;
import connection.DBConnection;

public class AlquilerController implements IAlquilerController {

    @Override
    public String listarAlquileres(String username) {

        Gson gson = new Gson();

        DBConnection con = new DBConnection();

        String sql = "Select l.id, l.tipo_inmueble, l.direccion_i, l.telefono_i, a.fecha from inmueble l "
                + "inner join alquiler a on l.id = a.id inner join usuario u on a.username = u.username "
                + "where a.username = '" + username + "'";

        List<String> alquileres = new ArrayList<String>();

        try {

            Statement st = con.getConnection().createStatement();
            ResultSet rs = st.executeQuery(sql);

            while (rs.next()) {
                int id = rs.getInt("id");
                String tipo_inmueble = rs.getString("tipo_inmueble");
                String direccion_i = rs.getString("direccion_i");
                String telefono_i = rs.getString("telefono_i");
                Date fechaAlquiler= rs.getDate("fecha");

                Alquiler alquiler = new Alquiler(id, tipo_inmueble, direccion_i, telefono_i, fechaAlquiler);

                alquileres.add(gson.toJson(alquiler));
            }
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        } finally {
            con.desconectar();
        }
        return gson.toJson(alquileres);
    }
}