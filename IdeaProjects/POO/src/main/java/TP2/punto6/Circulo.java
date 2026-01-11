package TP2.punto6;

public class Circulo extends Figura{

    int radio;

    public Circulo(int radio) {
        this.radio = radio;
    }

    @Override
    public double calcularArea() {
        return 3.1416 * radio *radio;
    }
}
