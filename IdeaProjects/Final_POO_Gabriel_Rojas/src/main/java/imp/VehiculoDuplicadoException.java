package imp;


public class VehiculoDuplicadoException extends Exception {
    public VehiculoDuplicadoException(int id) {
        super("ERROR: Ya existe un vehículo con el ID " + id);
    }
}
