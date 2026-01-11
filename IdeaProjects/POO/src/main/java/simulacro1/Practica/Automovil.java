package simulacro1.Practica;

public class Automovil extends  Vehiculo{

    int numeroDePuertas;
    int litrosConsumidos =10;

    public Automovil(int modelo, String marca, int numeroId , int nroPuertas) {
        super(modelo, marca, numeroId);
        this.numeroDePuertas=nroPuertas;
    }

    public int getLitrosConsumidos() {
        return litrosConsumidos;
    }

    public int numeroDePuertas() {
        return this.numeroDePuertas;
    }

    public int getNumeroDePuertas() {
        return numeroDePuertas;
    }

    public void setNumeroDePuertas(int numeroDePuertas) {
        this.numeroDePuertas = numeroDePuertas;
    }

    @Override
    public String toString() {
        return "Automovil{" +
                "numeroDePuertas=" + numeroDePuertas +
                ", numeroId=" + numeroId +
                ", marca='" + marca + '\'' +
                ", modelo=" + modelo +
                '}';
    }

    @Override
    public int calcularConsumo(int distancia) {
        return   (distancia / 100) * litrosConsumidos;

    }
}
