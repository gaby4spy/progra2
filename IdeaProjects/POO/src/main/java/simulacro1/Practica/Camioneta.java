package simulacro1.Practica;

public class Camioneta extends Vehiculo {

    double capacidadCarga;
    int litrosConsumidos =15;

    public Camioneta(int modelo, String marca, int numeroId, double capacidadCarga) {
        super(modelo, marca, numeroId);
        this.capacidadCarga = capacidadCarga;
    }

    public double getCapacidadCarga() {
        return capacidadCarga;
    }

    public void setCapacidadCarga(double capacidadCarga) {
        this.capacidadCarga = capacidadCarga;
    }

    public int getLitrosConsumidos() {
        return litrosConsumidos;
    }

    @Override
    public int calcularConsumo(int distancia) {
      return (distancia / 100) * litrosConsumidos;

    }

    @Override
    public String toString() {
        return "Camioneta{" +
                "capacidadCarga=" + capacidadCarga +
                ", marca='" + marca + '\'' +
                ", modelo=" + modelo +
                ", numeroId=" + numeroId +
                '}';
    }
}
