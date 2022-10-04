package beans;

public class Inmuebles {
    private int id;
    private String tipo_inmueble;
    private int n_habitacion;
    private int n_bano;
    private String direccion_i;
    private String patio;
    private String parqueadero;
    private String telefono_i;
    private String ciudad_i;
    private String comuna_i;
    private double valor_alquiler;

    public Inmuebles(int id, String tipo_inmueble, int n_habitacion, int n_bano, String direccion_i, String patio, String parqueadero, String telefono_i, String ciudad_i, String comuna_i, double valor_alquiler) {
        this.id = id;
        this.tipo_inmueble = tipo_inmueble;
        this.n_habitacion = n_habitacion;
        this.n_bano = n_bano;
        this.direccion_i = direccion_i;
        this.patio = patio;
        this.parqueadero = parqueadero;
        this.telefono_i = telefono_i;
        this.ciudad_i = ciudad_i;
        this.comuna_i = comuna_i;
        this.valor_alquiler = valor_alquiler;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTipo_inmueble() {
        return tipo_inmueble;
    }

    public void setTipo_inmueble(String tipo_inmueble) {
        this.tipo_inmueble = tipo_inmueble;
    }

    public int getN_habitacion() {
        return n_habitacion;
    }

    public void setN_habitacion(int n_habitacion) {
        this.n_habitacion = n_habitacion;
    }

    public int getN_bano() {
        return n_bano;
    }

    public void setN_bano(int n_bano) {
        this.n_bano = n_bano;
    }

    public String getDireccion_i() {
        return direccion_i;
    }

    public void setDireccion_i(String direccion_i) {
        this.direccion_i = direccion_i;
    }

    public String getPatio() {
        return patio;
    }

    public void setPatio(String patio) {
        this.patio = patio;
    }

    public String getParqueadero() {
        return parqueadero;
    }

    public void setParqueadero(String parqueadero) {
        this.parqueadero = parqueadero;
    }

    public String getTelefono_i() {
        return telefono_i;
    }

    public void setTelefono_i(String telefono_i) {
        this.telefono_i = telefono_i;
    }

    public String getCiudad_i() {
        return ciudad_i;
    }

    public void setCiudad_i(String ciudad_i) {
        this.ciudad_i = ciudad_i;
    }

    public String getComuna_i() {
        return comuna_i;
    }

    public void setComuna_i(String comuna_i) {
        this.comuna_i = comuna_i;
    }

    public double getValor_alquiler() {
        return valor_alquiler;
    }

    public void setValor_alquiler(double valor_alquiler) {
        this.valor_alquiler = valor_alquiler;
    }

    @Override
    public String toString() {
        return "Inmuebles{" + "id=" + id + ", tipo_inmueble=" + tipo_inmueble + ", n_habitacion=" + n_habitacion + ", n_bano=" + n_bano + ", direccion_i=" + direccion_i + ", patio=" + patio + ", parqueadero=" + parqueadero + ", telefono_i=" + telefono_i + ", ciudad_i=" + ciudad_i + ", comuna_i=" + comuna_i + ", valor_alquiler=" + valor_alquiler + '}';
    }

    
}
