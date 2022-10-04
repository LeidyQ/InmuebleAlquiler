package beans;

import java.sql.Date;

public class Alquiler {
    private int id;
    private String username;
    private String tipo_contrato;
    private double valor_alquiler;
    private Date fecha;
   

    public Alquiler(int id, String username, String tipo_contrato, double valor_alquiler, Date fecha) {
        this.id = id;
        this.username = username;
        this.tipo_contrato = tipo_contrato;
        this.valor_alquiler = valor_alquiler;
        this.fecha = fecha;
       
    }

    public Alquiler(int id, String tipo_inmueble, String direccion_i, String telefono_i, Date fechaAlquiler) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getTipo_contrato() {
        return tipo_contrato;
    }

    public void setTipo_contrato(String tipo_contrato) {
        this.tipo_contrato = tipo_contrato;
    }

    public double getValor_alquiler() {
        return valor_alquiler;
    }

    public void setValor_alquiler(double valor_alquiler) {
        this.valor_alquiler = valor_alquiler;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    
   
    @Override
    public String toString() {
        return "Alquiler{" + "id=" + id + ", username=" + username + ", tipo_contrato=" + tipo_contrato + ", valor_alquiler=" + valor_alquiler + ", fecha=" + fecha + '}';
    }
    
    
    
}
