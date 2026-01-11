package imp;

public class VehiculoNoEncontradoException extends Exception {
    public VehiculoNoEncontradoException(int id) {
        super("ERROR: No se encontró ningún vehículo con el ID " + id);
    }
}
