package imp;

public abstract class Vehiculo {
    private int identificador;
    private String marcaVehiculo;
    private int kilometraje;

    public Vehiculo(int identificador, String marcaVehiculo, int kilometraje) {
        this.identificador = identificador;
        this.marcaVehiculo = marcaVehiculo;
        this.kilometraje = kilometraje;
    }

    public int getIdentificador() {
        return identificador;
    }

    public String getMarcaVehiculo() {
        return marcaVehiculo;
    }

    public int getKilometraje() {
        return kilometraje;
    }

    protected void imprimirDatos() {
        System.out.println("ID: " + identificador);
        System.out.println("Marca: " + marcaVehiculo);
        System.out.println("Kilometraje: " + kilometraje);
    }

    protected abstract String imprimitTipo();
}
