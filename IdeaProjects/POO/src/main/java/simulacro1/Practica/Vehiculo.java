package simulacro1.Practica;

public abstract class Vehiculo {
    int modelo;
    String marca;
    int numeroId;
    int litrosConsumidos;

    public Vehiculo(int modelo, String marca, int numeroId) {
        this.modelo = modelo;
        this.marca = marca;
        this.numeroId = numeroId;
    }

    public abstract int calcularConsumo(int distancia);






}
