package controller;

public interface IInmuebleController {

    public String listar(boolean ordenar, String orden);

    public String devolver(int id, String username);

    public String sumarCantidad(int id);
    
    public String register(String tipo_inmueble, int n_habitaciones, int n_banos, String direccion_i, String patio,
            String parqueadero, String telefono_i, String ciudad_i, String comuna_i, double valor_alquiler);
    
}
